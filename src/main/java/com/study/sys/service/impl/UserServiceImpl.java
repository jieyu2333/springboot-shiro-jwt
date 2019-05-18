package com.study.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.common.ResultData;
import com.study.sys.entity.User;
import com.study.sys.mapper.UserMapper;
import com.study.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JieYu
 * @since 2019-04-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public ResultData checkUser(String userName, String password) {
        if (StringUtils.isBlank(userName)){
            return new ResultData(1,"username is empty!");
        }
        if (StringUtils.isBlank(password)){
            return new ResultData(1,"password is empty!");
        }
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_name",userName));
        if (null == user){
            return new ResultData(1,"user doesn't exist!");
        }
        if (!password.equals(user.getPassword())){
            return new ResultData(1,"wrong password!");
        }
        if ("N".equals(user.getUseMark())){
            return new ResultData(1,"user is lock!");
        }

        return new ResultData(0,"success",user);
    }


    @Override
    public IPage<User> selectUserPage(Page page,User user) {
        return userMapper.selectPageByParam(page,user);
    }
}
