package com.study.form;

import com.study.model.base.SysUser;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName UserForm
 * @Description 用户入参form
 * @Author jieyu
 * @Date 2018/12/18 16:36
 * @Version 1.0
 **/
public class UserForm extends SysUser {

    @NotBlank(message = "角色编号不能为空")
    private String roleId;//角色id


    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
