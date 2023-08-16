package com.studio2h.javawebbbs.mapper;

import com.studio2h.javawebbbs.pojo.post.Post;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Galebrn
 */
@Mapper
public interface PostMapper {
    /**
     * 新增帖子
     *
     * @param post 帖子实例
     */
    void insertNewPost(Post post);

    /**
     * 删除帖子（慎用）
     *
     * @param id 帖子id
     */
    void deletePost(Integer id);

    /**
     * 设置帖子可见性
     *
     * @param id        帖子id
     * @param ifVisible 帖子是否可见
     */
    void removePostOrNot(Integer id, Integer ifVisible);

    /**
     * 根据postId获取帖子
     *
     * @param id 帖子id
     * @return 帖子实例
     */
    Post getPostById(Integer id);

    /**
     * 根据postTitle获取帖子
     *
     * @param title 帖子标题
     * @return 帖子实例
     */
    List<Post> listPostByTitle(String title);

    /**
     * 根据authorId获取帖子
     *
     * @param id 帖子创作者id
     * @return 帖子实例
     */
    List<Post> listPostByAuthor(Integer id);

    /**
     * 根据createTime获取帖子列表，顺序排序
     *
     * @param startTime 起始查询时间
     * @param endTime   末尾查询时间
     * @return 帖子列表
     */
    List<Post> listOrderByCreateTime(LocalDateTime startTime, LocalDateTime endTime);

    /**
     * 根据createTime获取帖子列表，倒序排序
     *
     * @param startTime 起始查询时间
     * @param endTime   末尾查询时间
     * @return 帖子列表
     */
    List<Post> listReverseByCreateTime(LocalDateTime startTime, LocalDateTime endTime);

    /**
     * 根据updateTime获取帖子列表，顺序排序
     *
     * @param startTime 起始查询时间
     * @param endTime   末尾查询时间
     * @return 帖子列表
     */
    List<Post> listOrderByUpdateTime(LocalDateTime startTime, LocalDateTime endTime);

    /**
     * 根据updateTime获取帖子列表，倒序排序
     *
     * @param startTime 起始查询时间
     * @param endTime   末尾查询时间
     * @return 帖子列表
     */
    List<Post> listReverseByUpdateTime(LocalDateTime startTime, LocalDateTime endTime);

    /**
     * 根据createTime和categoryId查询帖子列表，顺序排序
     *
     * @param startTime  起始插叙时间
     * @param endTime    末尾查询时间
     * @param categoryId 帖子分类id
     * @return 帖子列表
     */
    List<Post> listOrderByCreateTimeAndCategory(LocalDateTime startTime, LocalDateTime endTime, Integer categoryId);

    /**
     * 根据createTime和categoryId查询帖子列表，倒序排序
     *
     * @param startTime  起始插叙时间
     * @param endTime    末尾查询时间
     * @param categoryId 帖子分类id
     * @return 帖子列表
     */
    List<Post> listReverseByCreateTimeAndCategory(LocalDateTime startTime, LocalDateTime endTime, Integer categoryId);

    /**
     * 根据updateTime和categoryId查询帖子列表，顺序排序
     *
     * @param startTime  起始插叙时间
     * @param endTime    末尾查询时间
     * @param categoryId 帖子分类id
     * @return 帖子列表
     */
    List<Post> listOrderByUpdateTimeAndCategory(LocalDateTime startTime, LocalDateTime endTime, Integer categoryId);

    /**
     * 根据updateTime和categoryId查询帖子列表，倒序排序
     *
     * @param startTime  起始插叙时间
     * @param endTime    末尾查询时间
     * @param categoryId 帖子分类id
     * @return 帖子列表
     */
    List<Post> listReverseByUpdateTimeAndCategory(LocalDateTime startTime, LocalDateTime endTime, Integer categoryId);
}