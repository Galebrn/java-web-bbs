package com.studio2h.javawebbbs.service;

import com.studio2h.javawebbbs.pojo.post.PostPrivate;

import java.util.List;

/**
 * @author Galebrn
 */
public interface PostService {
    List<PostPrivate> listPrivates(Integer userId);
}
