package com.studio2h.javawebbbs.service.impl;

import com.studio2h.javawebbbs.mapper.PostMapper;
import com.studio2h.javawebbbs.mapper.PostPrivateMapper;
import com.studio2h.javawebbbs.pojo.post.Post;
import com.studio2h.javawebbbs.pojo.post.PostPrivate;
import com.studio2h.javawebbbs.pojo.request.PostQueryRequest;
import com.studio2h.javawebbbs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Galebrn
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostPrivateMapper postPrivateMapper;
    @Autowired
    private PostMapper postMapper;

    @Override
    public List<Integer> listPrivates(Integer userId) {
        return postPrivateMapper.listPrivatePostIds(userId);
    }

    @Override
    public List<Post> listByIds(List<Integer> privateIds) {
        List<Post> posts = new ArrayList<>();
        PostQueryRequest postQueryRequest = new PostQueryRequest();

        for (Integer id : privateIds) {
            postQueryRequest.setPostId(id);
            posts.add(postMapper.getByConditions(postQueryRequest));
        }
        return posts;
    }
}
