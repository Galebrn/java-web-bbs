package com.studio2h.javawebbbs.service.impl;

import com.studio2h.javawebbbs.mapper.UserFollowMapper;
import com.studio2h.javawebbbs.mapper.UserMapper;
import com.studio2h.javawebbbs.pojo.request.UserLoginRequest;
import com.studio2h.javawebbbs.pojo.request.UserQueryRequest;
import com.studio2h.javawebbbs.pojo.request.UserRegisterRequest;
import com.studio2h.javawebbbs.pojo.user.User;
import com.studio2h.javawebbbs.pojo.user.UserFollow;
import com.studio2h.javawebbbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        UserQueryRequest userQueryRequest = new UserQueryRequest();
        userQueryRequest.setUserName(userLoginRequest.getUserName());
        userQueryRequest.setUserPassword(userLoginRequest.getUserPassword());
        return userMapper.getByConditions(userQueryRequest);
    }

    @Override
    public List<UserFollow> listFollowers(Integer userId) {
        return userFollowMapper.listById(userId);
    }

    @Override
    public User getUserById(Integer userId) {
        UserQueryRequest userQueryRequest = new UserQueryRequest();
        userQueryRequest.setUserId(userId);
        return userMapper.getByConditions(userQueryRequest);
    }

    @Override
    public User getUserByName(String name) {
        UserQueryRequest userQueryRequest = new UserQueryRequest();
        userQueryRequest.setUserName(name);
        return userMapper.getByConditions(userQueryRequest);
    }

    @Override
    public void registerNewUser(UserRegisterRequest userRegisterRequest) {
        User newUser = new User(null,
                userRegisterRequest.getUserName(),
                userRegisterRequest.getUserPassword(),
                userRegisterRequest.getUserAvatarPath(),
                userRegisterRequest.getUserSex(),
                null,
                null,
                0,
                0,
                null,
                null,
                0,
                LocalDateTime.now(),
                LocalDateTime.now(),
                1,
                0,
                0,
                0,
                0,
                0);

        userMapper.insertUser(newUser);
    }

    @Override
    public User getUserByPhoneNum(String phoneNum) {
        UserQueryRequest userQueryRequest = new UserQueryRequest();
        userQueryRequest.setUserPhoneNumber(phoneNum);
        return userMapper.getByConditions(userQueryRequest);
    }

    @Override
    public User getUserByEmail(String email) {
        UserQueryRequest userQueryRequest = new UserQueryRequest();
        userQueryRequest.setUserEmail(email);
        return userMapper.getByConditions(userQueryRequest);
    }

    @Override
    public void updateUser(User newUser) {
        userMapper.updateUser(newUser);
    }
}
