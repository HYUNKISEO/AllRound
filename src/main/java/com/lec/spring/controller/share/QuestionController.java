package com.lec.spring.controller.share;

import com.lec.spring.domain.share.Question;
import com.lec.spring.service.share.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/share")
@CrossOrigin
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/question/list")
    public ResponseEntity<?> list() {return new ResponseEntity<>(questionService.findAll(), HttpStatus.OK);}

    @GetMapping("/question/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id) {return new ResponseEntity<>(questionService.findById(id), HttpStatus.OK);}

    @PostMapping("/question/save")
    public ResponseEntity<?> save(@RequestBody Question question){return new ResponseEntity<>(questionService.save(question), HttpStatus.OK);}

    @DeleteMapping("/question/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {return new ResponseEntity<>(questionService.delete(id), HttpStatus.OK);}

}
