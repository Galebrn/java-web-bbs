package com.studio2h.javawebbbs.mapper;

import com.studio2h.javawebbbs.pojo.post.PostPrivate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Galebrn
 */
@Mapper
public interface PostPrivateMapper {
    /**
     * 列出userId为id的用户的收藏帖子表
     *
     * @param id 用户id
     * @return 收藏帖表
     */
    List<PostPrivate> listById(Integer id);

    /**
     * 新增收藏项
     *
     * @param postPrivate 收藏项
     */
    void insertNewPrivate(PostPrivate postPrivate);

    /**
     * 删除收藏项
     *
     * @param postPrivate 收藏项
     */
    void deletePrivate(PostPrivate postPrivate);
}
