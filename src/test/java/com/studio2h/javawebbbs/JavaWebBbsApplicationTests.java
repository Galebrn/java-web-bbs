package com.studio2h.javawebbbs;


import com.studio2h.javawebbbs.interceptor.LoginCheckInterceptor;
import com.studio2h.javawebbbs.mapper.PostMapper;
import com.studio2h.javawebbbs.mapper.UserMapper;
import com.studio2h.javawebbbs.pojo.request.PostQueryRequest;
import com.studio2h.javawebbbs.service.UserService;
import com.studio2h.javawebbbs.utils.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootTest
class JavaWebBbsApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        System.out.println(userService.listByIds(a));;
    }



}
