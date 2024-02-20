package com.lec.spring.controller.user;

import com.lec.spring.domain.Dto.AdminDto;
import com.lec.spring.domain.Dto.UserDto;
import com.lec.spring.domain.user.User;
import com.lec.spring.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    private final UserService userService;

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable(name = "id") Long id) {return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);}

    @GetMapping("/list")
    public ResponseEntity<?> list() {return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);}

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody User user) {return new ResponseEntity<>(userService.save(user), HttpStatus.OK);}

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody UserDto user) {return new ResponseEntity<>(userService.update(user), HttpStatus.OK);}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);}

    @GetMapping("/{username}")
    @PreAuthorize("hasAnyRole('MEMBER','ADMIN')")
    public ResponseEntity<User> getUserInfo(@PathVariable(name = "username") String username) {
        return ResponseEntity.ok(userService.getUserWithAuthorities(username).get());
    }

    @PostMapping("/admin/addauth/{id}")
    public ResponseEntity<?> addAuth(@PathVariable(name = "id") Long id) {return new ResponseEntity<>(userService.addAuth(id), HttpStatus.OK);}

    @PostMapping("/admin/removeauth/{id}")
    public ResponseEntity<?> removeAuth(@PathVariable(name = "id") Long id) {return new ResponseEntity<>(userService.removeAuth(id), HttpStatus.OK);}

    @PutMapping("/admin/update")
    public ResponseEntity<?> update(@RequestBody AdminDto adminDto){return new ResponseEntity<>(userService.update(adminDto), HttpStatus.OK);}


}
