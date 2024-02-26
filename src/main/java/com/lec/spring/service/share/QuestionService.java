package com.lec.spring.service.share;

import com.lec.spring.domain.Dto.ShareDto;
import com.lec.spring.domain.share.Like;
import com.lec.spring.domain.share.Question;
import com.lec.spring.repository.share.QuestionRepository;
import com.lec.spring.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    public Question save (ShareDto question){
        Question newQuestion = new Question();
        newQuestion.setQuestion(question.getQuestion());
        newQuestion.setAnswer(question.getAnswer());
        newQuestion.setComment(question.getComment());
        newQuestion.setInput(question.getInput());
        newQuestion.setOutput(question.getOutput());
        if(question.getExampleInput() != null){
        newQuestion.setExampleInput(question.getExampleInput());
        }
        if(question.getExampleOutput() != null) {
        newQuestion.setExampleOutput(question.getExampleOutput());
        }
        newQuestion.setUser(userRepository.findById(question.getUserId()).orElse(null));
        return questionRepository.save(newQuestion);
    }

    public String delete (Long id){
        if(id != null){
            questionRepository.deleteById(id);
            return "삭제완료";
        } else {
            return "없는 회원";
        }
    }

    public ShareDto findById (Long id) {
        Question question = questionRepository.findById(id).orElse(null);

        question.setViewCnt(question.getViewCnt() + 1L);
        question.setLikeCnt(question.getLikes().size());
        questionRepository.save(question);

        ShareDto mainShare = new ShareDto();
        mainShare.setId(question.getId());
        mainShare.setQuestion(question.getQuestion());
        mainShare.setComment(question.getComment());
        mainShare.setAnswer(question.getAnswer());
        mainShare.setInput(question.getInput());
        mainShare.setExampleInput(question.getExampleInput());
        mainShare.setOutput(question.getOutput());
        mainShare.setUserId(question.getUser().getId());
        mainShare.setLikeCnt(question.getLikeCnt());
        mainShare.setExampleOutput(question.getExampleOutput());
        mainShare.setViewCnt(question.getViewCnt());
        mainShare.setCreateTime(question.getCreateTime());

        return mainShare;
    }

    public List<Question> findAll () {
        List<Question> questions = questionRepository.findAll(Sort.by(Sort.Order.desc("id")));
        for (Question question : questions) {
            question.setLikeCnt(question.getLikes().size());
            for(Like like: question.getLikes()) {
                question.getUserIds().add(like.getUser().getId());
            }
        }
        return questions;
    }

}
