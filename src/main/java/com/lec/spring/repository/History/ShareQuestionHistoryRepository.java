package com.lec.spring.repository.History;

import com.lec.spring.domain.Listener.BasicAttemptHistory;
import com.lec.spring.domain.Listener.ShareQuestionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShareQuestionHistoryRepository extends JpaRepository<ShareQuestionHistory, Long> {
}
