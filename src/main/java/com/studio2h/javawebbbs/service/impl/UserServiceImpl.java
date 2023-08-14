package com.studio2h.javawebbbs.service.impl;

import com.studio2h.javawebbbs.mapper.UserFollowMapper;
import com.studio2h.javawebbbs.mapper.UserMapper;
import com.studio2h.javawebbbs.pojo.request.UserLoginRequest;
import com.studio2h.javawebbbs.pojo.user.User;
import com.studio2h.javawebbbs.pojo.user.UserFollow;
import com.studio2h.javawebbbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Galebrn
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserFollowMapper userFollowMapper;

    @Override
    public User userLogin(UserLoginRequest userLoginRequest) {
        return userMapper.getByNameAndPassword(userLoginRequest.getUserName(), userLoginRequest.getUserPassword());
    }

    @Override
    public List<UserFollow> listFollowers(Integer userId) {
        return userFollowMapper.listById(userId);
    }
}
