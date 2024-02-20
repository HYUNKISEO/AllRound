package com.lec.spring.service.share;

import com.lec.spring.domain.Listener.LikeHistory;
import com.lec.spring.domain.share.Like;
import com.lec.spring.repository.History.LikeHistoryRepository;
import com.lec.spring.repository.share.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;

    private final LikeHistoryRepository likeHistoryRepository;



    public Like save (Like like){
        Like savedLike = likeRepository.save(like);

        Long questionId = savedLike.getQuestion().getId();
        Long likeCount = likeRepository.countByQuestionId(questionId);

        if (likeCount % 10 == 0) {
            LikeHistory likeHistory = LikeHistory.builder()
                    .like(savedLike)
                    .content(savedLike.getUser().getUsername()+ " 님이 작성한 " + savedLike.getQuestion() + " 공유문제 추천누적 10개 증가 했습니다.")
                    .build();
            likeHistoryRepository.save(likeHistory);
        }

        return likeRepository.save(like);
    }

    public Long count (Long questionId){
        Long likeCount = likeRepository.countByQuestionId(questionId);
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
