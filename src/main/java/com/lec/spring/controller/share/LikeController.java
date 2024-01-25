package com.lec.spring.controller.share;

import com.lec.spring.domain.share.Like;
import com.lec.spring.service.share.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/share")
@CrossOrigin
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/like/save")
    public ResponseEntity<?> save(@RequestBody Like like) {return new ResponseEntity<>(likeService.save(like), HttpStatus.OK);}

    @DeleteMapping("/like/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {return new ResponseEntity<>(likeService.delete(id), HttpStatus.OK);}

}
