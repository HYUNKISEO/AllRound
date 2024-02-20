package com.lec.spring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lec.spring.domain.Dto.GlobalHistory;
import com.lec.spring.domain.Listener.*;
import com.lec.spring.repository.History.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private final BasicAttemptHistoryRepository basicAttemptHistoryRepository;
    private final LikeHistoryRepository likeHistoryRepository;
    private final PostHistoryRepository postHistoryRepository;
    private final ShareQuestionHistoryRepository shareQuestionHistoryRepository;
    private final UserHistoryRepository userHistoryRepository;

    public List<BaseEntity> getGlobalHistoryAsJson() {
        List<BasicAttemptHistory> basicAttemptHistories = basicAttemptHistoryRepository.findAll();
        List<LikeHistory> likeHistories = likeHistoryRepository.findAll();
        List<PostHistory> postHistories = postHistoryRepository.findAll();
        List<ShareQuestionHistory> shareQuestionHistories = shareQuestionHistoryRepository.findAll();
        List<UserHistory> userHistories = userHistoryRepository.findAll();


        List<BaseEntity> allHistories = new ArrayList<>();
        allHistories.addAll(basicAttemptHistories);
        allHistories.addAll(likeHistories);
        allHistories.addAll(postHistories);
        allHistories.addAll(shareQuestionHistories);
        allHistories.addAll(userHistories);

        List<BaseEntity> sortedHistories = allHistories.stream()
                .sorted(Comparator.comparing(BaseEntity::getCreateTime).reversed())
                .collect(Collectors.toList());

        return sortedHistories;
    }

}
