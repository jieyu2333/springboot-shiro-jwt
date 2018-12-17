package com.study.exception;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.study.common.GlobalEnum;
import com.study.common.UserEnum;
import lombok.extern.slf4j.Slf4j;
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
 * @Description 全局异常处理
 * @Author jieyu
 * @Date 2018/12/13 10:40
 * @Version 1.0
 **/
@Slf4j
public class MyExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        log.error("异常开始处理");
        ModelAndView mv = new ModelAndView();
        FastJsonJsonView view = new FastJsonJsonView();
        Map<String, Object> attributes = new HashMap<>();
        if (e instanceof UnauthenticatedException) {
            attributes.put("code", UserEnum.ERROR_TOKEN.getCode());
            attributes.put("msg", UserEnum.ERROR_TOKEN.getMsg());
        } else if (e instanceof UnauthorizedException) {
            attributes.put("code", UserEnum.NO_PERMISSION.getCode());
            attributes.put("msg",UserEnum.NO_PERMISSION.getMsg());
        } else {
            attributes.put("code", GlobalEnum.VALIDATE_MSG.getCode());
            attributes.put("msg", e.getMessage());
        }
        log.error("发生异常：{}",JSON.toJSONString(attributes));
        log.error("异常处理结束");
        view.setAttributesMap(attributes);
        mv.setView(view);
        return mv;
    }
}
