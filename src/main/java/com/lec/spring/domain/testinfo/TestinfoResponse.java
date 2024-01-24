package com.lec.spring.domain.testinfo;

import lombok.Data;

import java.util.List;

@Data
public class TestinfoResponse {
    private Response response;

    @Data
    public static class Response {
        private Body body;
    }

    @Data
    public static class Body {
        private Items items;
    }

    @Data
    public static class Items {
        private List<Testinfo> item;
    }
}
