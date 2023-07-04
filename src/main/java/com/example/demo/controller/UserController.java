package com.example.demo.controller;

import com.example.demo.persistence.model.User;
import com.example.demo.persistence.mapper.UserMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/users/{userId}")
    public User selectUser(@PathVariable Integer userId) {
        return userMapper.selectUser(userId);
    }

    @PostMapping("/users")
    public int createUser(@RequestBody @Valid User user) {
        return userMapper.insertUser(user);
    }

    @DeleteMapping("/users/{userId}")
    public int deleteUser(@PathVariable Integer userId) {
        return userMapper.deleteUser(userId);
    }

    @PutMapping("/users")
    public int updateUser(@RequestBody @Valid User user) {
        return userMapper.updateUser(user);
    }
}