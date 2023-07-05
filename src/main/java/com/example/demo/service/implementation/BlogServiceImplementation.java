package com.example.demo.service.implementation;

import com.example.demo.persistence.mapper.BlogMapper;
import com.example.demo.persistence.mapper.UserMapper;
import com.example.demo.persistence.model.Blog;
import com.example.demo.persistence.model.User;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Blog service implementation.
 */
@Service
public class BlogServiceImplementation implements BlogService {

    /**
     * The Blog mapper.
     */
    private BlogMapper blogMapper;

    /**
     * The User mapper.
     */
    private final UserMapper userMapper;

    /**
     * Instantiates a new Blog service implementation.
     *
     * @param newUserMapper the user mapper
     */
    public BlogServiceImplementation(final UserMapper newUserMapper) {
        this.userMapper = newUserMapper;
    }

    /**
     * Instantiates a new Blog service implementation.
     *
     * @param newBlogMapper the blog mapper
     * @param newUserMapper the user mapper
     */
    @Autowired
    public BlogServiceImplementation(
            final BlogMapper newBlogMapper, final UserMapper newUserMapper) {
        this.userMapper = newUserMapper;
        this.blogMapper = newBlogMapper;
    }

    @Override
    public final void createBlog(final Blog blog) {
        blogMapper.insertBlog(blog);
    }

    @Override
    public final Blog selectBlog(final int blogId) {
        return blogMapper.selectBlog(blogId);
    }

    @Override
    public final void updateBlog(final Blog blog) {
        blogMapper.updateBlog(blog);
    }

    @Override
    public final List<Blog> selectBlogsByUser(final int userId) {
        return blogMapper.selectBlogsByUser(userId);
    }

    @Override
    public final void deleteBlog(final int blogId) {
        blogMapper.deleteBlog(blogId);
    }

    @Override
    public final void createAnonymousBlog(final Blog blog) {
        User user = new User(0, "anon");
        userMapper.insertUser(user);
        blog.setUserId(user.getUserId());
        blogMapper.insertBlog(blog);
    }
}
