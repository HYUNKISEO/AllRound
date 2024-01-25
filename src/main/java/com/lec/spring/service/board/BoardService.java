package com.lec.spring.service.board;

import com.lec.spring.domain.board.Post;
import com.lec.spring.repository.board.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final PostRepository postRepository;

    public Post save (Post post) {
        return postRepository.save(post);
    }

    public Post update (Post post) {
        return postRepository.save(post);
    }

    public Post findById (Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public List<Post> findAll () {
        return postRepository.findAll(Sort.by(Sort.Order.desc("id")));
    }

    public String delete (Long id) {
        if(id != null) {
            postRepository.deleteById(id);
            return "삭제 성공";
        }else {
            return "대상 없음";
        }
    }

}
