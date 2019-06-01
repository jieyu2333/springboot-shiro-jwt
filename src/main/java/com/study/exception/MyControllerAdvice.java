package com.study.exception;

import com.study.common.ResultData;
import com.study.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class MyControllerAdvice {

    /**
     * 捕捉shiro的异常
     * @return
     */
    @ExceptionHandler(value = ShiroException.class)
    public ResultData handle401(ShiroException e) {
        ResultData resultData = new ResultData(401,"您没有访问权限！");
        log.error("shiro异常："+e.getMessage());
        return resultData;
    }

    /**
     * 全局异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResultData exceptionHandler(Exception e){
        ResultData result = new ResultData(500,"服务异常！");
        log.error("全局异常信息={}",e.getMessage());
        return result;
    }

    /**
     * 自定义异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = MyException.class)
    public ResultData myExceptionHandler(MyException e){
        int errCode = 500;
        String errMsg = e.getMessage();
        if (null != e.getCode()){
            errCode = e.getCode();
        }
        if (StringUtils.isNotBlank(e.getMsg())){
            errMsg = e.getMsg();
        }
        ResultData result = new ResultData(errCode,"服务异常！原因："+errMsg);
        log.error("自定义异常信息={}",errMsg);
        return result;
    }
}
