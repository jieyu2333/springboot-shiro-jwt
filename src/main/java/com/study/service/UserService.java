package com.study.service;

import com.github.pagehelper.PageInfo;
import com.study.model.base.SysUser;

import java.util.List;

public interface UserService {

    List<SysUser> listUsers();

    PageInfo<SysUser> pageInfoUsers(int pageNum);
}
