package com.study.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.common.GlobalEnum;
import com.study.common.ResultData;
import com.study.common.UserEnum;
import com.study.common.form.BaseForm;
import com.study.dao.base.SysUserMapper;
import com.study.model.base.SysUser;
import com.study.model.base.SysUserExample;
import com.study.service.UserService;
import com.study.utils.StringUtils;
import com.study.utils.UUIDUtils;
import com.study.utils.ValidationUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        sysUserExample.createCriteria().andUseMarkEqualTo(GlobalEnum.USE_MARK.getKey()).andDelMarkEqualTo(GlobalEnum.NO_DEL_MARK.getKey());
        List<SysUser> list = userMapper.selectByExample(sysUserExample);
        ResultData<SysUser> resultData = new ResultData<SysUser>(UserEnum.SELECT_SUCCESS.getCode(),UserEnum.SELECT_SUCCESS.getMsg(),list);
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
        ResultData<SysUser> resultData = new ResultData<>(UserEnum.SELECT_SUCCESS.getCode(),UserEnum.SELECT_SUCCESS.getMsg(),pageInfo);
        log.info("用户查询成功，resultData={}",JSON.toJSONString(resultData));
        log.info("分页查询用户结束");
        return resultData;
    }

    @Override
    public ResultData saveUser(SysUser sysUser) {
        ValidationUtils.validator(sysUser);
        //新增用户
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUserNameEqualTo(sysUser.getUserName()).andDelMarkEqualTo(GlobalEnum.NO_DEL_MARK.getKey());
        List<SysUser> sysUsers = userMapper.selectByExample(sysUserExample);
        if (sysUsers!=null&&sysUsers.size()>0){
            return new ResultData(UserEnum.USER_EXIST.getCode(),UserEnum.USER_EXIST.getMsg());
        }
        String userId = UUIDUtils.createUUID();
        sysUser.setId(userId);
        Object obj = new SimpleHash(UserEnum.ENCRYPTION.getKey(), sysUser.getPassword(), userId, UserEnum.ENCRYPTION_TIMES.getCode());
        sysUser.setPassword(obj.toString());
        sysUser.setCreateTime(new Date());
        sysUser.setCreateBy(userId);
        int result = userMapper.insertSelective(sysUser);
        if (result>0){
            return new ResultData(UserEnum.REGISTER_SUCCESS.getCode(),UserEnum.REGISTER_SUCCESS.getMsg());
        }
        return new ResultData(UserEnum.REGISTER_ERROR.getCode(),UserEnum.REGISTER_ERROR.getMsg());

    }
}
