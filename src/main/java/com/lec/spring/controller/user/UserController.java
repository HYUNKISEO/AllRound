package com.lec.spring.controller.user;

import com.lec.spring.domain.user.User;
import com.lec.spring.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    private final UserService userService;

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id) {return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);}

    @GetMapping("/list")
    public ResponseEntity<?> list() {return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);}

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody User user) {return new ResponseEntity<>(userService.save(user), HttpStatus.OK);}

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody User user) {return new ResponseEntity<>(userService.update(user), HttpStatus.OK);}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);}


}
