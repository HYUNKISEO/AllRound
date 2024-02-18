package com.lec.spring.controller.Board;

import com.lec.spring.domain.Dto.PostCommentDto;
import com.lec.spring.domain.board.PostComment;
import com.lec.spring.service.board.PostCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board/comment")
@CrossOrigin
public class PostCommentsController {

    private final PostCommentService postCommentService;

    @PostMapping("/list")
    public ResponseEntity<?> list(@RequestBody Long postId) {return new ResponseEntity<>(postCommentService.findAll(postId), HttpStatus.OK);}

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PostCommentDto postComment) {return new ResponseEntity<>(postCommentService.save(postComment), HttpStatus.OK);}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {return new ResponseEntity<>(postCommentService.delete(id), HttpStatus.OK);}


}
