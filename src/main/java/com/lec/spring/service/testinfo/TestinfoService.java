package com.lec.spring.service.testinfo;

import com.lec.spring.domain.testinfo.BookRequest;
import com.lec.spring.domain.testinfo.Testinfo;
import com.lec.spring.domain.testinfo.TestinfoResponse;
import com.lec.spring.repository.testinfo.TestinfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestinfoService {

    private final TestinfoRepository testinfoRepository;

    @Value("${public.key}")
    private String apikey;

    @Value("${naver.clientid}")
    private String clientId;

    @Value("${naver.clientsecret}")
    private String clientSecret;

/*
* 자동진행 메소드에 매게변수를 담아서 전달한다.
* buildUri 를 통해 중복코드 제거
* retrieveAndSaveTestinfo 와 retrieveAndSaveFeeList 재호출되면서 작동함으로 중복코드 한반더  제거
*/
    @Scheduled(cron = "0 0 0 1 * *")
    public void autoSave() {
        testinfoRepository.deleteAll();

        List<Testinfo> testInfo1 = retrieveAndSaveTestinfo(1320);
        retrieveAndSaveFeeList(1320, testInfo1);

        List<Testinfo> testInfo2 = retrieveAndSaveTestinfo(2290);
        retrieveAndSaveFeeList(2290, testInfo2);

        List<Testinfo> testInfo3 = retrieveAndSaveTestinfo(6921);
        retrieveAndSaveFeeList(6921, testInfo3);
    }

    private List<Testinfo> retrieveAndSaveTestinfo(int jmCd) {
        String baseUri = "http://openapi.q-net.or.kr/api/service/rest/InquiryTestInformationNTQSVC/getJMList?";
        URI uri = buildUri(baseUri, jmCd);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TestinfoResponse> responseEntity = restTemplate.getForEntity(uri, TestinfoResponse.class);

        List<Testinfo> testinfoList = responseEntity.getBody().getResponse().getBody().getItems().getItem();

        return testinfoRepository.saveAll(testinfoList);
    }

    private void retrieveAndSaveFeeList(int jmCd, List<Testinfo> testinfo) {
        String baseUri = "http://openapi.q-net.or.kr/api/service/rest/InquiryTestInformationNTQSVC/getFeeList?";
        URI uri = buildUriForFeeList(baseUri, jmCd);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TestinfoResponse> responseEntity = restTemplate.getForEntity(uri, TestinfoResponse.class);

        List<Testinfo> testinfoList = responseEntity.getBody().getResponse().getBody().getItems().getItem();

        testinfoList.forEach(e -> {
            for(Testinfo info: testinfo){
                info.setContents(e.getContents());
            }
        });

        testinfoRepository.saveAll(testinfo);
    }

    private URI buildUri(String baseUri, int jmCd) {
        return UriComponentsBuilder
                .fromUriString(baseUri)
                .queryParam("jmCd", jmCd)
                .queryParam("serviceKey", apikey)
                .build(true)
                .toUri();
    }

    private URI buildUriForFeeList(String baseUri, int jmCd) {
        return UriComponentsBuilder
                .fromUriString(baseUri)
                .queryParam("serviceKey", apikey)
                .queryParam("jmCd", jmCd)
                .build(true)
                .toUri();
    }


    public String naverBook (BookRequest bookRequest) {

        String baseUri = "https://openapi.naver.com/v1/search/book_adv.json";

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", clientId);
        headers.set("X-Naver-Client-Secret", clientSecret);

        URI uri = UriComponentsBuilder
                .fromUriString(baseUri)
                .queryParam("d_titl", URLEncoder.encode(bookRequest.getKeyword(),  StandardCharsets.UTF_8))
                .queryParam("display", 10)
                .queryParam("sort", "date")
                .build(true)
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri)
                .headers(headers)
                .build();

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.exchange(requestEntity, String.class).getBody();

        return response;
    }

    public List<Testinfo> test(){
        return testinfoRepository.findAll();
    }

}
