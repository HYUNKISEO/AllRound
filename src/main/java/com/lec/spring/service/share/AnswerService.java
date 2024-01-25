package com.lec.spring.service.share;

import com.lec.spring.domain.share.Answer;
import com.lec.spring.repository.share.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public Answer save (Answer answer) {
        return answerRepository.save(answer);
    }

    public Answer update (Answer answer){
        return answerRepository.save(answer);
    }

    public Answer findById (Long id) {
        return answerRepository.findById(id).orElse(null);
    }


}
