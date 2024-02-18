package com.lec.spring.service.board;

import com.lec.spring.domain.Dto.PostCommentDto;
import com.lec.spring.domain.board.Post;
import com.lec.spring.domain.board.PostComment;
import com.lec.spring.repository.board.PostCommentRepository;
import com.lec.spring.repository.board.PostRepository;
import com.lec.spring.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostCommentService {

    private final PostCommentRepository postCommentRepository;

    private final PostRepository postRepository;

    private final UserRepository userRepository;

    public String save (PostCommentDto comment) {
        PostComment newComment = new PostComment();
        newComment.setText(comment.getText());
        newComment.setUser(userRepository.findById(comment.getUserId()).orElse(null));
        newComment.setPost(postRepository.findById(comment.getPostId()).orElse(null));
        postCommentRepository.save(newComment);
        return "10";
    }

    public PostComment findById (Long id) {
        return postCommentRepository.findById(id).orElse(null);
    }

    public List<PostCommentDto> findAll (Long postId) {
        Post post = postRepository.findById(postId).orElse(null);

        if(post != null){
            List<PostComment> comments = postCommentRepository.findByPost(post);

            List<PostCommentDto> commentDtos = comments.stream()
                    .map(comment -> PostCommentDto.builder()
                            .id(comment.getId())
                            .text(comment.getText())
                            .userId(comment.getUser().getId())
                            .username(comment.getUser().getUsername())
                            .createTime(comment.getCreateTime())
                            .postId(comment.getPost().getId())
                            .build())
                    .collect(Collectors.toList());
            return commentDtos;
        }

        return Collections.emptyList();
    }

    public String delete (Long id) {
        if (id != null) {
            postCommentRepository.deleteById(id);
            return "1";
        } else {
            return "0";
        }
    }


}
