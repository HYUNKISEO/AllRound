package com.lec.spring.service.user;

import com.lec.spring.domain.user.Authority;
import com.lec.spring.domain.user.User;
import com.lec.spring.repository.user.AuthorityRepository;
import com.lec.spring.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final AuthorityRepository authorityRepository;

    public User findById(Long id){return userRepository.findById(id).orElse(null);}

    public List<User> findAll(){return userRepository.findAll(Sort.by(Sort.Order.desc("id")));}

    public User save(User user) {

        Authority auth = authorityRepository.findByName("MEMBER");
        if (auth == null){
            auth = new Authority();
            auth.setName("MEMBER");
            authorityRepository.save(auth);
        }
        user.getAuthorities().add(auth);
        return  userRepository.save(user);
    }

    public User update(User user) {
        User updateUser = userRepository.findById(user.getId()).orElse(null);

        updateUser.setPassword(user.getPassword());
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




}
