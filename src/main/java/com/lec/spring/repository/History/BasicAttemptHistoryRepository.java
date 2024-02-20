package com.lec.spring.repository.History;

import com.lec.spring.domain.Listener.BasicAttemptHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicAttemptHistoryRepository extends JpaRepository<BasicAttemptHistory, Long> {
}
