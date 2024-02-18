package com.lec.spring.service.user;

import com.lec.spring.domain.Dto.UserDto;
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

    public String save(User user) {

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
        userRepository.save(user);
        return  "10";
    }

    public User update(UserDto user) {
        User updateUser = userRepository.findById(user.getUserId()).orElse(null);

        if(passwordEncoder.matches(user.getPassword(), updateUser.getPassword())){
            updateUser.setPassword(passwordEncoder.encode(user.getNewpassword()));
        }else {
            throw new IllegalArgumentException("현재 비밀번호가 맞지 않습니다.");
        }

        if(user.getPhone() != null && !user.getPhone().isEmpty()){
            updateUser.setPhone(user.getPhone());
        }

        return userRepository.save(updateUser);
    }

    public String delete(Long id){
        if(id != null) {
            userRepository.deleteById(id);
            return "1";
        } else {
            return "0";
        }
    }

    // 유저,권한 정보를 가져오는 메소드
    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthorities(String username) {
        return userRepository.findOneWithAuthoritiesByUsername(username);
    }

}
