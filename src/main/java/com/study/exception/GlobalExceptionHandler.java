package com.study.exception;

import com.study.common.GlobalEnum;
import com.study.common.ResultData;
import com.study.common.UserEnum;
import com.study.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 统一异常处理
 * @Author jieyu
 * @Date 2018/12/19 14:29
 * @Version 1.0
 **/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultData defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        log.error("请求发生异常，错误信息：{}", e.getMessage());
        e.printStackTrace();
        if (e instanceof UnauthenticatedException) {
            return new ResultData(UserEnum.ERROR_TOKEN.getCode(),UserEnum.ERROR_TOKEN.getMsg());
        } else if (e instanceof UnauthorizedException) {
            return new ResultData(UserEnum.NO_PERMISSION.getCode(),UserEnum.NO_PERMISSION.getMsg());
        } else if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            return new ResultData(GlobalEnum.ERROR_404.getCode(),GlobalEnum.ERROR_404.getMsg());
        } else {
            if (StringUtils.isBlank(e.getMessage())){
                return new ResultData(GlobalEnum.ERROR_500.getCode(),GlobalEnum.ERROR_500.getMsg());
            }
            return new ResultData(GlobalEnum.ERROR_400.getCode(),e.getMessage());
        }
    }

    /**
     * @Author jieyu
     * @Description 自定义异常拦截
     * @Date 2018/12/19 15:24
     * @Param [e]
     * @return com.study.common.ResultData
     **/
    @ResponseBody
    @ExceptionHandler(value = MyException.class)
    public ResultData myExceptionHandler(MyException e){

        return new ResultData(e.getCode(),e.getMsg());
    }
}
