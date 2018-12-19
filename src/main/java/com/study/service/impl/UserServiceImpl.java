package com.study.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.common.GlobalEnum;
import com.study.common.ResultData;
import com.study.common.UserEnum;
import com.study.common.form.BaseForm;
import com.study.dao.base.SysRoleMapper;
import com.study.dao.base.SysUserMapper;
import com.study.dao.base.SysUserRoleMapper;
import com.study.dao.ext.SysUserRoleExtMapper;
import com.study.exception.MyException;
import com.study.form.UserForm;
import com.study.model.base.SysUser;
import com.study.model.base.SysUserExample;
import com.study.model.base.SysUserRoleKey;
import com.study.service.UserService;
import com.study.utils.StringUtils;
import com.study.utils.UUIDUtils;
import com.study.utils.ValidationUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper userMapper;


    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;



    @Override
    public ResultData<SysUser> listUsers() {
        log.info("用户查询开始");
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUseMarkEqualTo(GlobalEnum.USE_MARK.getKey()).andDelMarkEqualTo(GlobalEnum.NO_DEL_MARK.getKey());
        List<SysUser> list = userMapper.selectByExample(sysUserExample);
        ResultData<SysUser> resultData = new ResultData<>(UserEnum.SELECT_SUCCESS.getCode(),UserEnum.SELECT_SUCCESS.getMsg(),list);
        log.info("用户查询结束，出参={}",JSON.toJSONString(resultData));
        return resultData;
    }

    @Override
    public ResultData<SysUser> pageUsers(BaseForm baseForm) {
        log.info("分页查询用户开始，入参={}",JSON.toJSONString(baseForm));
        PageHelper.startPage(baseForm.getPageNum(),baseForm.getPageSize());
        List<SysUser> list = userMapper.selectByExample(new SysUserExample());
        PageInfo<SysUser> pageInfo = new PageInfo<>(list);
        ResultData<SysUser> resultData = new ResultData<>(UserEnum.SELECT_SUCCESS.getCode(),UserEnum.SELECT_SUCCESS.getMsg(),pageInfo);
        log.info("分页查询用户结束，出参={}",JSON.toJSONString(resultData));
        return resultData;
    }

    @Override
    @Transactional
    public ResultData saveUser(UserForm userForm) {
        log.info("注册用户方法开始，入参={}",JSON.toJSONString(userForm));
        ValidationUtils.validator(userForm);
        ResultData resultData = null;
        //新增用户
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUserNameEqualTo(userForm.getUserName()).andDelMarkEqualTo(GlobalEnum.NO_DEL_MARK.getKey());
        List<SysUser> sysUsers = userMapper.selectByExample(sysUserExample);
        if (sysUsers!=null&&sysUsers.size()>0){
            resultData = new ResultData(UserEnum.USER_EXIST.getCode(),UserEnum.USER_EXIST.getMsg());
            log.info("注册用户方法结束，出参={}",JSON.toJSONString(resultData));
            return resultData;
        }
        SysUser sysUser = userForm;
        String userId = UUIDUtils.createUUID();
        sysUser.setId(userId);
        Object obj = new SimpleHash(UserEnum.ENCRYPTION.getKey(), sysUser.getPassword(), userId, UserEnum.ENCRYPTION_TIMES.getCode());
        sysUser.setPassword(obj.toString());
        sysUser.setCreateTime(new Date());
        sysUser.setCreateBy(userId);
        int result = userMapper.insertSelective(sysUser);
        if (result>0){
            //验证传入角色并把用户角色对应插入数据库
            String roleId = userForm.getRoleId().trim();
            if (!roleId.equals(UserEnum.SUPER_ADMIN.getKey())&&!roleId.equals(UserEnum.ADMIN.getKey())&&!roleId.equals(UserEnum.USER.getKey())){
                throw new MyException(400,"角色不存在！");
            }

            SysUserRoleKey sysUserRoleKey = new SysUserRoleKey();
            sysUserRoleKey.setUserId(userId);
            sysUserRoleKey.setRoleId(roleId);
            int userRoleResult = sysUserRoleMapper.insert(sysUserRoleKey);
            if (userRoleResult<=0){
                throw new MyException(400,"角色关联失败！");
            }

            resultData = new ResultData(UserEnum.REGISTER_SUCCESS.getCode(),UserEnum.REGISTER_SUCCESS.getMsg());
            log.info("注册用户方法结束，出参={}",JSON.toJSONString(resultData));
            return resultData;
        }
        resultData = new ResultData(UserEnum.REGISTER_ERROR.getCode(),UserEnum.REGISTER_ERROR.getMsg());
        log.info("注册用户方法结束，出参={}",JSON.toJSONString(resultData));
        return resultData;

    }

    @Override
    public ResultData deleteUserById(String userId) {
        log.info("删除用户方法开始，入参={}",userId);
        SysUser loginUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
        ResultData resultData = null;
        if (StringUtils.isBlank(userId)){
            resultData = new ResultData(GlobalEnum.PARAM_NOT_NULL.getCode(),GlobalEnum.PARAM_NOT_NULL.getMsg());
            log.info("删除用户方法结束，出参={}",JSON.toJSONString(resultData));
            return resultData;
        }
        SysUser sysUser = new SysUser();
        sysUser.setId(userId);
        sysUser.setDelMark(GlobalEnum.DEL_MARK.getKey());
        sysUser.setUpdateBy(loginUser.getId());
        int result = userMapper.updateByPrimaryKeySelective(sysUser);
        if (result<=0){
            resultData = new ResultData(UserEnum.DELETE_ERROR.getCode(),UserEnum.DELETE_ERROR.getMsg());
            log.info("删除用户方法结束，出参={}",JSON.toJSONString(resultData));
            return resultData;
        }
        resultData = new ResultData(UserEnum.DELETE_SUCCESS.getCode(),UserEnum.DELETE_SUCCESS.getMsg());
        log.info("删除用户方法结束，出参={}",JSON.toJSONString(resultData));
        return resultData;
    }

    @Override
    public ResultData updateLoginTime(String userId) {
        log.info("更新最后登陆时间开始：入参={}",userId);
        ResultData resultData = null;
        SysUser sysUser = new SysUser();
        sysUser.setId(userId);
        sysUser.setLastLoginTime(new Date());
        int result = userMapper.updateByPrimaryKeySelective(sysUser);
        if (result>0){
            resultData = new ResultData(UserEnum.UPDATE_SUCCESS.getCode(),UserEnum.UPDATE_SUCCESS.getMsg());
            log.info("更新最后登陆时间结束：出参={}",JSON.toJSONString(resultData));
            return resultData;
        }
        resultData = new ResultData(UserEnum.UPDATE_ERROR.getCode(),UserEnum.UPDATE_ERROR.getMsg());
        log.info("更新最后登陆时间结束：出参={}",JSON.toJSONString(resultData));
        return resultData;
    }
}
