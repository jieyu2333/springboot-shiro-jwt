package com.study.exception;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.study.common.UserEnum;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MyExceptionHandler
 * @Description shiro全局异常处理
 * @Author jieyu
 * @Date 2018/12/13 10:40
 * @Version 1.0
 **/
public class MyExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv = new ModelAndView();
        FastJsonJsonView view = new FastJsonJsonView();
        Map<String, Object> attributes = new HashMap<>();
        if (e instanceof UnauthenticatedException) {
            attributes.put("code", "1000001");
            attributes.put("msg", "token错误");
        } else if (e instanceof UnauthorizedException) {
            attributes.put("code", UserEnum.NO_PERMISSION.getCode());
            attributes.put("msg",UserEnum.NO_PERMISSION.getMsg());
        } else {
            attributes.put("code", "1000003");
            attributes.put("msg", e.getMessage());
        }

        view.setAttributesMap(attributes);
        mv.setView(view);
        return mv;
    }
}
