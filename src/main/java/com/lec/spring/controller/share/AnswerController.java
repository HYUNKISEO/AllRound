package com.lec.spring.controller.share;

import com.lec.spring.domain.Dto.CheckDto;
import com.lec.spring.domain.Dto.ShareAnswerDto;
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

    @PostMapping("/detail")
    public ResponseEntity<?> detail(@RequestBody CheckDto answer) {return new ResponseEntity<>(answerService.findById(answer), HttpStatus.OK);}

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ShareAnswerDto answer) {return new ResponseEntity<>(answerService.save(answer), HttpStatus.OK);}

}
