package com.study.controller;

import com.study.common.ResultData;
import com.study.common.form.BaseForm;
import com.study.model.base.SysUser;
import com.study.service.UserService;
import com.study.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户相关接口")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登录",notes = "用户登录")
    @RequestMapping(value = "doLogin",method = RequestMethod.POST)
    public void doLogin(String userName,String password){
        if (StringUtils.isNotBlank(userName)&&StringUtils.isNotBlank(password)){
            UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
            SecurityUtils.getSubject().login(token);
        }
    }


    @ApiOperation(value = "查询所有用户信息",notes = "查询所有用户信息")
    @RequestMapping(method = RequestMethod.GET)
    public ResultData<SysUser> listUsers(){
        return userService.listUsers();
    }

    @ApiOperation(value = "分页查询所有用户信息",notes = "分页查询所有用户信息")
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public ResultData<SysUser> pageUsers(BaseForm baseForm){
        return userService.pageUsers(baseForm);
    }

    @ApiOperation(value = "新增或修改用户",notes = "新增或修改用户")
    @RequestMapping(method = RequestMethod.POST)
    public ResultData saveOrUpdateUser(){
        return null;
    }

    @ApiOperation(value = "删除用户信息",notes = "删除用户信息")
    @RequestMapping(method = RequestMethod.DELETE)
    public ResultData updateUser(){
        return null;
    }
}
