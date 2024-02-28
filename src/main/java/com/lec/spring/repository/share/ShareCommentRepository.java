package com.lec.spring.repository.share;

import com.lec.spring.domain.share.Question;
import com.lec.spring.domain.share.ShareComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShareCommentRepository extends JpaRepository<ShareComment, Long> {
    List<ShareComment> findByQuestion(Question question);
}
