package com.studio2h.javawebbbs.mapper;

import com.studio2h.javawebbbs.pojo.post.Post;
import org.apache.ibatis.annotations.Mapper;

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
    Post getPostByTitle(String title);

    /**
     * 根据authorId获取帖子
     *
     * @param id 帖子创作者id
     * @return 帖子实例
     */
    Post getPostByAuthor(Integer id);

}
