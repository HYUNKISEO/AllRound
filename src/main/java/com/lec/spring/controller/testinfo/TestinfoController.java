package com.lec.spring.controller.testinfo;

import com.lec.spring.service.testinfo.TestinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestinfoController {

    @Autowired
    private TestinfoService testinfoService;

    @GetMapping("/executeAutoSave")
    public void executeAutoSave() {
        testinfoService.autoSave();
    }
}