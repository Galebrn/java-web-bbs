package com.studio2h.javawebbbs.service;

import com.studio2h.javawebbbs.pojo.post.Post;
import com.studio2h.javawebbbs.pojo.post.PostPrivate;

import java.util.List;

/**
 * @author Galebrn
 */
public interface PostService {
    List<Integer> listPrivates(Integer userId);

    List<Post> listByIds(List<Integer> privateIds);
}
