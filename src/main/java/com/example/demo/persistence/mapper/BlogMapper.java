package com.example.demo.persistence.mapper;

import com.example.demo.persistence.model.Blog;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface BlogMapper {
    @Select("SELECT * FROM BLOGS WHERE blog_id = #{blogID}")
    Blog selectBlog(int blogId);

    @Select("SELECT * FROM BLOGS WHERE user_id = #{userId} ORDER BY TIME_CREATED ASC")
    List<Blog> selectBlogsByUser(int userId);

    @Delete("DELETE from BLOGS WHERE blog_id = #{blogId}")
    int deleteBlog(int blogId);

    @Insert("INSERT INTO BLOGS (user_id, title, content, time_created, time_last_modified) VALUES (#{userId}, #{title}, #{content}, (SELECT CURRENT_TIME), (SELECT CURRENT_TIME))")
    @Options(useGeneratedKeys = true, keyProperty = "blogId", keyColumn = "blog_id")
    int insertBlog(Blog blog);

    @Update("UPDATE BLOGS SET title=#{title}, content=#{content}, time_last_modified=(SELECT CURRENT_TIME) WHERE blog_id = #{blogId}")
    int updateBlog(Blog blog);

}