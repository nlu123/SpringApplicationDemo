package com.example.demo.persistence.mapper;

import com.example.demo.persistence.model.Blog;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import java.util.List;

/**
 * The interface Blog mapper.
 */
@SuppressWarnings("unused")
@Mapper
public interface BlogMapper {
    /**
     * Select blog blog.
     *
     * @param blogId the blog id
     * @return the blog
     */
    @Select("SELECT * FROM BLOGS WHERE blog_id = #{blogID}")
    Blog selectBlog(int blogId);

    /**
     * Select blogs by user list.
     *
     * @param userId the user id
     * @return the list
     */
    @Select("SELECT * FROM BLOGS WHERE "
            + "user_id = #{userId} ORDER BY TIME_CREATED ASC")
    List<Blog> selectBlogsByUser(int userId);

    /**
     * Delete blog.
     *
     * @param blogId the blog id
     */
    @Delete("DELETE from BLOGS WHERE blog_id = #{blogId}")
    void deleteBlog(int blogId);

    /**
     * Insert blog.
     *
     * @param blog the blog
     */
    @Insert("INSERT INTO BLOGS "
            + "(user_id, title, content, time_created, time_last_modified)"
            + "VALUES (#{userId}, #{title}, #{content}, "
            + "(SELECT CURRENT_TIME), (SELECT CURRENT_TIME))")
    @Options(useGeneratedKeys = true,
            keyProperty = "blogId", keyColumn = "blog_id")
    void insertBlog(Blog blog);

    /**
     * Update blog.
     *
     * @param blog the blog
     */
    @Update("UPDATE BLOGS SET "
            + "title=#{title}, content=#{content}, "
            + "time_last_modified=(SELECT CURRENT_TIME) "
            + "WHERE blog_id = #{blogId}")
    void updateBlog(Blog blog);

}
