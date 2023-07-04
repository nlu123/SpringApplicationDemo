package com.example.demo.service;

import com.example.demo.persistence.model.User;
import jakarta.validation.Valid;

public interface UserService {
    void createUser(@Valid User user);
    User selectUser(int userId);
    void updateUser(@Valid User user);
    void deleteUser(int userId);
}