package com.lec.spring.service.share;


import com.lec.spring.domain.Dto.ShareCommentDto;
import com.lec.spring.domain.share.Question;
import com.lec.spring.domain.share.ShareComment;
import com.lec.spring.repository.share.QuestionRepository;
import com.lec.spring.repository.share.ShareCommentRepository;
import com.lec.spring.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShareCommentService {

    private final ShareCommentRepository shareCommentRepository;

    private final QuestionRepository questionRepository;

    private final UserRepository userRepository;



    public String save (ShareCommentDto comment){

        ShareComment newComment = new ShareComment();
        newComment.setText(comment.getText());
        newComment.setUser(userRepository.findById(comment.getUserId()).orElse(null));
        newComment.setQuestion(questionRepository.findById(comment.getQuestionId()).orElse(null));
        shareCommentRepository.save(newComment);
        return "10";
    }

    public ShareComment update (ShareComment comment){
        return shareCommentRepository.save(comment);
    }

    public ShareComment findById(Long id){
        return shareCommentRepository.findById(id).orElse(null);
    }

    public List<ShareCommentDto> findAll(Long postId){
         Question question = questionRepository.findById(postId).orElse(null);

         if(question != null) {
             List<ShareComment> comments = shareCommentRepository.findByQuestion(question);

             List<ShareCommentDto> commentDtos = comments.stream()
                     .map(comment -> ShareCommentDto.builder()
                             .id(comment.getId())
                             .text(comment.getText())
                             .userId(comment.getUser().getId())
                             .username(comment.getUser().getUsername())
                             .createTime(comment.getCreateTime())
                             .questionId(comment.getQuestion().getId())
                             .build())
                     .collect(Collectors.toList());
             return commentDtos;
         }

         return Collections.emptyList();
    }

    public String deleteById(Long id){
        if(id != null){
            shareCommentRepository.deleteById(id);
            return "삭제 성공";
        }else {
            return "삭제 실패";
        }
    }

}
