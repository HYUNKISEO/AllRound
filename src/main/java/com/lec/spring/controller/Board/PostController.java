package com.lec.spring.controller.Board;

import com.lec.spring.domain.board.Post;
import com.lec.spring.service.board.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board/post")
@CrossOrigin
public class PostController {

    private final PostService postService;

    @GetMapping("/list")
    public ResponseEntity<?> list() {return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);}

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id) {return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);}

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Post post) {return new ResponseEntity<>(postService.save(post), HttpStatus.OK);}

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Post post) {return new ResponseEntity<>(postService.update(post), HttpStatus.OK);}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {return new ResponseEntity<>(postService.delete(id), HttpStatus.OK);}

}
