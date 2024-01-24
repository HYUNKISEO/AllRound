package com.lec.spring.repository.board;

import com.lec.spring.domain.board.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
