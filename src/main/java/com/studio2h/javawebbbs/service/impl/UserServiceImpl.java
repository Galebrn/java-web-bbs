package com.studio2h.javawebbbs.service.impl;

import com.studio2h.javawebbbs.mapper.UserFollowMapper;
import com.studio2h.javawebbbs.mapper.UserMapper;
import com.studio2h.javawebbbs.pojo.request.UserLoginRequest;
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
        return userMapper.getByNameAndPassword(userLoginRequest.getUserName(), userLoginRequest.getUserPassword());
    }

    @Override
    public List<UserFollow> listFollowers(Integer userId) {
        return userFollowMapper.listById(userId);
    }

    @Override
    public User getUserById(Integer userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
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
        return userMapper.getUserByPhoneNum(phoneNum);
    }

    @Override
    public User getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

    @Override
    public void updateUser(User newUser) {
        userMapper.updateUserById(newUser);
    }
}
