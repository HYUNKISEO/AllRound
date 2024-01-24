package com.lec.spring.repository.user;

import com.lec.spring.domain.user.Authority;
import com.lec.spring.domain.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Test
    void user(){
        Authority auth_member = Authority.builder()
                .name("ROLE_MEMBER")
                .build();
        Authority auth_admin = Authority.builder()
                .name("ROLE_ADMIN")
                .build();

        authorityRepository.saveAndFlush(auth_member);
        authorityRepository.saveAndFlush(auth_admin);

        authorityRepository.findAll().forEach(System.out::println);

        User user = User.builder()
                .name("member")
                .username("name")
                .password("1234")
                .build();

        userRepository.saveAndFlush(user);
        userRepository.findAll().forEach(System.out::println);

        user.getAuthorities().add(auth_member);
        userRepository.save(user);
        userRepository.findAll().forEach(System.out::println);
        System.out.println(user.getAuthorities());

    }


}