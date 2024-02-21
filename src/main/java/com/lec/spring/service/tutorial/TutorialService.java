package com.lec.spring.service.tutorial;

import com.lec.spring.domain.Tutorial.YoutubeRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TutorialService {

    @Value("${youtube.key}")
    private String apiKey;

    public String searchYouTubeVideos(YoutubeRequest youtubeRequest) {
        String apiUrl = "https://www.googleapis.com/youtube/v3/search";

        // YouTube API 요청에 필요한 파라미터 설정
        String part = "snippet";
        String chart = "mostPopular";
        int maxResults = 20;
        String regionCode = "kr";
        String type = "video";

        // YouTube API에 보낼 쿼리 생성
        String queryString = String.format("part=%s&chart=%s&maxResults=%d&regionCode=%s&q=%s&type=%s&key=%s",
                part, chart, maxResults, regionCode, youtubeRequest.getKeyword() + " 강의", type, apiKey);

        // 최종 API 요청 URL 생성
        String requestUrl = apiUrl + "?" + queryString;

        // RestTemplate을 사용하여 API에 GET 요청
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(requestUrl, String.class);

        return response;
    }
}
