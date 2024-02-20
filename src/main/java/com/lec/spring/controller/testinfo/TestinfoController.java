package com.lec.spring.controller.testinfo;

import com.lec.spring.domain.testinfo.BookRequest;
import com.lec.spring.service.testinfo.TestinfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/testinfo")
@CrossOrigin
public class TestinfoController {

    private final TestinfoService testinfoService;

    @GetMapping("/executeAutoSave")
    public ResponseEntity<String> executeAutoSave() {
        try {
            testinfoService.autoSave();
            return ResponseEntity.ok("Auto save successful");
        } catch (Exception e) {
            // 예외가 발생한 경우
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during auto save");
        }
    }

    @GetMapping("/info")
    public ResponseEntity<?> info(){return new ResponseEntity<>(testinfoService.test(), HttpStatus.OK);}

    @PostMapping("/book")
    public ResponseEntity<?> book(@RequestBody BookRequest bookRequest) {return new ResponseEntity<>(testinfoService.naverBook(bookRequest), HttpStatus.OK);}
}