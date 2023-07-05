package com.example.demo.service;

import com.example.demo.persistence.model.Blog;
import jakarta.validation.Valid;

import java.util.List;

/**
 * The interface Blog service.
 */
public interface BlogService {

    /**
     * Create blog.
     *
     * @param blog the blog
     */
    void createBlog(@Valid Blog blog);

    /**
     * Select blog blog.
     *
     * @param blogId the blog id
     * @return the blog
     */
    Blog selectBlog(int blogId);

    /**
     * Update blog.
     *
     * @param blog the blog
     */
    void updateBlog(@Valid Blog blog);

    /**
     * Select blogs by user list.
     *
     * @param userId the user id
     * @return the list
     */
    List<Blog> selectBlogsByUser(int userId);

    /**
     * Delete blog.
     *
     * @param blogId the blog id
     */
    void deleteBlog(int blogId);

    /**
     * Create anonymous blog.
     *
     * @param blog the blog
     */
    void createAnonymousBlog(@Valid Blog blog);
}
