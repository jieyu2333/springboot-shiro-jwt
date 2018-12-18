package com.study.service;

import com.github.pagehelper.PageInfo;
import com.study.common.ResultData;
import com.study.common.form.BaseForm;
import com.study.form.UserForm;
import com.study.model.base.SysUser;

import java.util.List;

public interface UserService {

    /**
     * @Author jieyu
     * @Description 查询所有用户信息
     * @Date 2018/12/18 13:55
     * @Param []
     * @return com.study.common.ResultData<com.study.model.base.SysUser>
     **/
    ResultData<SysUser> listUsers();

    /**
     * @Author jieyu
     * @Description 分页查询用户信息
     * @Date 2018/12/18 13:57
     * @Param [baseForm]
     * @return com.study.common.ResultData<com.study.model.base.SysUser>
     **/
    ResultData<SysUser> pageUsers(BaseForm baseForm);

    /**
     * @Author jieyu
     * @Description 保存用户信息
     * @Date 2018/12/18 13:58
     * @Param [sysUser]
     * @return com.study.common.ResultData
     **/
    ResultData saveUser(UserForm userForm);

    /**
     * @Author jieyu
     * @Description 更新登录时间
     * @Date 2018/12/18 13:58
     * @Param [userId]
     * @return com.study.common.ResultData
     **/
    ResultData updateLoginTime(String userId);
}
