package com.studio2h.javawebbbs.controller;

import com.studio2h.javawebbbs.constant.StatusConstant;
import com.studio2h.javawebbbs.pojo.post.Post;
import com.studio2h.javawebbbs.pojo.request.UserLoginRequest;
import com.studio2h.javawebbbs.pojo.request.UserQueryRequest;
import com.studio2h.javawebbbs.pojo.request.UserRegisterRequest;
import com.studio2h.javawebbbs.pojo.response.UserQueryResponse;
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

    public boolean ifUserExist(Integer userId) {
        User user = userService.getUserById(userId);
        return user != null && !user.getUserStatus().equals(StatusConstant.DISABLE);
    }

    public boolean ifUserBaned(Integer userId) {
        User user = userService.getUserById(userId);
        return user != null && user.getUserStatus().equals(StatusConstant.BANED);
    }

    @PostMapping("/login")
    public Result userLogin(@RequestBody UserLoginRequest userLoginRequest) {
        log.info("用户登录  loginRequest: {}", userLoginRequest);

        UserQueryRequest userQueryRequest = new UserQueryRequest(userLoginRequest);
        User user = userService.getByConditions(userQueryRequest);

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

        String userName = userRegisterRequest.getUserName();

        if (userService.getUserByName(userName) != null) {
            return Result.error("该用户名: " + userName + " 已被使用");
        } else if (!userRegisterRequest.getUserPassword().equals(userRegisterRequest.getRepeatPassword())) {
            return Result.error("两次密码不同");
        } else {
            userService.registerNewUser(userRegisterRequest);
            return Result.success();
        }
    }

    @GetMapping("/{userId}/followers")
    public Result listFollowers(@PathVariable Integer userId) {
        if (!ifUserExist(userId)) {
            return Result.error("id为: " + userId + " 的用户不存在");
        } else if (ifUserBaned(userId)) {
            return Result.error("id为: " + userId + " 的用户封禁中");
        }

        log.info("用户关注列表查询  userId: {}", userId);

        List<Integer> followersIds = userService.listFollowers(userId);
        List<UserQueryResponse> userQueryResponses = userService.listByIds(followersIds);

        if (!userQueryResponses.isEmpty()) {
            return Result.success(userQueryResponses);
        } else {
            return Result.error("未查询到用户id为: " + userId + " 的关注列表");
        }
    }

    @GetMapping("/{userId}/fans")
    public Result listFans(@PathVariable Integer userId) {
        if (!ifUserExist(userId)) {
            return Result.error("id为: " + userId + " 的用户不存在");
        } else if (ifUserBaned(userId)) {
            return Result.error("id为: " + userId + " 的用户封禁中");
        }

        log.info("用户粉丝列表查询  userId: {}", userId);

        List<Integer> fansIds = userService.listFans(userId);
        List<UserQueryResponse> userQueryResponses = userService.listByIds(fansIds);

        if (!userQueryResponses.isEmpty()) {
            return Result.success(userQueryResponses);
        } else {
            return Result.error("未查询到用户id为: " + userId + " 的粉丝列表");
        }
    }

    @GetMapping("/{userId}/private")
    public Result listPrivates(@PathVariable Integer userId) {
        if (!ifUserExist(userId)) {
            return Result.error("id为: " + userId + " 的用户不存在");
        } else if (ifUserBaned(userId)) {
            return Result.error("id为: " + userId + " 的用户封禁中");
        }

        log.info("用户收藏帖子列表查询  userId: {}", userId);

        List<Integer> privateIds = postService.listPrivates(userId);
        List<Post> posts = postService.listByIds(privateIds);

        System.out.println("posts: " + posts);

        if (!posts.isEmpty()) {
            return Result.success(posts);
        } else {
            return Result.error("未查询到用户id为: " + userId + " 的收藏列表");
        }
    }

    @GetMapping("/{userId}")
    public Result getUserInfo(@PathVariable Integer userId) {
        if (!ifUserExist(userId)) {
            return Result.error("id为: " + userId + " 的用户不存在");
        } else if (ifUserBaned(userId)) {
            return Result.error("id为: " + userId + " 的用户封禁中");
        }

        log.info("获取用户信息  userId: {}", userId);

        User user = userService.getUserById(userId);
        UserQueryResponse userQueryResponse = new UserQueryResponse(user);

        return Result.success(userQueryResponse);
    }

    @GetMapping("/{userId}/{userName}")
    public Result getUserInfo(@PathVariable Integer userId, @PathVariable String userName) {
        if (!ifUserExist(userId)) {
            return Result.error("id为: " + userId + " 的用户不存在");
        }

        User user = userService.getUserById(userId);

        if (!user.getUserName().equals(userName)) {
            return Result.error("url地址的id: " + userId + " 和name: " + userName + " 不匹配");
        }

        log.info("获取用户信息  userId: {}", userId);

        return Result.success(user);
    }

    @PutMapping("/{userId}/editor")
    public Result updateUserInfo(@PathVariable Integer userId, @RequestBody User newUser) {
        if (!ifUserExist(userId)) {
            return Result.error("id为: " + userId + " 的用户不存在");
        } else if (ifUserBaned(userId)) {
            return Result.error("id为: " + userId + " 的用户封禁中，不提供信息修改功能");
        }

        String regexOfPhoneNum = "^\\d{11}$";
        String regexOfEmail = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        /*
          判断用户名是否存在
         */
        String userName = newUser.getUserName();
        System.out.println(userName);
        if ((userService.getUserByName(userName) != null)
                && (!userService.getUserById(userId).getUserName().equals(userName))) {
            return Result.error("该用户名: " + userName + " 已被使用");
        }

        String email = newUser.getUserEmail();
        String phoneNum = newUser.getUserPhoneNumber();

        /*
          判断电话号码格式
         */
        if (phoneNum != null) {
            Pattern pattern = Pattern.compile(regexOfPhoneNum);
            Matcher matcher = pattern.matcher(phoneNum);
            if (!matcher.matches()) {
                return Result.error("该电话号码格式不合法");
            }
            if (userService.getUserByPhoneNum(phoneNum) != null) {
                return Result.error("该电话号码: " + phoneNum + " 已被使用");
            }
        }

        /*
          判断邮箱格式
         */
        if (email != null) {
            Pattern pattern = Pattern.compile(regexOfEmail);
            Matcher matcher = pattern.matcher(email);
            if (!matcher.matches()) {
                return Result.error("该邮箱格式不合法");
            }
            if (userService.getUserByEmail(email) != null) {
                return Result.error("该电子邮箱: " + email + " 已被使用");
            }
        }

        newUser.setUserId(userId);
        userService.updateUser(newUser);
        return Result.success();
    }

    @PostMapping("/{userId}/follow/editor")
    public Result insertNewFollow(@PathVariable Integer userId, @RequestBody User followedUser) {
        //noinspection DuplicatedCode
        if (!ifUserExist(userId)) {
            return Result.error("id为: " + userId + " 的用户不存在");
        } else if (ifUserBaned(userId)) {
            return Result.error("id为: " + userId + " 的用户封禁中，不提供信息修改功能");
        }

        Integer followedUserId = followedUser.getUserId();

        UserQueryRequest userQueryRequest = new UserQueryRequest();
        userQueryRequest.setUserId(followedUserId);
        if (!ifUserExist(followedUserId)) {
            return Result.error("id为: " + followedUserId + " 的用户不存在");
        } else if (ifUserBaned(followedUser.getUserId())) {
            return Result.error("id为: " + followedUserId + " 的用户封禁中，无法关注");
        }

        if (userId.equals(followedUserId)) {
            return Result.error("无法关注自己");
        }

        UserFollow userFollow = userService.getFollowByIds(userId, followedUserId);
        if (userFollow != null) {
            return Result.error("无法重复关注id: " + followedUserId + " 的用户");
        }

        UserFollow newUserFollow = new UserFollow();
        newUserFollow.setUserId(userId);
        newUserFollow.setFollowedUserId(followedUserId);
        userService.insertNewFollow(newUserFollow);

        return Result.success();
    }

    @PostMapping("/{userId}/private/editor")
    public Result insertNewPrivate(@PathVariable Integer userId, @RequestBody Post post) {
        if (!ifUserExist(userId)) {
            return Result.error("id为: " + userId + " 的用户不存在");
        } else if (ifUserBaned(userId)) {
            return Result.error("id为: " + userId + " 的用户封禁中，不提供信息修改功能");
        }

        return Result.success();
    }

    @DeleteMapping("/{userId}/follow/editor")
    public Result deleteFollow(@PathVariable Integer userId, @RequestBody User followedUser) {
        if (!ifUserExist(userId)) {
            return Result.error("id为: " + userId + " 的用户不存在");
        } else if (ifUserBaned(userId)) {
            return Result.error("id为: " + userId + " 的用户封禁中，不提供信息修改功能");
        }

        Integer followedUserId = followedUser.getUserId();

        UserQueryRequest userQueryRequest = new UserQueryRequest();
        userQueryRequest.setUserId(followedUserId);

        if (userId.equals(followedUserId)) {
            return Result.error("无法对自己取消关注");
        }

        UserFollow userFollow = userService.getFollowByIds(userId,followedUserId);
        if (userFollow == null) {
            return Result.error("id: "+followedUserId+" 的用户不在关注列表中，无法取消关注");
        }

        UserFollow deleteUserFollow = new UserFollow();
        deleteUserFollow.setUserId(userId);
        deleteUserFollow.setFollowedUserId(followedUserId);
        userService.deleteFollow(deleteUserFollow);

        return Result.success();
    }

    @DeleteMapping("/{userId}/private/editor")
    public Result deletePrivate(@PathVariable Integer userId, @RequestBody Post post) {
        if (!ifUserExist(userId)) {
            return Result.error("id为: " + userId + " 的用户不存在");
        } else if (ifUserBaned(userId)) {
            return Result.error("id为: " + userId + " 的用户封禁中，不提供信息修改功能");
        }

        return Result.success();
    }
}
