package com.lec.spring.controller;

import com.lec.spring.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/history")
@CrossOrigin
public class GlobalHistoryController {

    private final HistoryService historyService;

    @GetMapping("/list")
    public ResponseEntity<?> list() {return new ResponseEntity<>(historyService.getGlobalHistoryAsJson(), HttpStatus.OK);}

}
