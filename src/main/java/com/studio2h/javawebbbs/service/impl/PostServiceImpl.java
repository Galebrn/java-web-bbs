package com.studio2h.javawebbbs.service.impl;

import com.studio2h.javawebbbs.mapper.PostPrivateMapper;
import com.studio2h.javawebbbs.pojo.post.PostPrivate;
import com.studio2h.javawebbbs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Galebrn
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostPrivateMapper postPrivateMapper;

    @Override
    public List<PostPrivate> listPrivates(Integer userId) {
        return postPrivateMapper.listById(userId);
    }
}
