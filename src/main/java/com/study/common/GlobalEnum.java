package com.study.common;

public enum GlobalEnum {
    VALIDATE_MSG(400,"参数验证异常！"),
    PARAM_NOT_NULL(400,"参数不能为空！"),


    USE_MARK("Y","启用"),
    NO_USE_MARK("N","停用"),

    DEL_MARK("1","删除"),
    NO_DEL_MARK("0","未删除")
    ;

    private Integer code;

    private String key;

    private String msg;


    GlobalEnum() {
    }

    GlobalEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    GlobalEnum(String key, String msg) {
        this.key = key;
        this.msg = msg;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
