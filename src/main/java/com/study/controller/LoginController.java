package com.study.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.study.common.ResultData;
import com.study.common.UserEnum;
import com.study.model.base.SysUser;
import com.study.service.UserService;
import com.study.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName LoginController
 * @Description 登录注销等方法
 * @Author jieyu
 * @Date 2018/12/12 14:53
 * @Version 1.0
 **/
@Api(tags = "用户登录注销等相关接口")
@RestController
@RequestMapping("/login")
public class LoginController {

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
            SysUser sysUser = (SysUser) subject.getPrincipal();
            //更新最后登陆时间
            userService.updateLoginTime(sysUser.getId());
            sysUser.setPassword(null);
            return new ResultData(UserEnum.SUCCESS_LOGIN.getCode(), UserEnum.SUCCESS_LOGIN.getMsg(),sysUser,subject.getSession().getId());
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

    @ApiOperation(value = "注销登录", notes = "注销登录")
    @RequestMapping(value = "logout",method = RequestMethod.POST)
    public void logout(){
        SecurityUtils.getSubject().logout();
    }
}
