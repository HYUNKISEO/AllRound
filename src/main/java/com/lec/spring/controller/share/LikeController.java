package com.lec.spring.controller.share;

import com.lec.spring.domain.Dto.LikeDto;
import com.lec.spring.domain.share.Like;
import com.lec.spring.service.share.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/share/like")
@CrossOrigin
public class LikeController {

    private final LikeService likeService;

    @GetMapping("/count/{id}")
    public ResponseEntity<?> count(@PathVariable(name = "id") Long questionId) {return new ResponseEntity<>(likeService.count(questionId), HttpStatus.OK);}

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody LikeDto like) {return new ResponseEntity<>(likeService.save(like), HttpStatus.OK);}

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LikeDto like) {return new ResponseEntity<>(likeService.delete(like), HttpStatus.OK);}

}
