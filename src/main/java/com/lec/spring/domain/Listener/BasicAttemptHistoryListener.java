package com.lec.spring.domain.Listener;

import com.lec.spring.domain.basic.BasicAttempt;
import com.lec.spring.domain.board.Post;
import com.lec.spring.repository.History.BasicAttemptHistoryRepository;
import com.lec.spring.repository.History.PostHistoryRepository;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;

public class BasicAttemptHistoryListener {

    @PostPersist
    public void persist(Object entity) {
        if (entity instanceof BasicAttempt) {
            BasicAttempt basicAttempt = (BasicAttempt) entity;
            createAndSaveHistory(basicAttempt, basicAttempt.getUser().getUsername() + "님이 " + basicAttempt.getId() +"번째 답안 등록 했습니다.");
        }
    }

    @PostUpdate
    public void update(Object entity) {
        if (entity instanceof BasicAttempt) {
            BasicAttempt basicAttempt = (BasicAttempt) entity;
            createAndSaveHistory(basicAttempt,basicAttempt.getUser().getUsername() + "님이 " + basicAttempt.getId() +"번째 답안 수정 했습니다.");
        }
    }

    private void createAndSaveHistory(BasicAttempt basicAttempt, String content) {
        BasicAttemptHistoryRepository basicAttemptHistoryRepository = BeanUtils.getBean(BasicAttemptHistoryRepository.class);
        BasicAttemptHistory basicAttemptHistory = new BasicAttemptHistory();
        basicAttemptHistory.setBasicAttempt(basicAttempt);
        basicAttemptHistory.setContent(content);
        basicAttemptHistoryRepository.save(basicAttemptHistory);
    }

}
