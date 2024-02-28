package com.lec.spring.controller.basic;

import com.lec.spring.domain.basic.BasicQuestion;
import com.lec.spring.service.basic.BasicQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/basic/questions")
public class BQuestionController {



    private final BasicQuestionService basicQuestionService;

    @Autowired
    public BQuestionController(BasicQuestionService basicQuestionService) {
        this.basicQuestionService = basicQuestionService;
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<BasicQuestion> getQuestionById(@PathVariable Long questionId) {
        return basicQuestionService.getQuestionById(questionId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
