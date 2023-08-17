package com.studio2h.javawebbbs.mapper;

import com.studio2h.javawebbbs.pojo.post.Post;
import com.studio2h.javawebbbs.pojo.request.PostQueryRequest;
import org.apache.ibatis.annotations.Mapper;

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
     * @param id     帖子id
     * @param status 帖子是否可见
     */
    void updateStatusById(Integer id, Integer status);

    /**
     * 根据条件获取指定帖子
     *
     * @param postQueryRequest 查询条件实例
     * @return 帖子实例
     */
    Post getByConditions(PostQueryRequest postQueryRequest);

    /**
     * 根据条件获取帖子列表
     *
     * @param postQueryRequest 查询条件实例
     * @return 帖子列表
     */
    List<Post> listByConditions(PostQueryRequest postQueryRequest);

    /**
     * 根据条件获取帖子列表，按照创建时间升序排序
     *
     * @param postQueryRequest 查询条件实例
     * @return 帖子列表
     */
    List<Post> listOrderByCreateTime(PostQueryRequest postQueryRequest);

    /**
     * 根据条件获取帖子列表，按照创建时间降序排序
     *
     * @param postQueryRequest 查询条件实例
     * @return 帖子列表
     */
    List<Post> listReverseByCreateTime(PostQueryRequest postQueryRequest);

    /**
     * 根据条件获取帖子列表，按照修改时间升序排序
     *
     * @param postQueryRequest 查询条件实例
     * @return 帖子列表
     */
    List<Post> listOrderByUpdateTime(PostQueryRequest postQueryRequest);

    /**
     * 根据条件获取帖子列表，按照修改时间降序排序
     *
     * @param postQueryRequest 查询条件实例
     * @return 帖子列表
     */
    List<Post> listReverseByUpdateTime(PostQueryRequest postQueryRequest);

    /**
     * 根据条件获取帖子列表，按照评论数量升序排序
     *
     * @param postQueryRequest 查询条件实例
     * @return 帖子列表
     */
    List<Post> listOrderByComments(PostQueryRequest postQueryRequest);

    /**
     * 根据条件获取帖子列表，按照评论数量逆降序排序
     *
     * @param postQueryRequest 查询条件实例
     * @return 帖子列表
     */
    List<Post> listOrderByLikes(PostQueryRequest postQueryRequest);

    /**
     * 根据条件获取帖子列表，按照收藏数量升序排序
     *
     * @param postQueryRequest 查询条件实例
     * @return 帖子列表
     */
    List<Post> listOrderByPrivate(PostQueryRequest postQueryRequest);

    /**
     * 根据条件获取帖子列表，按照收藏数量降序排序
     *
     * @param postQueryRequest 查询条件实例
     * @return 帖子列表
     */
    List<Post> listOrderByBrowsers(PostQueryRequest postQueryRequest);

    /**
     * 根据条件获取帖子数量
     *
     * @param postQueryRequest 查询条件实例
     * @return 帖子数量
     */
    Integer countByConditions(PostQueryRequest postQueryRequest);

    /**
     * 更新帖子
     *
     * @param newPost 新的帖子实例
     */
    void updatePost(Post newPost);
}