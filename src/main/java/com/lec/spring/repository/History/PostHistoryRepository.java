package com.lec.spring.repository.History;

import com.lec.spring.domain.Listener.PostHistory;
import com.lec.spring.domain.Listener.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostHistoryRepository extends JpaRepository<PostHistory, Long> {
}
