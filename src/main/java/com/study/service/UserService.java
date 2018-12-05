package com.study.service;

import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {

    List<User> listUsers();

    PageInfo<User> pageInfoUsers(int pageNum);
}
