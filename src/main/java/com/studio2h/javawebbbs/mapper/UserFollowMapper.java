package com.studio2h.javawebbbs.mapper;

import com.studio2h.javawebbbs.pojo.user.UserFollow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Galebrn
 */
@Mapper
public interface UserFollowMapper {
    /**
     * 列出userId为id的用户的关注列表
     *
     * @param id 用户id
     * @return 用户的关注列表
     */
    List<UserFollow> listById(Integer id);

    /**
     * 遍历关注表
     *
     * @return 关注表
     */
    List<UserFollow> list();

    /**
     * 查找userId为id的用户的关注者id表
     *
     * @param id 用户id
     * @return 关注者id表
     */
    List<Integer> listFollowedId(Integer id);

    /**
     * 查找userId为id的用户的被关注者id表
     *
     * @param id 用户id
     * @return 被关注者id表
     */
    List<Integer> listBeFollowedId(Integer id);

    /**
     * 新增关注项
     *
     * @param id         关注者id
     * @param followedId 被关注者id
     */
    void insertNewFollower(Integer id, Integer followedId);

    /**
     * 删除关注项
     *
     * @param id         关注者id
     * @param followedId 被关注者id
     */
    void deleteFollower(Integer id, Integer followedId);
}
