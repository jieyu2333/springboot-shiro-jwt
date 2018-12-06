package com.study.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.common.ResultData;
import com.study.common.UserEnum;
import com.study.common.form.BaseForm;
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
    public ResultData<SysUser> listUsers() {
        log.info("用户查询开始");
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUseMarkEqualTo(UserEnum.USE_MARK.getKey()).andDelMarkEqualTo(UserEnum.NO_DEL_MARK.getKey());
        List<SysUser> list = userMapper.selectByExample(sysUserExample);
        ResultData<SysUser> resultData = new ResultData<SysUser>(UserEnum.SUCCESS.getCode(),UserEnum.SUCCESS.getMsg(),list);
        log.info("用户查询成功，resultData={}",JSON.toJSONString(resultData));
        log.info("用户查询结束");
        return resultData;
    }

    @Override
    public ResultData<SysUser> pageUsers(BaseForm baseForm) {
        log.info("分页查询用户开始");
        PageHelper.startPage(baseForm.getPageNum(),baseForm.getPageSize());
        List<SysUser> list = userMapper.selectByExample(new SysUserExample());
        PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(list);
        ResultData<SysUser> resultData = new ResultData<>(UserEnum.SUCCESS.getCode(),UserEnum.SUCCESS.getMsg(),pageInfo);
        log.info("用户查询成功，resultData={}",JSON.toJSONString(resultData));
        log.info("分页查询用户结束");
        return resultData;
    }
}
