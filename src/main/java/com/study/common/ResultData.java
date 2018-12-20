package com.study.common;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 接口返回统一数据处理
 * @param <T>
 */
public class ResultData<T> {

    private Integer code;

    private String msg;

    private T token;

    private T data;

    private List<T> record;

    private PageInfo<T> pageInfo;

    public ResultData() {
    }


    public ResultData(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultData(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultData(Integer code, String msg, T data,T token) {
        this.code = code;
        this.msg = msg;
        this.token = token;
        this.data = data;
    }

    public ResultData(Integer code, String msg, List<T> record) {
        this.code = code;
        this.msg = msg;
        this.record = record;
    }

    public ResultData(Integer code, String msg, PageInfo<T> pageInfo) {
        this.code = code;
        this.msg = msg;
        this.pageInfo = pageInfo;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<T> getRecord() {
        return record;
    }

    public void setRecord(List<T> record) {
        this.record = record;
    }

    public PageInfo<T> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<T> pageInfo) {
        this.pageInfo = pageInfo;
    }

    public T getToken() {
        return token;
    }

    public void setToken(T token) {
        this.token = token;
    }
}
