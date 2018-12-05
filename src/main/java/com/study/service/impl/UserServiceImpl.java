package com.study.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listUsers() {
        List<User> list = userMapper.selectByExample(new UserExample());
        log.info("list={}",JSON.toJSONString(list));
        return list;
    }

    @Override
    public PageInfo<User> pageInfoUsers(int pageNum) {
        if (pageNum==0)
            pageNum = 1;

        PageHelper.startPage(pageNum,1);
        List<User> list = userMapper.selectByExample(new UserExample());
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        log.info("pageInfo={}",JSON.toJSONString(pageInfo));
        return pageInfo;
    }
}
