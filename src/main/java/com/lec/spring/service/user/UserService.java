package com.lec.spring.service.user;

import com.lec.spring.domain.user.Authority;
import com.lec.spring.domain.user.User;
import com.lec.spring.repository.user.AuthorityRepository;
import com.lec.spring.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.RuntimeErrorException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final AuthorityRepository authorityRepository;

    private final PasswordEncoder passwordEncoder;

    public User findById(Long id){return userRepository.findById(id).orElse(null);}

    public List<User> findAll(){return userRepository.findAll(Sort.by(Sort.Order.desc("id")));}

    public User save(User user) {

        if(userRepository.existsByUsername(user.getUsername())){
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        Authority auth = authorityRepository.findByName("ROLE_MEMBER");
        if (auth == null){
            auth = new Authority();
            auth.setName("ROLE_MEMBER");
            authorityRepository.save(auth);
        }
        user.getAuthorities().add(auth);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return  userRepository.save(user);
    }

    public User update(User user) {
        User updateUser = userRepository.findById(user.getId()).orElse(null);

        updateUser.setPassword(passwordEncoder.encode(user.getPassword()));
        updateUser.setPhone(user.getPhone());

        return userRepository.save(updateUser);
    }

    public String delete(Long id){
        if(id != null) {
            userRepository.deleteById(id);
            return "삭제완료";
        } else {
            return "없는 회원";
        }
    }

    // 유저,권한 정보를 가져오는 메소드
    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthorities(String username) {
        return userRepository.findOneWithAuthoritiesByUsername(username);
    }

}
