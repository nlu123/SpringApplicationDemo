package com.example.demo.persistence.mapper;

import com.example.demo.persistence.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;

/**
 * The interface User mapper.
 */
@SuppressWarnings("unused")
@Mapper
public interface UserMapper {
    /**
     * Select user user.
     *
     * @param userId the user id
     * @return the user
     */
    @Select("SELECT * FROM USERS WHERE user_id = #{userId}")
    User selectUser(int userId);

    /**
     * Delete user.
     *
     * @param userId the user id
     */
    @Delete("DELETE from USERS WHERE user_id = #{userId}")
    void deleteUser(int userId);

    /**
     * Insert user.
     *
     * @param user the user
     */
    @Insert("INSERT INTO USERS (name) VALUES (#{name})")
    @Options(useGeneratedKeys = true,
            keyProperty = "userId", keyColumn = "user_id")
    void insertUser(User user);

    /**
     * Update user.
     *
     * @param user the user
     */
    @Update("UPDATE USERS SET name = #{name} WHERE user_id = #{userId}")
    void updateUser(User user);
}
