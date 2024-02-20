package com.lec.spring.controller.Board;

import com.lec.spring.domain.Dto.PostDto;
import com.lec.spring.domain.board.Post;
import com.lec.spring.service.board.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.InterfaceAddress;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board/post")
@CrossOrigin
public class PostController {

    private final PostService postService;

    @GetMapping("/list")
    public ResponseEntity<?> list(@RequestParam(name = "pageNumber") Integer pageNumber, @RequestParam(name = "pageSize") Integer pageSize, @RequestParam(name = "sort") String sort) {
        List<PostDto> postDtoList = postService.findAll(pageNumber, pageSize, sort);
        return new ResponseEntity<>(postDtoList, HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<?> admin() {return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);}


    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable(name = "id") Long id) {return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);}

    @GetMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id) {return new ResponseEntity<>(postService.update(id), HttpStatus.OK);}

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PostDto post) {
        System.out.println(post);
        return new ResponseEntity<>(postService.save(post), HttpStatus.OK);}

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody PostDto post) {return new ResponseEntity<>(postService.update(post), HttpStatus.OK);}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {return new ResponseEntity<>(postService.delete(id), HttpStatus.OK);}

    @GetMapping("/mylist/{id}")
    public ResponseEntity<?> mylist(@PathVariable(name = "id") Long userId) {return new ResponseEntity<>(postService.findByUserId(userId), HttpStatus.OK);}

}
