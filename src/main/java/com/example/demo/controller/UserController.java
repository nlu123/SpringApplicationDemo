package com.example.demo.controller;

import com.example.demo.persistence.model.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type User controller.
 */
@RestController
public class UserController {

    /**
     * The User service.
     */
    private final UserService userService;

    /**
     * Instantiates a new User controller.
     *
     * @param newUserService the user service
     */
    public UserController(final UserService newUserService) {
        this.userService = newUserService;
    }

    /**
     * Select user user.
     *
     * @param userId the user id
     * @return the user
     */
    @GetMapping("/users/{userId}")
    public User selectUser(@PathVariable final Integer userId) {
        return userService.selectUser(userId);
    }

    /**
     * Create user.
     *
     * @param user the user
     */
    @PostMapping("/users")
    public void createUser(@RequestBody @Valid final User user) {
        userService.createUser(user);
    }

    /**
     * Delete user.
     *
     * @param userId the user id
     */
    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable final Integer userId) {
        userService.deleteUser(userId);
    }

    /**
     * Update user.
     *
     * @param user the user
     */
    @PutMapping("/users")
    public void updateUser(@RequestBody @Valid final User user) {
        userService.updateUser(user);
    }
}
