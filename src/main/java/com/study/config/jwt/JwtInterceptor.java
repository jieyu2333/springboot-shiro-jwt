package com.study.config.jwt;

import com.study.exception.MyException;
import com.study.sys.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("utf-8");
        //验证路径是否存在
        if (!(handler instanceof HandlerMethod)){
           throw new MyException(1,"path doesn't exist");
        }
        String token = request.getHeader("accessToken");
        if (null == token){
            throw new MyException(1,"token is null");
        }
        //验证token
        JwtUtils.verifyToken(token);

        return true;
    }
}
