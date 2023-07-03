package com.example.demo.controller;

import com.example.demo.persistence.model.Blog;
import com.example.demo.persistence.mapper.BlogMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private BlogMapper blogMapper;

    @GetMapping("/blogs/{blogId}")
    public Blog selectBlog(@PathVariable Integer blogId) {
        return blogMapper.selectBlog(blogId);
    }

    @PostMapping("/blogs")
    public int createBlog(@RequestBody @Valid Blog blog) {
        return blogMapper.insertBlog(blog);
    }

    @DeleteMapping("/blogs/{blogId}")
    public int deleteBlog(@PathVariable Integer blogId) {
        return blogMapper.deleteBlog(blogId);
    }

    @PutMapping("/blogs")
    public int updateBlog(@RequestBody @Valid Blog blog) { return blogMapper.updateBlog(blog); }

    @GetMapping("/blogs/user/{userId}")
    public List<Blog> selectBlogsByUser(@PathVariable Integer userId) { return blogMapper.selectBlogsByUser(userId); }
}
