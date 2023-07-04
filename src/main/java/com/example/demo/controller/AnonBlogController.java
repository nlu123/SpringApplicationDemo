package com.example.demo.controller;

import com.example.demo.persistence.model.Blog;
import com.example.demo.persistence.model.User;
import com.example.demo.persistence.mapper.BlogMapper;
import com.example.demo.persistence.mapper.UserMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnonBlogController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    BlogMapper blogMapper;

    @PostMapping("/blogs/anon")
    @Transactional
    public int createAnonymousBlog(@Valid @RequestBody Blog blog){
        User user = new User(0, "anon");
        userMapper.insertUser(user);
        blog.setUserId(user.getUserId());
        return blogMapper.insertBlog(blog);
    }
}