package com.lec.spring.service.testinfo;

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

import javax.swing.text.html.parser.Entity;
import java.net.URI;
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

        retrieveAndSaveTestinfo(1320);
        retrieveAndSaveFeeList(1320);

        retrieveAndSaveTestinfo(2290);
        retrieveAndSaveFeeList(2290);

        retrieveAndSaveTestinfo(6921);
        retrieveAndSaveFeeList(6921);
    }

    private void retrieveAndSaveTestinfo(int jmCd) {
        String baseUri = "http://openapi.q-net.or.kr/api/service/rest/InquiryTestInformationNTQSVC/getJMList?";
        URI uri = buildUri(baseUri, jmCd);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TestinfoResponse> responseEntity = restTemplate.getForEntity(uri, TestinfoResponse.class);

        List<Testinfo> testinfoList = responseEntity.getBody().getResponse().getBody().getItems().getItem();

        testinfoRepository.saveAll(testinfoList);
    }

    private void retrieveAndSaveFeeList(int jmCd) {
        String baseUri = "http://openapi.q-net.or.kr/api/service/rest/InquiryTestInformationNTQSVC/getFeeList?";
        URI uri = buildUriForFeeList(baseUri, jmCd);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TestinfoResponse> responseEntity = restTemplate.getForEntity(uri, TestinfoResponse.class);

        List<Testinfo> testinfoList = responseEntity.getBody().getResponse().getBody().getItems().getItem();

        testinfoRepository.saveAll(testinfoList);
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


    public String naverBook () {

        String baseUri = "https://openapi.naver.com/v1/search/book_adv.json";

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", clientId);
        headers.set("X-Naver-Client-Secret", clientSecret);

        URI uri = UriComponentsBuilder
                .fromUriString(baseUri)
                .queryParam("display", 10)
                .queryParam("sort", "date")
                .queryParam("d_title", "정보처리기사")
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri)
                .headers(headers)
                .build();

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.exchange(requestEntity, String.class).getBody();

        return response;
    }
}
