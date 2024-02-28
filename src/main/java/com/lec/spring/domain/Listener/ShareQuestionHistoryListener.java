package com.lec.spring.domain.Listener;

import com.lec.spring.domain.board.Post;
import com.lec.spring.domain.share.Question;
import com.lec.spring.repository.History.PostHistoryRepository;
import com.lec.spring.repository.History.ShareQuestionHistoryRepository;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;

public class ShareQuestionHistoryListener {

    @PostPersist
    public void persist(Object entity) {
        if (entity instanceof Question) {
            Question question = (Question) entity;
            createAndSaveHistory(question, question.getUser().getUsername() + " 님이 " + question.getQuestion() + "유저문제를 등록 했습니다.");
        }
    }

    private void createAndSaveHistory(Question question, String content) {
        ShareQuestionHistoryRepository shareQuestionHistoryRepository = BeanUtils.getBean(ShareQuestionHistoryRepository.class);
        ShareQuestionHistory shareQuestionHistory = new ShareQuestionHistory();
        shareQuestionHistory.setContent(content);
        shareQuestionHistory.setType("공유문제");
        shareQuestionHistoryRepository.save(shareQuestionHistory);
    }

}
