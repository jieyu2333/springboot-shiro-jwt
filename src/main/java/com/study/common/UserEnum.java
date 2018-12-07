package com.study.common;

public enum UserEnum {

    SUCCESS(200,"查询成功！"),

    SUCCESS_LOGIN(200,"登录成功！"),
    ERROR_ACCOUNT(401,"账号不存在！"),
    ERROR_PASSWORD(401,"密码错误！"),
    ERROR_ACCOUNT_PASSWORD(401,"账号或密码错误！"),
    ACCOUNT_DISABLED(401,"账号已被禁止登录！"),

    USE_MARK("Y","启用"),
    NO_USE_MARK("N","停用"),

    DEL_MARK("1","删除"),
    NO_DEL_MARK("0","未删除")


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
