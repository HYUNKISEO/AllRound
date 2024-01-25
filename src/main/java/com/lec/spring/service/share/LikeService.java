package com.lec.spring.service.share;

import com.lec.spring.domain.share.Like;
import com.lec.spring.repository.share.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;

    public Like save (Like like){
        return likeRepository.save(like);
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
