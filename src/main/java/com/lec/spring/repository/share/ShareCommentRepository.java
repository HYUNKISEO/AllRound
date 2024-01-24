package com.lec.spring.repository.share;

import com.lec.spring.domain.share.ShareComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShareCommentRepository extends JpaRepository<ShareComment, Long> {
}
