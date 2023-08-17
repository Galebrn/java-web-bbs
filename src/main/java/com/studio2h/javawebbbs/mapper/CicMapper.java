package com.studio2h.javawebbbs.mapper;

import com.studio2h.javawebbbs.pojo.post.CommentInComment;
import com.studio2h.javawebbbs.pojo.request.CicQueryRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Galebrn
 */
@Mapper
public interface CicMapper {
    /**
     * 根据条件获取楼中楼
     *
     * @param cicQueryRequest 查询条件实例
     * @return 楼中楼实例
     */
    CommentInComment getByConditions(CicQueryRequest cicQueryRequest);

    /**
     * 根据条件获取楼中楼列表
     *
     * @param cicQueryRequest 查询条件实例
     * @return 楼中楼列表
     */
    List<CommentInComment> listByConditions(CicQueryRequest cicQueryRequest);

    /**
     * 根据条件获取楼中楼数量
     *
     * @param cicQueryRequest 查询条件实例
     * @return 楼中楼数量
     */
    Integer countByConditions(CicQueryRequest cicQueryRequest);

    /**
     * 更新楼中楼status信息
     *
     * @param cicId  楼中楼id
     * @param status 状态信息
     */
    void updateStatus(Integer cicId, Integer status);

    /**
     * 新增楼中楼
     *
     * @param newCic 新的楼中楼实例
     */
    void insertNewCic(CommentInComment newCic);
}
