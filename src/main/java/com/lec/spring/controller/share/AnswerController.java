package com.lec.spring.controller.share;

import com.lec.spring.domain.share.Answer;
import com.lec.spring.service.share.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/share/answer")
@CrossOrigin
public class AnswerController {

    private final AnswerService answerService;

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id) {return new ResponseEntity<>(answerService.findById(id), HttpStatus.OK);}

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Answer answer) {return new ResponseEntity<>(answerService.save(answer), HttpStatus.OK);}

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Answer answer) {return new ResponseEntity<>(answerService.update(answer), HttpStatus.OK);}


}
