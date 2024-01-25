package com.lec.spring.service.board;

import com.lec.spring.domain.board.PostComment;
import com.lec.spring.repository.board.PostCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostCommentService {

    private final PostCommentRepository postCommentRepository;

    public PostComment save (PostComment comment) {
        return postCommentRepository.save(comment);
    }

    public PostComment update (PostComment comment) {
        return postCommentRepository.save(comment);
    }

    public PostComment findById (Long id) {
        return postCommentRepository.findById(id).orElse(null);
    }

    public List<PostComment> findAll () {
        return postCommentRepository.findAll(Sort.by(Sort.Order.desc("id")));
    }

    public String delete (Long id) {
        if (id != null) {
            postCommentRepository.deleteById(id);
            return "삭제완료";
        } else {
            return "대상없음";
        }
    }


}
