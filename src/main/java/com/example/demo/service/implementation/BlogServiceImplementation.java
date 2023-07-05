package com.example.demo.service.implementation;

import com.example.demo.persistence.mapper.BlogMapper;
import com.example.demo.persistence.mapper.UserMapper;
import com.example.demo.persistence.model.Blog;
import com.example.demo.persistence.model.User;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImplementation implements BlogService {

    private BlogMapper blogMapper;

    private UserMapper userMapper;

    public BlogServiceImplementation(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public BlogServiceImplementation(BlogMapper blogMapper, UserMapper userMapper) {
        this.userMapper = userMapper;
        this.blogMapper = blogMapper;
    }

    @Override
    public void createBlog(Blog blog) {
        blogMapper.insertBlog(blog);
    }

    @Override
    public Blog selectBlog(int blogId) {
        return blogMapper.selectBlog(blogId);
    }

    @Override
    public void updateBlog(Blog blog) {
        blogMapper.updateBlog(blog);
    }

    @Override
    public List<Blog> selectBlogsByUser(int userId) {
        return blogMapper.selectBlogsByUser(userId);
    }

    @Override
    public void deleteBlog(int blogId) {
        blogMapper.deleteBlog(blogId);
    }

    @Override
    public void createAnonymousBlog(Blog blog) {
        User user = new User(0, "anon");
        userMapper.insertUser(user);
        blog.setUserId(user.getUserId());
        blogMapper.insertBlog(blog);
    }
}