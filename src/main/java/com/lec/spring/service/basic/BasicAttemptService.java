package com.lec.spring.service.basic;

import com.lec.spring.domain.basic.BasicAttempt;
import com.lec.spring.repository.basic.BasicAttemptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasicAttemptService {

    private final BasicAttemptRepository basicAttemptRepository;

    public BasicAttempt save (BasicAttempt basicAttempt) {
        return basicAttemptRepository.save(basicAttempt);
    }

    public BasicAttempt update (BasicAttempt basicAttempt) {
        return basicAttemptRepository.save(basicAttempt);
    }

    public BasicAttempt findById (Long id) {
        return basicAttemptRepository.findById(id).orElse(null);
    }

}
