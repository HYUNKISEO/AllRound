package com.lec.spring.controller.share;

import com.lec.spring.domain.Dto.ShareDto;
import com.lec.spring.service.share.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/share/question")
@CrossOrigin
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
    public ResponseEntity<?> list() {return new ResponseEntity<>(questionService.findAll(), HttpStatus.OK);}

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable(name = "id") Long id) {return new ResponseEntity<>(questionService.findById(id), HttpStatus.OK);}

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ShareDto question){return new ResponseEntity<>(questionService.save(question), HttpStatus.OK);}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {return new ResponseEntity<>(questionService.delete(id), HttpStatus.OK);}

}
