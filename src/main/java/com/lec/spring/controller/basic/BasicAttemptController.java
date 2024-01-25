package com.lec.spring.controller.basic;

import com.lec.spring.domain.basic.BasicAttempt;
import com.lec.spring.service.basic.BasicAttemptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/basic")
@CrossOrigin
public class BasicAttemptController {

    private final BasicAttemptService basicAttemptService;

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id) {return new ResponseEntity<>(basicAttemptService.findById(id), HttpStatus.OK);}

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody BasicAttempt basicAttempt) {return new ResponseEntity<>(basicAttemptService.save(basicAttempt), HttpStatus.OK);}

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody BasicAttempt basicAttempt) {return new ResponseEntity<>(basicAttemptService.update(basicAttempt), HttpStatus.OK);}

}

