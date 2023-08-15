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
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

    @PutMapping("/{userId}/editor")
    public Result updateUserInfo(@PathVariable Integer userId, @RequestBody User newUser) {

        String regexOfPhoneNum = "^\\d{11}$";
        String regexOfEmail = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        /*
          判断用户名是否存在
         */
        String userName = newUser.getUserName();
        if ((userService.getUserByName(userName) != null)
                && (!userService.getUserById(userId).getUserName().equals(userName))) {
            return Result.error("该用户名: " + userName + " 已被使用");
        }

        String email = newUser.getUserEmail();
        String phoneNum = newUser.getUserPhoneNumber();

        /*
          判断电话号码格式
         */
        if (phoneNum!=null) {
            Pattern pattern = Pattern.compile(regexOfPhoneNum);
            Matcher matcher = pattern.matcher(phoneNum);
            if (!matcher.matches()) {
                return Result.error("该电话号码格式不合法");
            }
            if (userService.getUserByPhoneNum(phoneNum)!=null) {
                return Result.error("该电话号码: " + phoneNum + " 已被使用");
            }
        }

        /*
          判断邮箱格式
         */
        if (email!=null) {
            Pattern pattern = Pattern.compile(regexOfEmail);
            Matcher matcher = pattern.matcher(email);
            if (!matcher.matches()) {
                return Result.error("该邮箱格式不合法");
            }
            if (userService.getUserByEmail(email)!=null) {
                return Result.error("该电子邮箱: " + email + " 已被使用");
            }
        }

        userService.updateUser(newUser);
        return Result.success();
    }

    @PutMapping("/{userId}/follow/editor")
    public Result updateUserFollow(@PathVariable Integer userId) {

        return Result.success();
    }

    @PutMapping("/{userId}/private/editor")
    public Result updateUserPrivate(@PathVariable Integer userId) {

        return Result.success();
    }
}
