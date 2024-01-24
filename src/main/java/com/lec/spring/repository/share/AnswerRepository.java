package com.lec.spring.repository.share;

import com.lec.spring.domain.share.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
