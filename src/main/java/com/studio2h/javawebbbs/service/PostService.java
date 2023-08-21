package com.studio2h.javawebbbs.service;

import com.studio2h.javawebbbs.pojo.post.Post;
import com.studio2h.javawebbbs.pojo.post.PostPrivate;

import java.util.List;

/**
 * @author Galebrn
 */
public interface PostService {
    Integer getStatusById(Integer postId);
    List<Integer> listPrivates(Integer userId);

    List<Post> listByIds(List<Integer> privateIds);

    void insertNewPrivate(PostPrivate postPrivate);

    PostPrivate getPrivateByIds(Integer userId, Integer privatePostId);

    void deletePrivate(PostPrivate postPrivate);
}
