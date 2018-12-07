package com.study.model.ext;

import com.study.model.base.SysUserRoleKey;

/**
 * @ClassName SysUserRoleExt
 * @Description TODO
 * @Author jieyu
 * @Date 2018/12/7 14:50
 * @Version 1.0
 **/
public class SysUserRoleExt extends SysUserRoleKey {

    private String name;//角色名

    private String role;//角色值

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
