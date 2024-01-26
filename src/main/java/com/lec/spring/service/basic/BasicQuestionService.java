package com.lec.spring.service.basic;

import com.lec.spring.domain.basic.BasicQuestion;
import com.lec.spring.repository.basic.BasicQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasicQuestionService {

    private final BasicQuestionRepository basicQuestionRepository;

    public BasicQuestion save(BasicQuestion basicQuestion) {return basicQuestionRepository.save(basicQuestion);}
    public BasicQuestion update(BasicQuestion basicQuestion) {return basicQuestionRepository.save(basicQuestion);}
    public BasicQuestion findById(Long id) {return basicQuestionRepository.findById(id).orElse(null);}
    public List<BasicQuestion> findAll() {return basicQuestionRepository.findAll(Sort.by(Sort.Order.desc("id")));}
    public String delete(Long id) {
        if(id != null){
        basicQuestionRepository.deleteById(id);
        return "삭제완료";
        }else {
            return "대상없음";
        }
    }




}
