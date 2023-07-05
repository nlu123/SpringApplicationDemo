package com.example.demo.service.implementation;

import com.example.demo.persistence.mapper.UserMapper;
import com.example.demo.persistence.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * The type User service implementation.
 */
@Service
public class UserServiceImplementation implements UserService {

    /**
     * The User mapper.
     */
    private final UserMapper userMapper;

    /**
     * Instantiates a new User service implementation.
     *
     * @param newUserMapper the user mapper
     */
    public UserServiceImplementation(final UserMapper newUserMapper) {
        this.userMapper = newUserMapper;
    }

    @Override
    public final void createUser(final User user) {
        userMapper.insertUser(user);
    }

    @Override
    public final User selectUser(final int userId) {
        return userMapper.selectUser(userId);
    }

    @Override
    public final void updateUser(final User user) {
        userMapper.updateUser(user);
    }

    @Override
    public final void deleteUser(final int userId) {
        userMapper.deleteUser(userId);
    }
}
