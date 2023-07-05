package com.example.demo.controller;

import com.example.demo.persistence.model.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{userId}")
    public User selectUser(@PathVariable Integer userId) {
        return userService.selectUser(userId);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody @Valid User user) {
        userService.createUser(user);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
    }

    @PutMapping("/users")
    public void updateUser(@RequestBody @Valid User user) {
        userService.updateUser(user);
    }
}