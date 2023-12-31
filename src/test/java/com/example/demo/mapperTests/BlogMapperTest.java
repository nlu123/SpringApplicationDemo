package com.example.demo.mapperTests;

import com.example.demo.TestContainer;
import com.example.demo.persistence.mapper.BlogMapper;
import com.example.demo.persistence.mapper.UserMapper;
import com.example.demo.persistence.model.Blog;
import com.example.demo.persistence.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.List;

/**
 * The type Blog mapper test.
 */
@SpringBootTest
public class BlogMapperTest extends TestContainer {

    /**
     * The Blog mapper.
     */
    @Autowired
    private BlogMapper blogMapper;

    /**
     * The User mapper.
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * Select blog test.
     */
    @Test
    @Transactional
    public void selectBlogTest() {
        User newUser = new User(0, "BMT SBT");
        userMapper.insertUser(newUser);
        Blog newBlog = new Blog(
                0, newUser.getUserId(), "SBT TITLE", "SBT CONTENT", null, null);
        blogMapper.insertBlog(newBlog);
        Blog selectedBlog = blogMapper.selectBlog(newBlog.getBlogId());
        assertThat(selectedBlog.getTitle()).isEqualTo("SBT TITLE");
        assertThat(selectedBlog.getBlogId()).isEqualTo(newBlog.getBlogId());
        assertThat(selectedBlog.getContent()).isEqualTo("SBT CONTENT");
    }

    /**
     * Select blog test blog not found.
     */
    @Test
    @Transactional
    public void selectBlogTestBlogNotFound() {
        Blog selectedBlog = blogMapper.selectBlog(0);
        assertThat(selectedBlog).isNull();
    }


    /**
     * Select blogs by user test.
     */
    @Test
    @Transactional
    public void selectBlogsByUserTest() {
        User newUser = new User(0, "BMT SBBUT");
        userMapper.insertUser(newUser);
        Blog newBlog1 = new Blog(
                0, newUser.getUserId(), "SBBUT TITLE 1",
                "SBBUT CONTENT 1", null, null);
        blogMapper.insertBlog(newBlog1);
        Blog newBlog2 = new Blog(
                0, newUser.getUserId(), "SBBUT TITLE 2",
                "SBBUT CONTENT 2", null, null);
        blogMapper.insertBlog(newBlog2);
        List<Blog> selectedBlogs =
                blogMapper.selectBlogsByUser(newUser.getUserId());
        assertThat(selectedBlogs.get(0).getBlogId())
                .isEqualTo(newBlog1.getBlogId());
        assertThat(selectedBlogs.get(1).getBlogId())
                .isEqualTo(newBlog2.getBlogId());
    }

    /**
     * Select blogs by user test user not found.
     */
    @Test
    @Transactional
    public void selectBlogsByUserTestUserNotFound() {
        List<Blog> selectedBlogs = blogMapper.selectBlogsByUser(0);
        assertThat(selectedBlogs.size()).isEqualTo(0);
    }

    /**
     * Select blogs by user test blogs not found.
     */
    @Test
    @Transactional
    public void selectBlogsByUserTestBlogsNotFound() {
        User newUser = new User(0, "BMT SBBUT");
        userMapper.insertUser(newUser);
        List<Blog> selectedBlogs =
                blogMapper.selectBlogsByUser(newUser.getUserId());
        assertThat(selectedBlogs.size()).isEqualTo(0);
    }

    /**
     * Delete blog test.
     */
    @Test
    @Transactional
    public void deleteBlogTest() {
        User newUser = new User(0, "BMT DBT");
        userMapper.insertUser(newUser);
        Blog newBlog = new Blog(
                0, newUser.getUserId(), "DBT TITLE",
                "DBT CONTENT", null, null);
        blogMapper.insertBlog(newBlog);
        Blog blog = blogMapper.selectBlog(newBlog.getBlogId());
        assertThat(blog).isNotNull();
        blogMapper.deleteBlog(newBlog.getBlogId());
        blog = blogMapper.selectBlog(newBlog.getBlogId());
        assertThat(blog).isNull();
    }

    /**
     * Delete blog test blog not found.
     */
    @Test
    @Transactional
    public void deleteBlogTestBlogNotFound() {
        blogMapper.deleteBlog(0);
    }

    /**
     * Insert blog test.
     */
    @Test
    @Transactional
    public void insertBlogTest() {
        User newUser = new User(0, "BMT IBT");
        userMapper.insertUser(newUser);
        Blog newBlog = new Blog(
                0, newUser.getUserId(), "IBT TITLE",
                "IBT CONTENT", null, null);
        blogMapper.insertBlog(newBlog);
        assertThat(newBlog.getBlogId()).isNotEqualTo(0);
    }

    /**
     * Insert blog test invalid user id.
     */
    @Test
    @Transactional
    public void insertBlogTestInvalidUserId() {
        Blog newBlog = new Blog(0, 0, "IBT TITLE", "IBT CONTENT", null, null);
        assertThatThrownBy(() ->
                blogMapper.insertBlog(newBlog)).isInstanceOf(Exception.class);
    }

    /**
     * Update blog test.
     */
    @Test
    @Transactional
    public void updateBlogTest() {
        User newUser = new User(0, "BMT UBT");
        userMapper.insertUser(newUser);
        Blog newBlog = new Blog(
                0, newUser.getUserId(), "UBT TITLE",
                "UBT CONTENT", null, null);
        blogMapper.insertBlog(newBlog);
        newBlog.setTitle("UBT TITLE 1");
        newBlog.setContent("UBT CONTENT 1");
        blogMapper.updateBlog(newBlog);
        Blog blog = blogMapper.selectBlog(newBlog.getBlogId());
        assertThat(blog.getTitle()).isEqualTo(newBlog.getTitle());
        assertThat(blog.getBlogId()).isEqualTo(newBlog.getBlogId());
        assertThat(blog.getContent()).isEqualTo(newBlog.getContent());
    }

    /**
     * Update blog test blog not found.
     */
    @Test
    @Transactional
    public void updateBlogTestBlogNotFound() {
        Blog newBlog = new Blog(0, 0, "UBT TITLE", "UBT CONTENT", null, null);
        blogMapper.updateBlog(newBlog);
    }
}
