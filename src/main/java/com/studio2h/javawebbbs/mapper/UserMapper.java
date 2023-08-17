package com.studio2h.javawebbbs.mapper;

import com.studio2h.javawebbbs.pojo.request.UserQueryRequest;
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
     * 根据条件获取指定用户
     *
     * @param userQueryRequest 查询条件实例
     * @return 用户实例
     */
    User getByConditions(UserQueryRequest userQueryRequest);

    /**
     * 根据条件获取指定用户数量
     *
     * @param userQueryRequest 查询条件实例
     * @return 用户数量
     */
    Integer countByConditions(UserQueryRequest userQueryRequest);

    /**
     * 根据条件获取用户列表
     *
     * @param userQueryRequest 查询条件实例
     * @return 用户列表
     */
    List<User> listByConditions(UserQueryRequest userQueryRequest);

    /**
     * 根据条件获取用户列表，按经验升序排序
     *
     * @param userQueryRequest 查询条件实例
     * @return 用户列表
     */
    List<User> listOrderByExp(UserQueryRequest userQueryRequest);

    /**
     * 根据条件获取用户列表，按关注数升序排序
     *
     * @param userQueryRequest 查询条件实例
     * @return 用户列表
     */
    List<User> listOrderByFollow(UserQueryRequest userQueryRequest);

    /**
     * 根据条件获取用户列表，按被关注数升序排序
     *
     * @param userQueryRequest 查询条件实例
     * @return 用户列表
     */
    List<User> listOrderByBeFollow(UserQueryRequest userQueryRequest);

    /**
     * 根据条件获取用户列表，按收藏数升序排序
     *
     * @param userQueryRequest 查询条件实例
     * @return 用户列表
     */
    List<User> listOrderByPrivate(UserQueryRequest userQueryRequest);

    /**
     * 根据条件获取用户列表，按发帖数升序排序
     *
     * @param userQueryRequest 查询条件实例
     * @return 用户列表
     */
    List<User> listOrderByPost(UserQueryRequest userQueryRequest);

    /**
     * 根据条件获取用户列表，按评论数升序排序
     *
     * @param userQueryRequest 查询条件实例
     * @return 用户列表
     */
    List<User> listOrderByComment(UserQueryRequest userQueryRequest);

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
     * 根据userID设置userStatus值
     *
     * @param id     用户id
     * @param status 用户状态
     */
    void updateStatusById(Integer id, Integer status);


    /**
     * 更新用户数据
     *
     * @param newUser 新的用户实例
     */
    void updateUser(User newUser);

}