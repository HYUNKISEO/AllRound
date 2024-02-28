package com.lec.spring.domain.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShareDto {

    private Long id;
    private String question;
    private String exampleInput;
    private String exampleOutput;
    private String comment;
    private String answer;
    private String input;
    private String output;
    private Long viewCnt = 0L;
    private int likeCnt = 0;
    private Long userId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}
