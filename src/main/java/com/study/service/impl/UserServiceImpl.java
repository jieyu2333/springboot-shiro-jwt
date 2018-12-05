package com.study.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.dao.base.SysUserMapper;
import com.study.model.base.SysUser;
import com.study.model.base.SysUserExample;
import com.study.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public List<SysUser> listUsers() {
        List<SysUser> list = userMapper.selectByExample(new SysUserExample());
        log.info("list={}",JSON.toJSONString(list));
        return list;
    }

    @Override
    public PageInfo<SysUser> pageInfoUsers(int pageNum) {
        if (pageNum==0)
            pageNum = 1;

        PageHelper.startPage(pageNum,1);
        List<SysUser> list = userMapper.selectByExample(new SysUserExample());
        PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(list);
        log.info("pageInfo={}",JSON.toJSONString(pageInfo));
        return pageInfo;
    }
}
