package com.lec.spring.controller.Tutorial;


import com.lec.spring.domain.Tutorial.YoutubeRequest;
import com.lec.spring.domain.testinfo.BookRequest;
import com.lec.spring.service.tutorial.TutorialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tutorial")
@CrossOrigin
public class TutorialController {

    private final TutorialService tutorialService;

    @PostMapping("/list")
    public ResponseEntity<?> yotube(@RequestBody YoutubeRequest youtubeRequest) {return new ResponseEntity<>(tutorialService.searchYouTubeVideos(youtubeRequest), HttpStatus.OK);}
}
