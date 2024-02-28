package com.lec.spring.repository.basic;

import com.lec.spring.domain.basic.BasicQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicQuestionRepository extends JpaRepository<BasicQuestion, Long> {
    BasicQuestion findByQuestionId(Long questionId); // questionId를 사용한 쿼리 메서드

}
