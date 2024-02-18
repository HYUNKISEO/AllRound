package com.lec.spring.repository.board;

import com.lec.spring.domain.board.Post;
import com.lec.spring.domain.board.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
    List<PostComment> findByPost(Post post);
}
