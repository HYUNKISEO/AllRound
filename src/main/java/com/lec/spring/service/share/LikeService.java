package com.lec.spring.service.share;

import com.lec.spring.domain.Dto.LikeDto;
import com.lec.spring.domain.Listener.LikeHistory;
import com.lec.spring.domain.share.Like;
import com.lec.spring.domain.share.Question;
import com.lec.spring.domain.user.User;
import com.lec.spring.repository.History.LikeHistoryRepository;
import com.lec.spring.repository.share.LikeRepository;
import com.lec.spring.repository.share.QuestionRepository;
import com.lec.spring.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;

    private final LikeHistoryRepository likeHistoryRepository;



    public Like save (LikeDto like){
        User user = userRepository.findById(like.getUserId()).orElse(null);
        Question question = questionRepository.findById(like.getQuestionId()).orElse(null);

        Like like1 = new Like();
        like1.setUser(user);
        like1.setQuestion(question);

        Like savedLike = likeRepository.save(like1);

        Long questionId = savedLike.getQuestion().getId();
        Long likeCount = likeRepository.countByQuestionId(questionId);

        if (likeCount % 10 == 0) {
            LikeHistory likeHistory = LikeHistory.builder()
                    .content(savedLike.getQuestion().getId() + "번 문제 " + savedLike.getQuestion().getQuestion() + " 공유문제 추천누적" + likeCount + "개 돌파 했습니다.")
                    .type("추천누적")
                    .build();
            likeHistoryRepository.save(likeHistory);
        }

        return like1;
    }

    public Long count (Long questionId){
        Long likeCount = likeRepository.countByQuestionId(questionId);
        return likeCount;
    }


    @Transactional
    public String delete (LikeDto like) {

        if (like != null) {
            List<Like> findLikes = likeRepository.findByQuestionIdAndUserId(like.getQuestionId(), like.getUserId());

            for (Like find : findLikes) {
                likeRepository.delete(find);
                return "삭제 성공";
            }
            return "좋아요 못찾음";
        } else {
            return "삭제 실패: 입력값이 null";
        }
    }

}
