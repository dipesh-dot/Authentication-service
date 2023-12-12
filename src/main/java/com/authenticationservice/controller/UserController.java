package com.authenticationservice.controller;



import com.authenticationservice.entity.User;
import com.authenticationservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok().body(userService.create(user));
    }
    @GetMapping("/{id}")
    ResponseEntity<User> getUserBYId(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.getById(id));
    }

    @GetMapping("/all")
    ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok().body(userService.getAll());
    }
}
