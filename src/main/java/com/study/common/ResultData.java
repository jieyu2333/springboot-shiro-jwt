package com.study.common;


import lombok.Data;

import java.util.List;

/**
 * 接口返回统一数据处理
 * @param <T>
 */
@Data
public class ResultData<T> {

    private Integer code;

    private String msg;

    private T data;

    private List<T> record;


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

    public ResultData(Integer code, String msg, List<T> record) {
        this.code = code;
        this.msg = msg;
        this.record = record;
    }
}
