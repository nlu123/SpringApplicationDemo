package com.example.demo.controllerTests;

import com.example.demo.TestContainer;
import com.example.demo.controller.BlogController;
import com.example.demo.controller.UserController;
import com.example.demo.persistence.model.Blog;
import com.example.demo.persistence.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class BlogControllerTests extends TestContainer {
    
    @Autowired
    private BlogController blogController;
    
    @Autowired
    private UserController userController;
    
    @Test
    @Transactional
    public void createBlogTest(){
        User newUser = new User(0, "BCT");
        userController.createUser(newUser);
        Blog newBlog = new Blog(0, newUser.getUserId(), "BCT", "CBT", null, null);
        blogController.createBlog(newBlog);
        assertThat(newBlog.getBlogId()).isNotEqualTo(0);
    }
    
    @Test
    @Transactional
    public void createBlogTest_invalidUserId(){
        Blog newBlog = new Blog(0, 0, "BCT", "CBT", null, null);
        assertThatThrownBy(() -> blogController.createBlog(newBlog)).isInstanceOf(Exception.class);
    }
    
    @Test
    @Transactional
    public void deleteBlogTest(){
        User newUser = new User(0, "BCT");
        userController.createUser(newUser);
        Blog newBlog = new Blog(0, newUser.getUserId(), "BCT", "DBT", null, null);
        blogController.createBlog(newBlog);
        blogController.deleteBlog(newBlog.getBlogId());
    }
    
    @Test
    @Transactional
    public void deleteBlog_blogNotFound(){
        blogController.deleteBlog(0);
    }
    
    @Test
    @Transactional
    public void updateBlogTest(){
        User newUser = new User(0, "BCT");
        userController.createUser(newUser);
        Blog newBlog = new Blog(0, newUser.getUserId(), "BCT", "UBT", null, null);
        blogController.createBlog(newBlog);
        newBlog.setTitle("BCT2");
        newBlog.setContent("UBT2");
        blogController.updateBlog(newBlog);
        assertThat(newBlog.getTitle()).isEqualTo("BCT2");
        assertThat(newBlog.getContent()).isEqualTo("UBT2");
    }
    
    @Test
    @Transactional
    public void updateBlogTest_blogNotFound(){
        Blog newBlog = new Blog(0, 0, "BCT", "UBT_BNF", null, null);
        blogController.updateBlog(newBlog);
    }
    
    @Test
    @Transactional
    public void selectBlogTest(){
        User newUser = new User(0, "BCT");
        userController.createUser(newUser);
        Blog newBlog = new Blog(0, newUser.getUserId(), "BCT", "SBT", null, null);
        blogController.createBlog(newBlog);
        Blog selectedBlog = blogController.selectBlog(newBlog.getBlogId());
        assertThat(selectedBlog.getTitle()).isEqualTo("BCT");
        assertThat(selectedBlog.getContent()).isEqualTo("SBT");
    }
    
    @Test
    @Transactional
    public void selectBlogTest_blogNotFound(){
        Blog selectedBlog = blogController.selectBlog(0);
        assert selectedBlog == null;
    }
    
    @Test
    @Transactional
    public void selectBlogsByUserTest(){
        User newUser = new User(0, "BCT");
        userController.createUser(newUser);
        Blog newBlog = new Blog(0, newUser.getUserId(), "BCT", "SBBUT", null, null);
        blogController.createBlog(newBlog);
        Blog newBlog2 = new Blog(0, newUser.getUserId(), "BCT", "SBBUT2", null, null);
        blogController.createBlog(newBlog2);
        List<Blog> selectedList = blogController.selectBlogsByUser(newUser.getUserId());
        assertThat(selectedList.get(0).getContent()).isEqualTo("SBBUT");
        assertThat(selectedList.get(1).getContent()).isEqualTo("SBBUT2");
    }
    
    @Test
    @Transactional
    public void selectBlogsByUserTest_userNotFound(){
        List<Blog> selectedList = blogController.selectBlogsByUser(-1);
        assertThat(selectedList.isEmpty()).isTrue();
    }
    
    @Test
    @Transactional
    public void selectBlogsByUserTest_blogsNotFound(){
        User newUser = new User(0, "BCT");
        userController.createUser(newUser);
        List<Blog> selectedList = blogController.selectBlogsByUser(newUser.getUserId());
        assertThat(selectedList.isEmpty()).isTrue();
    }

    @Test
    @Transactional
    void createAnonymousBlogTest(){
        Blog newBlog = new Blog(0,0,"ABC","CABT", null, null);
        blogController.createAnonymousBlog(newBlog);
        assertThat(newBlog.getBlogId()).isNotEqualTo(0);
        assertThat(newBlog.getUserId()).isNotEqualTo(0);
    }

    @Test
    @Transactional
    void createAnonymousBlog_invalidInput(){
        Blog newBlog = new Blog(0,0,"ABCDEFGHIJKLMNOPQRSTUVWXYZ","CABT", null, null);
        assertThatThrownBy(() -> blogController.createAnonymousBlog(newBlog)).isInstanceOf(Exception.class);
    }
}