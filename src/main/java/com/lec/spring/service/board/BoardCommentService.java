package com.lec.spring.service.board;

import com.lec.spring.domain.board.BoardComment;
import com.lec.spring.repository.board.BoardCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardCommentService {

    private final BoardCommentRepository boardCommentRepository;

    public BoardComment save (BoardComment comment) {
        return boardCommentRepository.save(comment);
    }

    public BoardComment update (BoardComment comment) {
        return boardCommentRepository.save(comment);
    }

    public BoardComment findById (Long id) {
        return boardCommentRepository.findById(id).orElse(null);
    }

    public List<BoardComment> findAll () {
        return boardCommentRepository.findAll(Sort.by(Sort.Order.desc("id")));
    }

    public String delete (Long id) {
        if (id != null) {
            boardCommentRepository.deleteById(id);
            return "삭제완료";
        } else {
            return "대상없음";
        }
    }


}
