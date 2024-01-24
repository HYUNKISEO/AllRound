package com.lec.spring.repository.user;

import com.lec.spring.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
