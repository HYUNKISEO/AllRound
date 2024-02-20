package com.lec.spring.repository.History;

import com.lec.spring.domain.Listener.LikeHistory;
import com.lec.spring.domain.Listener.PostHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeHistoryRepository extends JpaRepository<LikeHistory, Long> {
}
