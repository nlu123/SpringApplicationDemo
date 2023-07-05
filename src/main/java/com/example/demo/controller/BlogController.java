package com.example.demo.controller;

import com.example.demo.persistence.model.Blog;
import com.example.demo.service.BlogService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;

/**
 * The type Blog controller.
 */
@RestController
public class BlogController {

    /**
     * The Blog service.
     */
    private final BlogService blogService;

    /**
     * Instantiates a new Blog controller.
     *
     * @param newBlogService the blog service
     */
    public BlogController(final BlogService newBlogService) {
        this.blogService = newBlogService;
    }

    /**
     * Select blog blog.
     *x
     * @param blogId the blog id
     * @return the blog
     */
    @GetMapping("/blogs/{blogId}")
    public Blog selectBlog(@PathVariable final Integer blogId) {
        return blogService.selectBlog(blogId);
    }

    /**
     * Create blog.
     *
     * @param blog the blog
     */
    @PostMapping("/blogs")
    public void createBlog(@RequestBody final Blog blog) {
        blogService.createBlog(blog);
    }

    /**
     * Delete blog.
     *
     * @param blogId the blog id
     */
    @DeleteMapping("/blogs/{blogId}")
    public void deleteBlog(@PathVariable final Integer blogId) {
        blogService.deleteBlog(blogId);
    }

    /**
     * Update blog.
     *
     * @param blog the blog
     */
    @PutMapping("/blogs")
    public void updateBlog(@RequestBody final Blog blog) {
        blogService.updateBlog(blog);
    }

    /**
     * Select blogs by user list.
     *
     * @param userId the user id
     * @return the list
     */
    @GetMapping("/blogs/user/{userId}")
    public List<Blog> selectBlogsByUser(@PathVariable final Integer userId) {
        return blogService.selectBlogsByUser(userId);
    }

    /**
     * Create anonymous blog.
     *
     * @param blog the blog
     */
    @PostMapping("/blogs/anon")
    @Transactional
    public void createAnonymousBlog(@RequestBody final Blog blog) {
        blogService.createAnonymousBlog(blog);
    }
}
