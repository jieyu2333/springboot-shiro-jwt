package com.study.controller;

import com.study.common.ResultData;
import com.study.common.UserEnum;
import com.study.common.form.BaseForm;
import com.study.form.UserForm;
import com.study.model.base.SysUser;
import com.study.service.UserService;
import com.study.utils.ValidationUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(tags = "用户相关接口")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequiresRoles(value = {"superadmin","admin"},logical = Logical.OR)
    @ApiOperation(value = "查询所有用户信息", notes = "查询所有用户信息")
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ResultData<SysUser> listUsers() {
        return userService.listUsers();
    }

    @ApiOperation(value = "分页查询所有用户信息", notes = "分页查询所有用户信息")
    @RequestMapping(value = "page", method = RequestMethod.GET)
    @RequiresRoles(value = {"superadmin","admin"},logical = Logical.OR)
    public ResultData<SysUser> pageUsers(BaseForm baseForm) {
        return userService.pageUsers(baseForm);
    }


    @ApiOperation(value = "新增用户", notes = "新增用户")
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public ResultData saveUser(@RequestBody UserForm userForm) {
        userForm.setRoleId(UserEnum.USER.getKey());//注册时默认设置为普通用户
        return userService.saveUser(userForm);
    }

    @ApiOperation(value = "删除用户信息", notes = "删除用户信息")
    @RequestMapping(value = "delete/{userId}",method = RequestMethod.POST)
    @RequiresRoles(value = {"superadmin","admin"},logical = Logical.OR)
    @RequiresPermissions("sys:user:edit")
    public ResultData deleteUserById(@PathVariable("userId") String userId) {
        return userService.deleteUserById(userId);
    }
}
