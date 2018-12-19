package com.study.exception;

/**
 * @ClassName MyException
 * @Description 自定义异常
 * @Author jieyu
 * @Date 2018/12/19 15:16
 * @Version 1.0
 **/
public class MyException extends RuntimeException{

    private Integer code; //异常状态码

    private String msg; //异常信息

    private String method;  //发生的方法，位置等

    public MyException() {
    }

    public MyException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public MyException(Integer code, String msg, String method) {
        this.code = code;
        this.msg = msg;
        this.method = method;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
