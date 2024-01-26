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
    public void executeAutoSave() {testinfoService.autoSave();}

    @PostMapping("/book")
    public ResponseEntity<?> book(@RequestBody BookRequest bookRequest) {return new ResponseEntity<>(testinfoService.naverBook(bookRequest), HttpStatus.OK);}
}