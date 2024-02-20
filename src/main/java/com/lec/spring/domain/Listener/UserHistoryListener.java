package com.lec.spring.domain.Listener;

import com.lec.spring.domain.user.User;
import com.lec.spring.repository.History.UserHistoryRepository;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;

public class UserHistoryListener {

    @PostPersist
    public void persist(Object entity) {
        if (entity instanceof User) {
            User user = (User) entity;
            createAndSaveHistory(user, user.getUsername() + " 님이 회원가입 하였습니다.");
        }
    }

    private void createAndSaveHistory(User user, String content) {
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);
        UserHistory userHistory = new UserHistory();
        userHistory.setUser(user);
        userHistory.setContent(content);
        userHistoryRepository.save(userHistory);
    }

}
