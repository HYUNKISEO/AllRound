package com.lec.spring.repository.board;

import com.lec.spring.domain.board.BoardComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardCommentRepository extends JpaRepository<BoardComment, Long> {
}
