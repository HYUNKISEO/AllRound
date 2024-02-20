package com.lec.spring.repository.History;

import com.lec.spring.domain.Listener.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {
}
