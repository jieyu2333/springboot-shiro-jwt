package com.study.controller;

import com.study.common.ResultData;
import com.study.common.UserEnum;
import com.study.common.form.BaseForm;
import com.study.model.base.SysUser;
import com.study.service.UserService;
import com.study.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(tags = "用户相关接口")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登录", notes = "用户登录")
    @RequestMapping(value = "doLogin", method = RequestMethod.POST)
    public ResultData doLogin(String userName, String password) {
        try {
            if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
                return new ResultData(UserEnum.ERROR_ACCOUNT_PASSWORD.getCode(), UserEnum.ERROR_ACCOUNT_PASSWORD.getMsg());
            }
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
            subject.login(token);
            return new ResultData(UserEnum.SUCCESS_LOGIN.getCode(), UserEnum.SUCCESS_LOGIN.getMsg(),subject.getPrincipal());
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            return new ResultData(UserEnum.ERROR_ACCOUNT.getCode(), UserEnum.ERROR_ACCOUNT.getMsg());
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            return new ResultData(UserEnum.ERROR_PASSWORD.getCode(), UserEnum.ERROR_PASSWORD.getMsg());
        } catch (LockedAccountException e) {
            e.printStackTrace();
            return new ResultData(UserEnum.ACCOUNT_DISABLED.getCode(), UserEnum.ACCOUNT_DISABLED.getMsg());
        }

    }


    @ApiOperation(value = "查询所有用户信息", notes = "查询所有用户信息")
    @RequestMapping(method = RequestMethod.GET)
    public ResultData<SysUser> listUsers() {
        return userService.listUsers();
    }

    @ApiOperation(value = "分页查询所有用户信息", notes = "分页查询所有用户信息")
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public ResultData<SysUser> pageUsers(BaseForm baseForm) {
        return userService.pageUsers(baseForm);
    }


    @ApiOperation(value = "新增或修改用户", notes = "新增或修改用户")
    @RequiresRoles(value = {"superadmin","admin"})
    @RequestMapping(method = RequestMethod.POST)
    public ResultData saveOrUpdateUser() {
        return new ResultData(200,"牛逼啊！兄弟你是最高管理员还是管理员啊？？？");
    }

    @ApiOperation(value = "删除用户信息", notes = "删除用户信息")
    @RequestMapping(method = RequestMethod.DELETE)
    public ResultData updateUser() {
        return null;
    }
}
