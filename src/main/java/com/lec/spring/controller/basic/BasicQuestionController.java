package com.lec.spring.controller.basic;

import com.lec.spring.domain.basic.BasicQuestion;
import com.lec.spring.service.basic.BasicQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/basic/question")
@CrossOrigin
public class BasicQuestionController {

    private final BasicQuestionService basicQuestionService;

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getQuestionById(@PathVariable Long id) {
        BasicQuestion question = basicQuestionService.findById(id);
        if (question != null) {
            return new ResponseEntity<>(question, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllQuestions() {
        List<BasicQuestion> questions = basicQuestionService.findAll();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveQuestion(@RequestBody BasicQuestion basicQuestion) {
        BasicQuestion savedQuestion = basicQuestionService.save(basicQuestion);
        return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateQuestion(@RequestBody BasicQuestion basicQuestion) {
        BasicQuestion updatedQuestion = basicQuestionService.update(basicQuestion);
        return new ResponseEntity<>(updatedQuestion, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long id) {
        String resultMessage = basicQuestionService.delete(id);
        return new ResponseEntity<>(resultMessage, HttpStatus.OK);
    }

}
