package com.studio2h.javawebbbs.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.studio2h.javawebbbs.pojo.result.Result;
import com.studio2h.javawebbbs.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Galebrn
 */
@Component
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURL().toString();
        log.info("请求的url: {}", url);

        String jwtToken = request.getHeader("token");

        /*
          判断jwt是否为空
         */
        if (!StringUtils.hasLength(jwtToken)) {
            log.info("token为空");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }

        boolean ifTokenLegal = ifJwtLegal(jwtToken);
        int userId = getIdFromUrl(url);

        /*
          判断jwt是否合法
         */
        if (!ifTokenLegal) {
            log.info("令牌解析失败");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }

        int id = JwtUtils.parseJwt(jwtToken).get("userId", Integer.class);

        /*
          确定用户访问权限
         */
        if (id != userId) {
            log.info("应该访问id为 " + id + " 的资源，而不是访问id为 " + userId + " 的资源");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }

        log.info("令牌校验成功");
        return true;
    }

    /**
     * 判断jwt合法性
     *
     * @param jwtToken jwt令牌
     * @return jwt合法与否
     */
    private boolean ifJwtLegal(String jwtToken) {
        try {
            JwtUtils.parseJwt(jwtToken);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * url中获取id信息
     *
     * @param url url地址
     * @return id信息，若url中不存在id信息则返回0
     */
    private int getIdFromUrl(String url) {
        Pattern pattern = Pattern.compile("/users/([0-9]+)/");
        Matcher matcher = pattern.matcher(url);

        if (matcher.find()) {
            String idStr = matcher.group(1);
            int id = Integer.parseInt(idStr);
            log.info("url: " + url + " 中id为: " + id);
            return id;
        } else {
            log.info("url: " + url + " 中没有id信息");
            return 0;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle ...");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterHandle ...");
    }
}
