package com.example.demo.controllerTests;

import com.example.demo.TestContainer;
import com.example.demo.controller.BlogController;
import com.example.demo.controller.UserController;
import com.example.demo.persistence.model.Blog;
import com.example.demo.persistence.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * The type User controller tests.
 */
public class UserControllerTests extends TestContainer {

    /**
     * The User controller.
     */
    @Autowired
    private UserController userController;

    /**
     * The Blog controller.
     */
    @Autowired
    private BlogController blogController;

    /**
     * Create user test.
     */
    @Test
    @Transactional
    public void createUserTest() {
        User newUser = new User(0, "UCT CUT");
        userController.createUser(newUser);
        assertThat(newUser.getUserId()).isNotEqualTo(0);
    }

    /**
     * Select user test.
     */
    @Test
    @Transactional
    public void selectUserTest() {
        User newUser = new User(0, "UCT SUT");
        userController.createUser(newUser);
        User user = userController.selectUser(newUser.getUserId());
        assertThat(user.getUserId()).isEqualTo(newUser.getUserId());
        assertThat(user.getName()).isEqualTo(newUser.getName());
    }

    /**
     * Select user test user not found.
     */
    @Test
    @Transactional
    public void selectUserTestUserNotFound() {
        User user = userController.selectUser(0);
        assertThat(user).isNull();
    }

    /**
     * Delete user test.
     */
    @Test
    @Transactional
    public void deleteUserTest() {
        User newUser = new User(0, "UCT DUT");
        userController.createUser(newUser);
        User user = userController.selectUser(newUser.getUserId());
        assertThat(user).isNotNull();
        userController.deleteUser(newUser.getUserId());
        user = userController.selectUser(newUser.getUserId());
        assertThat(user).isNull();
    }

    /**
     * Delete user test blogs exists.
     */
    @Test
    @Transactional
    public void deleteUserTestBlogsExists() {
        User newUser = new User(0, "UCT DUT");
        userController.createUser(newUser);
        Blog newBlog = new Blog(
                0, newUser.getUserId(), "UCT", "DUT", null, null);
        blogController.createBlog(newBlog);
        assertThatThrownBy(() ->
                userController.deleteUser(newUser.getUserId()))
                .isInstanceOf(Exception.class);
    }

    /**
     * Delete user test user not found.
     */
    @Test
    @Transactional
    public void deleteUserTestUserNotFound() {
        userController.deleteUser(0);
    }

    /**
     * Update user test.
     */
    @Test
    @Transactional
    public void updateUserTest() {
        User newUser = new User(0, "UCT UUT");
        userController.createUser(newUser);
        User updateUser = new User(newUser.getUserId(), "UCT UUT 2");
        userController.updateUser(updateUser);
        User selectUser = userController.selectUser(newUser.getUserId());
        assertThat(selectUser.getName()).isEqualTo("UCT UUT 2");
    }

    /**
     * Update user test user not found.
     */
    @Test
    @Transactional
    public void updateUserTestUserNotFound() {
        User newUser = new User(0, "UCT UUT");
        userController.createUser(newUser);
        User updateUser = new User(0, "UCT UUT 2");
        userController.updateUser(updateUser);
        User selectUser = userController.selectUser(newUser.getUserId());
        assertThat(selectUser.getName()).isEqualTo("UCT UUT");
    }
}
