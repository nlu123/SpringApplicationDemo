package com.example.demo.mapperTests;

import com.example.demo.persistence.mapper.UserMapper;
import com.example.demo.persistence.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Transactional
    @Rollback
    public void selectUserTest(){
        User newUser = new User(0, "UMT SUT");
        userMapper.insertUser(newUser);
        User selectedUser = userMapper.selectUser(newUser.getUserId());
        assertThat(selectedUser.getName()).isEqualTo(newUser.getName());
        assertThat(selectedUser.getUserId()).isEqualTo(newUser.getUserId());
    }

    @Test
    @Transactional
    @Rollback
    public void selectUserTest_userNotFound(){
        User selectedUser = userMapper.selectUser(0);
        assertThat(selectedUser).isNull();
    }

    @Test
    @Transactional
    @Rollback
    public void deleteUserTest(){
        User newUser = new User(0, "UMT DUT");
        userMapper.insertUser(newUser);
        User user = userMapper.selectUser(newUser.getUserId());
        assertThat(user).isNotNull();
        userMapper.deleteUser(newUser.getUserId());
        user = userMapper.selectUser(newUser.getUserId());
        assertThat(user).isNull();
    }

    @Test
    @Transactional
    @Rollback
    public void deleteUserTest_userNotFound(){
        userMapper.deleteUser(0);
    }

    @Test
    @Transactional
    @Rollback
    public void insertUserTest(){
        User newUser = new User(0, "UMT IUT");
        userMapper.insertUser(newUser);
        assertThat(newUser.getUserId()).isNotEqualTo(0);
    }

    @Test
    @Transactional
    @Rollback
    public void updateUserTest(){
        User newUser = new User(0, "UMT IUT");
        userMapper.insertUser(newUser);
        newUser.setName("UMT IUT 2");
        userMapper.updateUser(newUser);
        User user = userMapper.selectUser(newUser.getUserId());
        assertThat(user.getName()).isEqualTo(newUser.getName());
    }

    @Test
    @Transactional
    @Rollback
    public void updateUserTest_userNotFound(){
        User newUser = new User(0, "UMT IUT");
        userMapper.updateUser(newUser);
    }
}