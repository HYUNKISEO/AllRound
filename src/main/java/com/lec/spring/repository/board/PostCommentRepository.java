package com.lec.spring.repository.board;

import com.lec.spring.domain.board.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
}
