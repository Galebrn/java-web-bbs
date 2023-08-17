package com.studio2h.javawebbbs;


import com.studio2h.javawebbbs.interceptor.LoginCheckInterceptor;
import com.studio2h.javawebbbs.mapper.PostMapper;
import com.studio2h.javawebbbs.pojo.request.PostQueryRequest;
import com.studio2h.javawebbbs.utils.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;


@SpringBootTest
class JavaWebBbsApplicationTests {

    /*@Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println(userMapper.getByNameAndPassword("root","123456"));;
    }*/

    @Autowired
    private PostMapper postMapper;

    @Test
    void test(){
        /*Map<String,Object> a = new HashMap<>();
        a.put("userId",1);
        a.put("userName","root");

        String token = JwtUtils.generateJwt(a);
        System.out.println(token);
        System.out.println(JwtUtils.parseJwt(token));

        System.out.println(JwtUtils.parseJwt(token).get("userId",Integer.class));*/

       /* String url = "http://localhost:9000/users/login";
        LoginCheckInterceptor loginCheckInterceptor = new LoginCheckInterceptor();
        loginCheckInterceptor.getIdFromUrl(url);*/
        PostQueryRequest postQueryRequest = new PostQueryRequest();
        postQueryRequest.setPostId(1);
        System.out.println(postMapper.countByConditions(postQueryRequest));
    }

}
