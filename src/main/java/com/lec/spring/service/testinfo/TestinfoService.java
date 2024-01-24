package com.lec.spring.service.testinfo;

import com.lec.spring.domain.testinfo.Testinfo;
import com.lec.spring.domain.testinfo.TestinfoResponse;
import com.lec.spring.repository.testinfo.TestinfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestinfoService {

    private final TestinfoRepository testinfoRepository;

    @Value("${public.key}")
    private String apikey;


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
    }

}
