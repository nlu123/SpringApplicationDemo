package com.example.demo.mapperTests;

import com.example.demo.TestContainer;
import com.example.demo.persistence.mapper.UserMapper;
import com.example.demo.persistence.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type User mapper test.
 */
@SpringBootTest
public class UserMapperTest extends TestContainer {

    /**
     * The User mapper.
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * Select user test.
     */
    @Test
    @Transactional
    public void selectUserTest() {
        User newUser = new User(0, "UMT SUT");
        userMapper.insertUser(newUser);
        User selectedUser = userMapper.selectUser(newUser.getUserId());
        assertThat(selectedUser.getName()).isEqualTo(newUser.getName());
        assertThat(selectedUser.getUserId()).isEqualTo(newUser.getUserId());
    }

    /**
     * Select user test user not found.
     */
    @Test
    @Transactional
    public void selectUserTestUserNotFound() {
        User selectedUser = userMapper.selectUser(0);
        assertThat(selectedUser).isNull();
    }

    /**
     * Delete user test.
     */
    @Test
    @Transactional
    public void deleteUserTest() {
        User newUser = new User(0, "UMT DUT");
        userMapper.insertUser(newUser);
        User user = userMapper.selectUser(newUser.getUserId());
        assertThat(user).isNotNull();
        userMapper.deleteUser(newUser.getUserId());
        user = userMapper.selectUser(newUser.getUserId());
        assertThat(user).isNull();
    }

    /**
     * Delete user test user not found.
     */
    @Test
    @Transactional
    public void deleteUserTestUserNotFound() {
        userMapper.deleteUser(0);
    }

    /**
     * Insert user test.
     */
    @Test
    @Transactional
    public void insertUserTest() {
        User newUser = new User(0, "UMT IUT");
        userMapper.insertUser(newUser);
        assertThat(newUser.getUserId()).isNotEqualTo(0);
    }

    /**
     * Update user test.
     */
    @Test
    @Transactional
    public void updateUserTest() {
        User newUser = new User(0, "UMT IUT");
        userMapper.insertUser(newUser);
        newUser.setName("UMT IUT 2");
        userMapper.updateUser(newUser);
        User user = userMapper.selectUser(newUser.getUserId());
        assertThat(user.getName()).isEqualTo(newUser.getName());
    }

    /**
     * Update user test user not found.
     */
    @Test
    @Transactional
    public void updateUserTestUserNotFound() {
        User newUser = new User(0, "UMT IUT");
        userMapper.updateUser(newUser);
    }
}
