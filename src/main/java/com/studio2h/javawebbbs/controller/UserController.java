package com.studio2h.javawebbbs.controller;

import com.studio2h.javawebbbs.pojo.post.PostPrivate;
import com.studio2h.javawebbbs.pojo.request.UserLoginRequest;
import com.studio2h.javawebbbs.pojo.request.UserRegisterRequest;
import com.studio2h.javawebbbs.pojo.result.Result;
import com.studio2h.javawebbbs.pojo.user.User;
import com.studio2h.javawebbbs.pojo.user.UserFollow;
import com.studio2h.javawebbbs.service.PostService;
import com.studio2h.javawebbbs.service.UserService;
import com.studio2h.javawebbbs.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Galebrn
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    @PostMapping("/login")
    public Result userLogin(@RequestBody UserLoginRequest userLoginRequest) {
        log.info("用户登录  loginRequest: {}", userLoginRequest);

        User user = userService.userLogin(userLoginRequest);

        if (user != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("userId", user.getUserId());
            claims.put("userName", user.getUserName());

            String jwtToken = JwtUtils.generateJwt(claims);

            return Result.success(jwtToken);
        } else {
            return Result.error("用户名或密码错误");
        }
    }

    @PutMapping("/register")
    public Result userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
        log.info("新增用户  userInfo: {}", userRegisterRequest);

        if (userService.getUserByName(userRegisterRequest.getUserName()) != null) {
            return Result.error("该用户名: " + userRegisterRequest.getUserName() + " 已被使用");
        } else if (!userRegisterRequest.getUserPassword().equals(userRegisterRequest.getRepeatPassword())) {
            return Result.error("两次密码不同");
        } else {
            userService.registerNewUser(userRegisterRequest);
            return Result.success();
        }
    }

    @GetMapping("/{userId}/follow")
    public Result listFollowers(@PathVariable Integer userId) {
        log.info("用户关注列表查询  userId: {}", userId);

        List<UserFollow> userFollowList = userService.listFollowers(userId);

        return Result.success(userFollowList);
    }

    @GetMapping("/{userId}/private")
    public Result listPrivates(@PathVariable Integer userId) {
        log.info("用户收藏帖子列表查询  userId: {}", userId);

        List<PostPrivate> postPrivateList = postService.listPrivates(userId);

        return Result.success(postPrivateList);
    }

    @GetMapping("/{userId}")
    public Result getUserInfo(@PathVariable Integer userId) {
        log.info("获取用户信息  userId: {}", userId);

        User user = userService.getUserById(userId);

        return Result.success(user);
    }
}
