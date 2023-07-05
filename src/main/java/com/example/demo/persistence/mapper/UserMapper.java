package com.example.demo.persistence.mapper;

import com.example.demo.persistence.model.User;
import org.apache.ibatis.annotations.*;

@SuppressWarnings("unused")
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USERS WHERE user_id = #{userId}")
    User selectUser(int userId);
    @Delete("DELETE from USERS WHERE user_id = #{userId}")
    void deleteUser(int userId);
    @Insert("INSERT INTO USERS (name) VALUES (#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "user_id")
    void insertUser(User user);
    @Update("UPDATE USERS SET name = #{name} WHERE user_id = #{userId}")
    void updateUser(User user);
}