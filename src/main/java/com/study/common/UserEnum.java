package com.study.common;

public enum UserEnum {

    SELECT_SUCCESS(200,"查询成功！"),
    REGISTER_SUCCESS(200,"注册成功！"),
    REGISTER_ERROR(400,"注册失败！"),
    USER_EXIST(400,"用户名已注册！"),

    ENCRYPTION("MD5","加密方式"),
    ENCRYPTION_TIMES(1024,"加密次数"),


    SUCCESS_LOGIN(200,"登录成功！"),
    ERROR_ACCOUNT(401,"账号不存在！"),
    ERROR_PASSWORD(401,"密码错误！"),
    ERROR_ACCOUNT_PASSWORD(401,"账号或密码错误！"),
    ACCOUNT_DISABLED(401,"账号已被禁止登录！"),
    ERROR_TOKEN(401,"token错误或失效！"),
    TO_LOGIN(401,"请先登录！"),
    NO_PERMISSION(403,"无权限！")




    ;

    private Integer code;
    private String key;
    private String msg;


    UserEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    UserEnum(String key, String msg) {
        this.key = key;
        this.msg = msg;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
}
