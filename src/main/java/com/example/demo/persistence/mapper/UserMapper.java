package com.example.demo.persistence.mapper;

import com.example.demo.persistence.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USERS WHERE user_id = #{userId}")
    User selectUser(int userId);
    @Delete("DELETE from USERS WHERE user_id = #{userId}")
    int deleteUser(int userId);
    @Insert("INSERT INTO USERS (name) VALUES (#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "user_id")
    int insertUser(User user);
    @Update("UPDATE USERS SET name = #{name} WHERE user_id = #{userId}")
    int updateUser(User user);
}