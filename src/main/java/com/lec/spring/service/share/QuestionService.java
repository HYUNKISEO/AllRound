package com.lec.spring.service.share;

import com.lec.spring.domain.share.Question;
import com.lec.spring.repository.share.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public Question save (Question question){
        return questionRepository.save(question);
    }

    public Question update (Question question){
        return questionRepository.save(question);
    }

    public String delete (Long id){
        if(id != null){
            questionRepository.deleteById(id);
            return "삭제완료";
        } else {
            return "없는 회원";
        }
    }

    public Question findById (Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    public List<Question> findAll () {return questionRepository.findAll(Sort.by(Sort.Order.desc("id")));}
}
