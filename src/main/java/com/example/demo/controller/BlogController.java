package com.example.demo.controller;

import com.example.demo.persistence.model.Blog;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs/{blogId}")
    public Blog selectBlog(@PathVariable Integer blogId) {
        return blogService.selectBlog(blogId);
    }

    @PostMapping("/blogs")
    public void createBlog(@RequestBody Blog blog) {
        blogService.createBlog(blog);
    }

    @DeleteMapping("/blogs/{blogId}")
    public void deleteBlog(@PathVariable Integer blogId) {
        blogService.deleteBlog(blogId);
    }

    @PutMapping("/blogs")
    public void updateBlog(@RequestBody Blog blog) { blogService.updateBlog(blog); }

    @GetMapping("/blogs/user/{userId}")
    public List<Blog> selectBlogsByUser(@PathVariable Integer userId) { return blogService.selectBlogsByUser(userId); }

    @PostMapping("/blogs/anon")
    @Transactional
    public void createAnonymousBlog(@RequestBody Blog blog){ blogService.createAnonymousBlog(blog); }
}