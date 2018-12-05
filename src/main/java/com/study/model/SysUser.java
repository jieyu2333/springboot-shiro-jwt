package com.study.model;

import java.util.Date;

public class SysUser {
    private String userFlow;

    private String userName;

    private String password;

    private String name;

    private String idNum;

    private Integer age;

    private Integer sex;

    private String address;

    private String useMark;

    private String deleteMark;

    private Date createTime;

    private Date updateTime;

    public String getUserFlow() {
        return userFlow;
    }

    public void setUserFlow(String userFlow) {
        this.userFlow = userFlow == null ? null : userFlow.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum == null ? null : idNum.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getUseMark() {
        return useMark;
    }

    public void setUseMark(String useMark) {
        this.useMark = useMark == null ? null : useMark.trim();
    }

    public String getDeleteMark() {
        return deleteMark;
    }

    public void setDeleteMark(String deleteMark) {
        this.deleteMark = deleteMark == null ? null : deleteMark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}