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
    List<Integer> listFollowersIds(Integer id);

    /**
     * 查找userId为id的用户的粉丝id表
     *
     * @param id 用户id
     * @return 被关注者id表
     */
    List<Integer> listFansIds(Integer id);

    /**
     * 新增关注项
     *
     * @param userFollow 关注项
     */
    void insertNewFollower(UserFollow userFollow);

    /**
     * 删除关注项
     *
     * @param userFollow 关注项
     */
    void deleteFollower(UserFollow userFollow);
}
