package com.lec.spring.repository.share;

import com.lec.spring.domain.share.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {

    Long countByQuestionId(Long questionId);


    List<Like> findByQuestionId(Long questionId);
}
