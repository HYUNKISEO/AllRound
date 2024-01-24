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


    @Scheduled(cron = "0 0 0 1 * *")
    public void autoSave() {
        testinfoRepository.deleteAll();

        String baseUri = "http://openapi.q-net.or.kr/api/service/rest/InquiryTestInformationNTQSVC/getJMList?";

        URI uri = UriComponentsBuilder
                .fromUriString(baseUri)
                .queryParam("jmCd", 1320)
                .queryParam("serviceKey", apikey)
                .build(true)
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TestinfoResponse> responseEntity = restTemplate.getForEntity(uri, TestinfoResponse.class);

        List<Testinfo> testinfoList = responseEntity.getBody().getResponse().getBody().getItems().getItem();

        testinfoRepository.saveAll(testinfoList);

        URI uri2 = UriComponentsBuilder
                .fromUriString(baseUri)
                .queryParam("jmCd", 2290)
                .queryParam("serviceKey", apikey)
                .build(true)
                .toUri();

        RestTemplate restTemplate2 = new RestTemplate();
        ResponseEntity<TestinfoResponse> responseEntity2 = restTemplate2.getForEntity(uri2, TestinfoResponse.class);

        List<Testinfo> testinfoList2 = responseEntity2.getBody().getResponse().getBody().getItems().getItem();

        testinfoRepository.saveAll(testinfoList2);

        URI uri3 = UriComponentsBuilder
                .fromUriString(baseUri)
                .queryParam("jmCd", 6921)
                .queryParam("serviceKey", apikey)
                .build(true)
                .toUri();

        RestTemplate restTemplate3 = new RestTemplate();
        ResponseEntity<TestinfoResponse> responseEntity3 = restTemplate3.getForEntity(uri3, TestinfoResponse.class);

        List<Testinfo> testinfoList3 = responseEntity3.getBody().getResponse().getBody().getItems().getItem();

        testinfoRepository.saveAll(testinfoList3);

        String baseUri2 = "http://openapi.q-net.or.kr/api/service/rest/InquiryTestInformationNTQSVC/getFeeList?";

        URI uri4 = UriComponentsBuilder
                .fromUriString(baseUri2)
                .queryParam("serviceKey", apikey)
                .queryParam("jmCd", 1320)
                .build(true)
                .toUri();

        RestTemplate restTemplate4 = new RestTemplate();
        ResponseEntity<TestinfoResponse> responseEntity4 = restTemplate4.getForEntity(uri4, TestinfoResponse.class);

        List<Testinfo> testinfoList4 = responseEntity4.getBody().getResponse().getBody().getItems().getItem();

        testinfoRepository.saveAll(testinfoList4);

        URI uri5 = UriComponentsBuilder
                .fromUriString(baseUri2)
                .queryParam("serviceKey", apikey)
                .queryParam("jmCd", 2290)
                .build(true)
                .toUri();

        RestTemplate restTemplate5 = new RestTemplate();
        ResponseEntity<TestinfoResponse> responseEntity5 = restTemplate5.getForEntity(uri5, TestinfoResponse.class);

        List<Testinfo> testinfoList5 = responseEntity5.getBody().getResponse().getBody().getItems().getItem();

        testinfoRepository.saveAll(testinfoList5);

        URI uri6 = UriComponentsBuilder
                .fromUriString(baseUri2)
                .queryParam("serviceKey", apikey)
                .queryParam("jmCd", 2290)
                .build(true)
                .toUri();

        RestTemplate restTemplate6 = new RestTemplate();
        ResponseEntity<TestinfoResponse> responseEntity6 = restTemplate6.getForEntity(uri6, TestinfoResponse.class);

        List<Testinfo> testinfoList6 = responseEntity6.getBody().getResponse().getBody().getItems().getItem();

        testinfoRepository.saveAll(testinfoList6);

    } // end autoSave

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
