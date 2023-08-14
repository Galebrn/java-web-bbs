package com.studio2h.javawebbbs;


import com.studio2h.javawebbbs.utils.JwtUtils;
import org.junit.jupiter.api.Test;
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

    @Test
    void test(){
        Map<String,Object> a = new HashMap<>();
        a.put("name","root");
        a.put("password","123456");

        String token = JwtUtils.generateJwt(a);
        System.out.println(token);
        System.out.println(JwtUtils.parseJwt(token));
    }

}
