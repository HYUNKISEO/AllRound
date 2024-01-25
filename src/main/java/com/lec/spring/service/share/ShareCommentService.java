package com.lec.spring.service.share;


import com.lec.spring.domain.share.Question;
import com.lec.spring.domain.share.ShareComment;
import com.lec.spring.repository.share.QuestionRepository;
import com.lec.spring.repository.share.ShareCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShareCommentService {

    private final ShareCommentRepository shareCommentRepository;

    private final QuestionRepository questionRepository;


    public ShareComment save (ShareComment comment){
        return shareCommentRepository.save(comment);
    }

    public ShareComment update (ShareComment comment){
        return shareCommentRepository.save(comment);
    }

    public ShareComment findById(Long id){
        return shareCommentRepository.findById(id).orElse(null);
    }

    public List<ShareComment> findAll(){return shareCommentRepository.findAll();}

    public String deleteById(Long id){
        if(id != null){
            shareCommentRepository.deleteById(id);
            return "삭제 성공";
        }else {
            return "삭제 실패";
        }
    }

}
