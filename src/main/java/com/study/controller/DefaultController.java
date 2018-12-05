package com.study.controller;

import com.study.common.ResultData;
import com.study.model.base.SysUser;
import com.study.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户相关接口")
@RestController
@RequestMapping("/user")
public class DefaultController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "你好，世界",notes = "你好，世界")
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String hello(){
        return "hello world";
    }

    @ApiOperation(value = "查询所有用户信息",notes = "查询所有用户信息")
    @RequestMapping(value = "listUsers",method = RequestMethod.GET)
    public ResultData<SysUser> listUsers(@ApiParam(value = "userId",required = true)@RequestParam(value = "userId",required = true) String userId){

        return new ResultData<SysUser>(200,"查询成功",userService.listUsers());
    }

    @ApiOperation(value = "分页查询所有用户信息",notes = "分页查询所有用户信息")
    @RequestMapping(value = "pageInfoUsers",method = RequestMethod.GET)
    public ResultData<SysUser> pageInfoUsers(@ApiParam(value = "第几页",defaultValue = "1")@RequestParam(value = "pageNum",defaultValue = "1") int pageNum){
        return new ResultData<SysUser>(200,"查询成功",userService.pageInfoUsers(pageNum));
    }
}
