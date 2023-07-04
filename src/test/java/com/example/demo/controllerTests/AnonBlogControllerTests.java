package com.example.demo.controllerTests;

import com.example.demo.controller.AnonBlogController;
import com.example.demo.persistence.model.Blog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
public class AnonBlogControllerTests {

    @Autowired
    private AnonBlogController anonBlogController;

    @Test
    @Transactional
    @Rollback
    void createAnonymousBlogTest(){
        Blog newBlog = new Blog(0,0,"ABC","CABT", null, null);
        anonBlogController.createAnonymousBlog(newBlog);
        assertThat(newBlog.getBlogId()).isNotEqualTo(0);
        assertThat(newBlog.getUserId()).isNotEqualTo(0);
    }

    @Test
    @Transactional
    @Rollback
    void createAnonymousBlog_invalidInput(){
        Blog newBlog = new Blog(0,0,"ABCDEFGHIJKLMNOPQRSTUVWXYZ","CABT", null, null);
        assertThatThrownBy(() -> {anonBlogController.createAnonymousBlog(newBlog);}).isInstanceOf(Exception.class);
    }
}