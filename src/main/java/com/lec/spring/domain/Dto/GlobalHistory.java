package com.lec.spring.domain.Dto;

import com.lec.spring.domain.Listener.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GlobalHistory {
    private List<BasicAttemptHistory> attempts;
    private List<LikeHistory> likes;
    private List<PostHistory> posts;
    private List<ShareQuestionHistory> shareQuestions;
    private List<UserHistory> users;

}
