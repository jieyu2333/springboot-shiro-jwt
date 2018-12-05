package com.study.model;

import java.util.Date;

public class SysRole {
    private String roleFlow;

    private String roleName;

    private String useMark;

    private String deleteMark;

    private Date createTime;

    private Date updateTime;

    private String userFlow;

    public String getRoleFlow() {
        return roleFlow;
    }

    public void setRoleFlow(String roleFlow) {
        this.roleFlow = roleFlow == null ? null : roleFlow.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
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

    public String getUserFlow() {
        return userFlow;
    }

    public void setUserFlow(String userFlow) {
        this.userFlow = userFlow == null ? null : userFlow.trim();
    }
}