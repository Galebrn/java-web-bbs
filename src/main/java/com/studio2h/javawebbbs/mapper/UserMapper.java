package com.studio2h.javawebbbs.mapper;

import com.studio2h.javawebbbs.pojo.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * @author Galebrn
 */
@Mapper
public interface UserMapper {
    /**
     * 根据userId获取用户信息
     *
     * @param id 用户id
     * @return 满足条件的用户信息
     */
    User getUserById(Integer id);

    /**
     * 根据userName获取用户信息
     *
     * @param name 用户名称
     * @return 满足条件的用户信息
     */
    User getUserByName(String name);

    /**
     * 插入新用户
     *
     * @param newUser 新的用户实例
     */
    @Options(keyProperty = "userId", useGeneratedKeys = true)
    void insertUser(User newUser);

    /**
     * 根据userID彻底删除数据库中用户的信息（谨慎使用）
     *
     * @param id 用户id
     */
    void deleteUserById(Integer id);

    /**
     * 根据userName彻底删除数据库中用户的信息（谨慎使用）
     *
     * @param name 用户名称
     */
    void deleteUserByName(String name);
}
