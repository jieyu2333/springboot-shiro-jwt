package com.study.sys.service;

import com.study.common.ResultData;
import com.study.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author JieYu
 * @since 2019-04-24
 */
public interface IUserService extends IService<User> {

    /**
     * 校验用户信息
     * @param userName
     * @param password
     * @return
     */
    ResultData checkUser(String userName,String password);

}
