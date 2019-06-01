package com.study.sys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.common.ResultData;
import com.study.sys.entity.User;
import com.study.sys.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
@Slf4j
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("getUserList")
    @RequiresRoles(logical = Logical.OR,value = {"super_admin","admin"})
    public ResultData pageUser(@RequestBody(required = false) Page page,@RequestBody(required = false) User user){
        IPage<User> userList = userService.selectUserPage(page,user);
        return new ResultData(0,"查询用户成功！",userList);
    }

    @GetMapping("role")
    @RequiresRoles("super_admin")
    public ResultData test01(){
        return new ResultData(0,"您拥有super_admin角色");
    }
    @GetMapping("permission")
    @RequiresPermissions("sys:user:view")
    public ResultData test02(){
        return new ResultData(0,"您拥有sys:user:view权限");
    }


}
