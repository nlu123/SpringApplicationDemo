package com.example.demo.service;

import com.example.demo.persistence.model.Blog;
import jakarta.validation.Valid;

import java.util.List;

public interface BlogService {

    void createBlog(@Valid Blog blog);

    Blog selectBlog(int blogId);

    void updateBlog(@Valid Blog blog);

    List<Blog> selectBlogsByUser(int userId);

    void deleteBlog(int blogId);

    void createAnonymousBlog(@Valid Blog blog);
}