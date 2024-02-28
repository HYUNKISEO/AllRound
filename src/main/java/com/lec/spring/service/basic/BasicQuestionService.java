package com.lec.spring.service.basic;

import com.lec.spring.domain.basic.BasicQuestion;
import com.lec.spring.repository.basic.BasicQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BasicQuestionService {

    private final BasicQuestionRepository basicQuestionRepository;
    public Optional<BasicQuestion> getQuestionById(Long questionId) {
        return basicQuestionRepository.findById(questionId);
    }
    public BasicQuestion save(BasicQuestion basicQuestion) {return basicQuestionRepository.save(basicQuestion);}
    public BasicQuestion update(BasicQuestion basicQuestion) {return basicQuestionRepository.save(basicQuestion);}
    public BasicQuestion findById(Long id) {return basicQuestionRepository.findById(id).orElse(null);}
    public Page<BasicQuestion> findAll(int pageNumber, int pageSize) {
        // 페이지 번호는 0부터 시작하므로, 사용자가 1 페이지를 요청하면 내부적으로는 0을 사용합니다.
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by(Sort.Direction.ASC, "questionId"));
        // 리포지토리의 findAll 메소드에 pageable 객체를 전달하여 결과를 가져옵니다.
        return basicQuestionRepository.findAll(pageable);
    }
    public String delete(Long id) {
        if(id != null){
        basicQuestionRepository.deleteById(id);
        return "삭제완료";
        }else {
            return "대상없음";
        }
    }




}
