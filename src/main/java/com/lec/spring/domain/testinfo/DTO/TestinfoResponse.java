package com.lec.spring.domain.testinfo.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lec.spring.domain.testinfo.Testinfo;
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
        @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
        private List<Testinfo> item;
    }

}
