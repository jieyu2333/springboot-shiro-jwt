package com.study.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.common.ResultData;
import com.study.sys.entity.User;
import com.study.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author JieYu
 * @since 2019-04-24
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("getUserList")
    public ResultData selectByParam(User user){
        List<User> userList = userService.list(new QueryWrapper<User>());
       return new ResultData(0,"查询用户成功",userList);
    }

}
