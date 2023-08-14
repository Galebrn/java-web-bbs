package com.studio2h.javawebbbs.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.studio2h.javawebbbs.pojo.result.Result;
import com.studio2h.javawebbbs.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Galebrn
 */
@Component
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {

        String url = req.getRequestURL().toString();
        log.info("请求的url: {}",url);

        if(url.contains("login")) {
            return true;
        }

        String jwtToken = req.getHeader("token");

        if(!StringUtils.hasLength(jwtToken)){
            log.info("token为空");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return false;
        }

        try {
            JwtUtil.parseJwt(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("令牌解析失败");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return false;
        }

        log.info("令牌校验成功");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle ...");
    }

    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object handler, Exception ex) throws Exception {
        System.out.println("afterHandle ...");
    }
}
