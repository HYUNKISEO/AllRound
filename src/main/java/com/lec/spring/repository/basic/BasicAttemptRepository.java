package com.lec.spring.repository.basic;

import com.lec.spring.domain.basic.BasicAttempt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicAttemptRepository extends JpaRepository<BasicAttempt, Long> {
}
