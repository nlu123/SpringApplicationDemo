package com.example.demo.service.implementation;

import com.example.demo.persistence.mapper.UserMapper;
import com.example.demo.persistence.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    private final UserMapper userMapper;

    public UserServiceImplementation(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void createUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public User selectUser(int userId) {
        return userMapper.selectUser(userId);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(int userId) {
        userMapper.deleteUser(userId);
    }
}