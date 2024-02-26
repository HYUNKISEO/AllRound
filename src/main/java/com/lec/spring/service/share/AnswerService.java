package com.lec.spring.service.share;

import com.lec.spring.domain.Dto.CheckDto;
import com.lec.spring.domain.Dto.ShareAnswerDto;
import com.lec.spring.domain.share.Answer;
import com.lec.spring.domain.share.Question;
import com.lec.spring.domain.user.User;
import com.lec.spring.repository.share.AnswerRepository;
import com.lec.spring.repository.share.QuestionRepository;
import com.lec.spring.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    public Answer save (ShareAnswerDto answer) {
        User user = userRepository.findById(answer.getUserId()).orElse(null);
        Question question = questionRepository.findById(answer.getQuestionId()).orElse(null);

        Answer findAnswer = answerRepository.findByUserIdAndQuestionId(answer.getUserId(), answer.getQuestionId());

        if (findAnswer != null) {
            // 이미 존재하는 답변이 있는 경우 업데이트 수행
            findAnswer.setUserAnswer(answer.getUserAnswer());
            return answerRepository.save(findAnswer);
        }else{
            Answer Answer = new Answer();
            Answer.setUserAnswer(answer.getUserAnswer());
            Answer.setUser(user);
            Answer.setQuestion(question);
            return answerRepository.save(Answer);
        }
    }

    public Answer findById (CheckDto answer) {
        return answerRepository.findByUserIdAndQuestionId(answer.getUserId(), answer.getQuestionId());
    }


}
