package com.studio2h.javawebbbs.controller;

import com.studio2h.javawebbbs.pojo.request.UserLoginRequest;
import com.studio2h.javawebbbs.pojo.result.Result;
import com.studio2h.javawebbbs.pojo.user.User;
import com.studio2h.javawebbbs.pojo.user.UserFollow;
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

    @PostMapping("/login")
    public Result userLogin(@RequestBody UserLoginRequest userLoginRequest){
        log.info("用户登录: {}",userLoginRequest);

        User user = userService.userLogin(userLoginRequest);

        if (user!=null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("userId",user.getUserId());
            claims.put("userName",user.getUserName());

            String jwtToken = JwtUtils.generateJwt(claims);

            return Result.success(jwtToken);
        } else {
            return Result.error("用户名或密码错误");
        }
    }

    @GetMapping("/{userId}/follow")
    public Result listFollowers(@PathVariable Integer userId) {
        log.info("用户关注列表查询: {}",userId);

        List<UserFollow> userFollowList = userService.listFollowers(userId);

        return Result.success(userFollowList);
    }
}
