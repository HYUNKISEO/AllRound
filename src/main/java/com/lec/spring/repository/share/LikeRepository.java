package com.lec.spring.repository.share;

import com.lec.spring.domain.share.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {

    Long countByQuestion_Id(Long questionId);


}
