package com.lec.spring.repository.usercode;

import com.lec.spring.domain.basic.BasicQuestion;
import com.lec.spring.domain.basic.UserCode;
import com.lec.spring.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserCodeRepository extends JpaRepository<UserCode, Long> {
    Optional<UserCode> findByUserAndQuestion(User user, BasicQuestion question);
}


