package com.studio2h.javawebbbs.service;

import com.studio2h.javawebbbs.pojo.request.UserLoginRequest;
import com.studio2h.javawebbbs.pojo.request.UserRegisterRequest;
import com.studio2h.javawebbbs.pojo.user.User;
import com.studio2h.javawebbbs.pojo.user.UserFollow;

import java.util.List;

/**
 * @author Galebrn
 */


public interface UserService {

    User userLogin(UserLoginRequest userLoginRequest);

    List<UserFollow> listFollowers(Integer userId);

    User getUserById(Integer userId);

    User getUserByName(String name);

    void registerNewUser(UserRegisterRequest userRegisterRequest);

    User getUserByPhoneNum(String phoneNum);

    User getUserByEmail(String email);

    void updateUser(User newUser);
}
