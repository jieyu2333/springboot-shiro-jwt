package com.study.service;

import com.github.pagehelper.PageInfo;
import com.study.common.ResultData;
import com.study.common.form.BaseForm;
import com.study.model.base.SysUser;

import java.util.List;

public interface UserService {

    ResultData<SysUser> listUsers();

    ResultData<SysUser> pageUsers(BaseForm baseForm);
}
