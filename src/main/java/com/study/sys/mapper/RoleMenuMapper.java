package com.study.sys.mapper;

import com.study.sys.entity.RoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色-菜单 Mapper 接口
 * </p>
 *
 * @author JieYu
 * @since 2019-04-24
 */
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

    /**
     * 根据用户id查询权限集合
     * @param userId
     * @return
     */
    List<RoleMenu> listRoleMenusByUserId(String userId);
}
