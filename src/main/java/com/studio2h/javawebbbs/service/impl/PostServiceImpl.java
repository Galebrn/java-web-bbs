package com.studio2h.javawebbbs.service.impl;

import com.studio2h.javawebbbs.constant.StatusConstant;
import com.studio2h.javawebbbs.mapper.PostMapper;
import com.studio2h.javawebbbs.mapper.PostPrivateMapper;
import com.studio2h.javawebbbs.mapper.UserMapper;
import com.studio2h.javawebbbs.pojo.post.Post;
import com.studio2h.javawebbbs.pojo.post.PostPrivate;
import com.studio2h.javawebbbs.pojo.request.PostQueryRequest;
import com.studio2h.javawebbbs.pojo.request.UserQueryRequest;
import com.studio2h.javawebbbs.pojo.user.User;
import com.studio2h.javawebbbs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer getStatusById(Integer postId) {
        PostQueryRequest postQueryRequest = new PostQueryRequest();
        postQueryRequest.setPostId(postId);
        Post post = postMapper.getByConditions(postQueryRequest);

        if (post == null) {
            return StatusConstant.ABSENT;
        } else {
            return post.getPostStatus();
        }
    }

    @Override
    public List<Integer> listPrivatesIds(Integer userId) {
        return postPrivateMapper.listPrivatePostIds(userId);
    }

    @Override
    public List<Post> listPrivatePostsByIds(List<Integer> privateIds) {
        List<Post> posts = new ArrayList<>();
        PostQueryRequest postQueryRequest = new PostQueryRequest();

        for (Integer id : privateIds) {
            postQueryRequest.setPostId(id);
            posts.add(postMapper.getByConditions(postQueryRequest));
        }
        return posts;
    }

    @Override
    public void insertNewPrivate(PostPrivate postPrivate) {
        postPrivateMapper.insertNewPrivate(postPrivate);

        UserQueryRequest userQueryRequest = new UserQueryRequest();
        userQueryRequest.setUserId(postPrivate.getUserId());
        User user = userMapper.getByConditions(userQueryRequest);
        user.setCountOfPrivatePosts(user.getCountOfPrivatePosts() + 1);
        user.setUpdateTime(LocalDateTime.now());
        userMapper.updateUser(user);

        PostQueryRequest postQueryRequest = new PostQueryRequest();
        postQueryRequest.setPostId(postPrivate.getPostId());
        Post post = postMapper.getByConditions(postQueryRequest);
        post.setCountOfPrivate(post.getCountOfPrivate() + 1);
        post.setUpdateTime(LocalDateTime.now());
        postMapper.updatePost(post);
    }

    @Override
    public PostPrivate getPrivateByIds(Integer userId, Integer postId) {
        return postPrivateMapper.getByIds(userId, postId);
    }

    @Override
    public void deletePrivate(PostPrivate postPrivate) {
        postPrivateMapper.deletePrivate(postPrivate);

        UserQueryRequest userQueryRequest = new UserQueryRequest();
        userQueryRequest.setUserId(postPrivate.getUserId());
        User user = userMapper.getByConditions(userQueryRequest);
        user.setCountOfPrivatePosts(user.getCountOfPrivatePosts() - 1);
        user.setUpdateTime(LocalDateTime.now());
        userMapper.updateUser(user);

        PostQueryRequest postQueryRequest = new PostQueryRequest();
        postQueryRequest.setPostId(postPrivate.getPostId());
        Post post = postMapper.getByConditions(postQueryRequest);
        post.setCountOfPrivate(post.getCountOfPrivate() - 1);
        post.setUpdateTime(LocalDateTime.now());
        postMapper.updatePost(post);
    }

    @Override
    public List<Post> listPostsById(Integer userId) {
        PostQueryRequest postQueryRequest = new PostQueryRequest();
        postQueryRequest.setAuthorId(userId);
        return postMapper.listByConditions(postQueryRequest);
    }
}
