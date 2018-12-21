package com.study.common;

public enum GlobalEnum {

    SELECT_SUCCESS(200,"查询成功！"),
    SELECT_ERROR(400,"查询失败！"),
    SELECT_ERROR_NO_DATA(400,"查询失败,无数据！"),

    UPDATE_SUCCESS(200,"更新成功！"),
    UPDATE_ERROR(400,"更新失败！"),

    DELETE_SUCCESS(200,"删除成功！"),
    DELETE_ERROR(400,"删除失败！"),

    VALIDATE_MSG(400,"参数验证异常！"),
    PARAM_NOT_NULL(400,"参数不能为空！"),


    USE_MARK("Y","启用"),
    NO_USE_MARK("N","停用"),

    DEL_MARK("1","删除"),
    NO_DEL_MARK("0","未删除"),

    ERROR_400(400,"错误"),
    ERROR_404(404,"请求的网页不存在"),
    ERROR_500(500,"服务器内部错误"),

    COUNTRY_ID(0,"中国")
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
