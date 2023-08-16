package com.studio2h.javawebbbs.mapper;

import com.studio2h.javawebbbs.pojo.post.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Galebrn
 */
@Mapper
public interface CommentMapper {
    /**
     * 新增回复
     *
     * @param comment 回复实例
     */
    void insertNewComment(Comment comment);

    /**
     * 彻底删除回复（慎用）
     *
     * @param id 回复id
     */
    void deleteComment(Integer id);

    /**
     * 修改回复的可见性
     *
     * @param id        回复id
     * @param ifVisible 回复是否可见
     */
    void removeCommentOrNot(Integer id, Integer ifVisible);

    /**
     * 根据主题帖id展示全部回复内容
     *
     * @param id 主题帖id
     * @return 回复信息列表
     */
    List<Comment> listByPostId(Integer id);

    /**
     * 根据回复者id展示全部回复内容
     *
     * @param id 回复者id
     * @return 回复信息列表
     */
    List<Comment> listByAuthorId(Integer id);
}
