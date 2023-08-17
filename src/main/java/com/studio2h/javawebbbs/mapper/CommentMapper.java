package com.studio2h.javawebbbs.mapper;

import com.studio2h.javawebbbs.pojo.post.Comment;
import com.studio2h.javawebbbs.pojo.request.CommentQueryRequest;
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
     * @param id     回复id
     * @param status 回复是否可见
     */
    void updateStatus(Integer id, Integer status);

    /**
     * 根据条获取回复
     *
     * @param commentQueryRequest 查询条件实例
     * @return 回复实例
     */
    Comment getByConditions(CommentQueryRequest commentQueryRequest);

    /**
     * 根据条件获取回复列表
     *
     * @param commentQueryRequest 查询条件实例
     * @return 回复列表
     */
    List<Comment> listByConditions(CommentQueryRequest commentQueryRequest);

    /**
     * 根据条件获取回复列表，按照创建时间升序排序
     *
     * @param commentQueryRequest 查询条件实例
     * @return 回复列表
     */
    List<Comment> listOderByCreateTime(CommentQueryRequest commentQueryRequest);

    /**
     * 根据条件获取回复列表，按照创建时间降序排序
     *
     * @param commentQueryRequest 查询条件实例
     * @return 回复列表
     */
    List<Comment> listReverseByCreateTime(CommentQueryRequest commentQueryRequest);

    /**
     * 根据条件获取回复数
     *
     * @param commentQueryRequest 查询条件实例
     * @return 回复数
     */
    Integer countByConditions(CommentQueryRequest commentQueryRequest);
}
