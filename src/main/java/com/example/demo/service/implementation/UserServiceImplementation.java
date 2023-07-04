package com.example.demo.service.implementation;

import com.example.demo.persistence.mapper.UserMapper;
import com.example.demo.persistence.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserMapper userMapper;

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