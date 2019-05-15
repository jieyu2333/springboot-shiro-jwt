package com.study.config.jwt;

import com.alibaba.fastjson.JSON;
import com.study.common.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("accessToken");
        if (null != token){
            boolean result = JwtUtils.verifyToken(token);
            if (result){
                return true;
            }
        }
        ResultData resultData = new ResultData(1,"token verify fail");
        response.getWriter().write(JSON.toJSONString(resultData));
        log.error("token校验失败！");
        return false;
    }
}
