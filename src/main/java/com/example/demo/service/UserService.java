package com.example.demo.service;

import com.example.demo.persistence.model.User;
import jakarta.validation.Valid;

/**
 * The interface User service.
 */
public interface UserService {
    /**
     * Create user.
     *
     * @param user the user
     */
    void createUser(@Valid User user);

    /**
     * Select user user.
     *
     * @param userId the user id
     * @return the user
     */
    User selectUser(int userId);

    /**
     * Update user.
     *
     * @param user the user
     */
    void updateUser(@Valid User user);

    /**
     * Delete user.
     *
     * @param userId the user id
     */
    void deleteUser(int userId);
}
