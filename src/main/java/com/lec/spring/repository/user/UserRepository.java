package com.lec.spring.repository.user;

import com.lec.spring.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneWithAuthoritiesByUsername(String username);

    User findByUsername(String username);

    boolean existsByUsername(String username);
}
