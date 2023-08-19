package com.studio2h.javawebbbs.service.impl;

import com.studio2h.javawebbbs.mapper.UserFollowMapper;
import com.studio2h.javawebbbs.mapper.UserMapper;
import com.studio2h.javawebbbs.pojo.request.UserQueryRequest;
import com.studio2h.javawebbbs.pojo.request.UserRegisterRequest;
import com.studio2h.javawebbbs.pojo.response.UserQueryResponse;
import com.studio2h.javawebbbs.pojo.user.User;
import com.studio2h.javawebbbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public User getByConditions(UserQueryRequest userQueryRequest) {
        return userMapper.getByConditions(userQueryRequest);
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
        User newUser = new User(userRegisterRequest);

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

    @Override
    public List<Integer> listFollowers(Integer userId) {
        return userFollowMapper.listFollowersIds(userId);
    }

    @Override
    public List<UserQueryResponse> listByIds(List<Integer> ids) {
        List<UserQueryResponse> userQueryResponses = new ArrayList<>();
        UserQueryRequest userQueryRequest = new UserQueryRequest();

        for (Integer id : ids) {
            userQueryRequest.setUserId(id);
            userQueryResponses.add(userMapper.getByConditionsReturnUqr(userQueryRequest));
        }

        return userQueryResponses;
    }

    @Override
    public List<Integer> listFans(Integer userId) {
        return userFollowMapper.listFansIds(userId);
    }
}
