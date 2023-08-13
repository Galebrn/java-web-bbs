package com.studio2h.javawebbbs;

import com.studio2h.javawebbbs.mapper.UserMapper;
import com.studio2h.javawebbbs.pojo.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaWebBbsApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println(userMapper.getUserById(1));;
    }

}
