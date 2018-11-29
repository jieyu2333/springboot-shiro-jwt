package com.study.service;

import com.github.pagehelper.PageInfo;
import com.study.model.User;

import java.util.List;

public interface UserService {

    List<User> listUsers();

    PageInfo<User> pageInfoUsers(int pageNum);
}
