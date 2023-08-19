package com.studio2h.javawebbbs.service;

import com.studio2h.javawebbbs.pojo.request.UserQueryRequest;
import com.studio2h.javawebbbs.pojo.request.UserRegisterRequest;
import com.studio2h.javawebbbs.pojo.response.UserQueryResponse;
import com.studio2h.javawebbbs.pojo.user.User;
import com.studio2h.javawebbbs.pojo.user.UserFollow;

import java.util.List;

/**
 * @author Galebrn
 */


public interface UserService {

    User getByConditions(UserQueryRequest userQueryRequest);

    User getUserById(Integer userId);

    User getUserByName(String name);

    void registerNewUser(UserRegisterRequest userRegisterRequest);

    User getUserByPhoneNum(String phoneNum);

    User getUserByEmail(String email);

    void updateUser(User newUser);

    List<Integer> listFollowers(Integer userId);

    List<UserQueryResponse> listByIds(List<Integer> ids);

    List<Integer> listFans(Integer userId);

    UserFollow getFollowByIds(Integer userId, Integer followedUserId);

    void insertNewFollow(UserFollow userFollow);

    void deleteFollow(UserFollow deleteUserFollow);
}
