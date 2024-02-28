package com.lec.spring.service.userCode;

import com.lec.spring.repository.usercode.UserCodeRepository;
import com.lec.spring.domain.basic.UserCode; // Import the correct UserCode class
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCodeService {

    private final UserCodeRepository userCodeRepository;

    public UserCodeService(UserCodeRepository userCodeRepository) {
        this.userCodeRepository = userCodeRepository;
    }

    public void save(UserCode userCode) {
        userCodeRepository.save(userCode);
    }
    public void update(UserCode userCode) {
        userCodeRepository.save(userCode);
    }


}
