package com.study.exception;

import com.study.common.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class MyControllerAdvice {

    /**
     * 全局异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResultData exceptionHandler(Exception e){
        ResultData result = new ResultData(1,e.getMessage());
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
        ResultData result = new ResultData(1,e.getMessage());
        log.error("自定义异常信息={}",e.getMessage());
        return result;
    }
}
