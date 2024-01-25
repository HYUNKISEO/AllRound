package com.lec.spring.controller.Board;

import com.lec.spring.domain.board.PostComment;
import com.lec.spring.service.board.PostCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
@CrossOrigin
public class PostCommentsController {

    private final PostCommentService postCommentService;

    @GetMapping("/comment/list")
    public ResponseEntity<?> list() {return new ResponseEntity<>(postCommentService.findAll(), HttpStatus.OK);}

    @GetMapping("/comment/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id) {return new ResponseEntity<>(postCommentService.findById(id), HttpStatus.OK);}

    @PostMapping("/comment/save")
    public ResponseEntity<?> save(@RequestBody PostComment postComment) {return new ResponseEntity<>(postCommentService.save(postComment), HttpStatus.OK);}

    @PutMapping("/comment/update")
    public ResponseEntity<?> update(@RequestBody PostComment postComment) {return new ResponseEntity<>(postCommentService.update(postComment), HttpStatus.OK);}

    @DeleteMapping("/comment/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {return new ResponseEntity<>(postCommentService.delete(id), HttpStatus.OK);}


}
