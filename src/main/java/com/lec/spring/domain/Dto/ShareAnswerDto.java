package com.lec.spring.domain.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShareAnswerDto {
    private String userAnswer;
    private Long userId;
    private Long questionId;

}
