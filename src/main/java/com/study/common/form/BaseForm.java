package com.study.common.form;

/**
 * @ClassName BaseForm
 * @Description 入参常用form
 * @Author jieyu
 * @Date 2018/12/6 10:26
 * @Version 1.0
 **/
public class BaseForm {
    //当前页
    private int pageNum = 1;
    //每页多少条
    private int pageSize = 10;
    /** 开始时间	 */
    private String startTime;
    /** 结束时间	 */
    private String endTime;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
