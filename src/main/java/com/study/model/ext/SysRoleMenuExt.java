package com.study.model.ext;

import com.study.model.base.SysRoleMenuKey;

/**
 * @ClassName SysRoleMenuExt
 * @Description TODO
 * @Author jieyu
 * @Date 2018/12/7 15:25
 * @Version 1.0
 **/
public class SysRoleMenuExt extends SysRoleMenuKey {

    private String name;//权限名

    private String permission;//权限值

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
