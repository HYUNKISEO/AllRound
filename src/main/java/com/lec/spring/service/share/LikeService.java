package com.lec.spring.service.share;

import com.lec.spring.domain.share.Like;
import com.lec.spring.repository.share.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;


    @Transactional
    public Like save (Like like){
        return likeRepository.save(like);
    }

    public Long count (Long questionId){
        Long likeCount = likeRepository.countByQuestion_Id(1L);
        return likeCount;

    }


    public String delete (Long id){
        if(id != null) {
            likeRepository.deleteById(id);
            return "취소 성공";
        } else {
            return "대상 없음";
        }
    }

}
