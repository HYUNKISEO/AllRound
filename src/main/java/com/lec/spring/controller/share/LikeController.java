package com.lec.spring.controller.share;

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

    @GetMapping("/count")
    public ResponseEntity<?> count(@RequestParam("questionId") Long questionId) {return new ResponseEntity<>(likeService.count(questionId), HttpStatus.OK);}

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Like like) {return new ResponseEntity<>(likeService.save(like), HttpStatus.OK);}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {return new ResponseEntity<>(likeService.delete(id), HttpStatus.OK);}

}
