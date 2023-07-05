package com.example.demo.controllerTests;

import com.example.demo.TestContainer;
import com.example.demo.controller.BlogController;
import com.example.demo.controller.UserController;
import com.example.demo.persistence.model.Blog;
import com.example.demo.persistence.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

public class UserControllerTests extends TestContainer {

    @Autowired
    private UserController userController;

    @Autowired
    private BlogController blogController;

    @Test
    @Transactional
    public void createUserTest(){
        User newUser = new User(0, "UCT CUT");
        userController.createUser(newUser);
        assertThat(newUser.getUserId()).isNotEqualTo(0);
    }

    @Test
    @Transactional
    public void selectUserTest(){
        User newUser = new User(0, "UCT SUT");
        userController.createUser(newUser);
        User user = userController.selectUser(newUser.getUserId());
        assertThat(user.getUserId()).isEqualTo(newUser.getUserId());
        assertThat(user.getName()).isEqualTo(newUser.getName());
    }

    @Test
    @Transactional
    public void selectUserTest_userNotFound(){
        User user = userController.selectUser(0);
        assertThat(user).isNull();
    }

    @Test
    @Transactional
    public void deleteUserTest(){
        User newUser = new User(0, "UCT DUT");
        userController.createUser(newUser);
        User user = userController.selectUser(newUser.getUserId());
        assertThat(user).isNotNull();
        userController.deleteUser(newUser.getUserId());
        user = userController.selectUser(newUser.getUserId());
        assertThat(user).isNull();
    }

    @Test
    @Transactional
    public void deleteUserTest_blogsExists(){
        User newUser = new User(0, "UCT DUT");
        userController.createUser(newUser);
        Blog newBlog = new Blog(0, newUser.getUserId(), "UCT", "DUT", null, null);
        blogController.createBlog(newBlog);
        assertThatThrownBy(() -> userController.deleteUser(newUser.getUserId())).isInstanceOf(Exception.class);
    }

    @Test
    @Transactional
    public void deleteUserTest_userNotFound(){
        userController.deleteUser(0);
    }

    @Test
    @Transactional
    public void updateUserTest(){
        User newUser = new User(0, "UCT UUT");
        userController.createUser(newUser);
        User updateUser = new User(newUser.getUserId(), "UCT UUT 2");
        userController.updateUser(updateUser);
        User selectUser = userController.selectUser(newUser.getUserId());
        assertThat(selectUser.getName()).isEqualTo("UCT UUT 2");
    }

    @Test
    @Transactional
    public void updateUserTest_userNotFound(){
        User newUser = new User(0, "UCT UUT");
        userController.createUser(newUser);
        User updateUser = new User(0, "UCT UUT 2");
        userController.updateUser(updateUser);
        User selectUser = userController.selectUser(newUser.getUserId());
        assertThat(selectUser.getName()).isEqualTo("UCT UUT");
    }
}