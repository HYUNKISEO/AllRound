package com.lec.spring.domain.Listener;

import com.lec.spring.domain.board.Post;
import com.lec.spring.domain.user.User;
import com.lec.spring.repository.History.PostHistoryRepository;
import com.lec.spring.repository.History.UserHistoryRepository;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;

public class PostHistoryListener {

    @PostPersist
    public void persist(Object entity) {
        if (entity instanceof Post) {
            Post post = (Post) entity;
            createAndSaveHistory(post, post.getUser().getUsername() + " 님이 " + post.getSubject() + " 게시물을 등록 했습니다.");
        }
    }

    private void createAndSaveHistory(Post post, String content) {
        PostHistoryRepository postHistoryRepository = BeanUtils.getBean(PostHistoryRepository.class);
        PostHistory postHistory = new PostHistory();
        postHistory.setPost(post);
        postHistory.setContent(content);
        postHistoryRepository.save(postHistory);
    }

}
