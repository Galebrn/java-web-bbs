package com.studio2h.javawebbbs.service;

import com.studio2h.javawebbbs.pojo.post.Post;
import com.studio2h.javawebbbs.pojo.post.PostPrivate;

import java.util.List;

/**
 * @author Galebrn
 */
public interface PostService {
    Integer getStatusById(Integer postId);

    List<Integer> listPrivatesIds(Integer userId);

    List<Post> listPrivatePostsByIds(List<Integer> privateIds);

    void insertNewPrivate(PostPrivate postPrivate);

    PostPrivate getPrivateByIds(Integer userId, Integer privatePostId);

    void deletePrivate(PostPrivate postPrivate);

    List<Post> listPostsById(Integer userId);
}
