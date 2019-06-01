package com.study.sys.mapper;

import com.study.sys.entity.Role;
import com.study.sys.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author JieYu
 * @since 2019-04-24
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * 根据用户id查询角色
     * @param userId
     * @return
     */
    UserRole selectRoleByUserId(String userId);

}
