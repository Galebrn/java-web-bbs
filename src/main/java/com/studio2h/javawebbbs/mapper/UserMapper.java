package com.studio2h.javawebbbs.mapper;

import com.studio2h.javawebbbs.pojo.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

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

    /**
     * 根据userID设置userStatus值
     *
     * @param id     用户id
     * @param status 用户状态
     */
    void updateStatusById(Integer id, Integer status);

    /**
     * 根据userID设置userStatus值
     *
     * @param name   用户名称
     * @param status 用户状态
     */
    void removeUserOrNotByName(String name, Integer status);

    /**
     * 根据userId更新用户数据
     *
     * @param newUser 新的用户实例
     */
    void updateUserById(User newUser);

    /**
     * 根据name更新用户数据
     *
     * @param newUser 新的用户实例
     * @param name    用户名称
     */
    void updateUserByName(User newUser, String name);

    /**
     * 获取数据库中用户总数
     *
     * @return 用户总数
     */
    Integer countUsers();

    /**
     * 获取数据库中启用的用户总数
     *
     * @return 启用的用户总数
     */
    Integer countUsedUsers();

    /**
     * 查询所有启用的用户数据
     *
     * @return 启用的用户列表
     */
    List<User> listAllUsedUsers();

    /**
     * 查询所有用户数据
     *
     * @return 总用户列表
     */
    List<User> listAllUsers();

    /**
     * 查询是否存在用户，userEmail = email
     *
     * @param email 邮箱
     * @return 满足条件的用户信息
     */
    User getByEmail(String email);

    /**
     * 根据userName和userPassword获取用户
     *
     * @param name     用户名称
     * @param password 用户密码
     * @return 用户实例
     */
    User getByNameAndPassword(String name, String password);

    /**
     * 根据userPhoneNumber获取用户
     *
     * @param phoneNum 用户电话号码
     * @return 用户实例
     */
    User getUserByPhoneNum(String phoneNum);

    /**
     * 根据userEmail获取用户
     *
     * @param email 用户电子邮箱
     * @return 用户实例
     */
    User getUserByEmail(String email);
}