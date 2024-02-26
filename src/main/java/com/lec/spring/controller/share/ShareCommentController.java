package com.lec.spring.controller.share;

import com.lec.spring.domain.Dto.ShareCommentDto;
import com.lec.spring.domain.share.ShareComment;
import com.lec.spring.service.share.ShareCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/share/comment")
@CrossOrigin
public class ShareCommentController {

    private final ShareCommentService shareCommentService;

    @PostMapping("/list")
    public ResponseEntity<?> list(@RequestBody Long questionId) {return new ResponseEntity<>(shareCommentService.findAll(questionId), HttpStatus.OK);}

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable(name = "id") Long id) {return new ResponseEntity<>(shareCommentService.findById(id), HttpStatus.OK);}

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ShareCommentDto shareComment) {return new ResponseEntity<>(shareCommentService.save(shareComment), HttpStatus.OK);}

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ShareComment shareComment) {return new ResponseEntity<>(shareCommentService.update(shareComment), HttpStatus.OK);}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {return new ResponseEntity<>(shareCommentService.deleteById(id), HttpStatus.OK);}



}
