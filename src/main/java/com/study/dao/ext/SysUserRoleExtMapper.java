package com.study.dao.ext;

import com.study.model.ext.SysUserRoleExt;

import java.util.List;

/**
 * @ClassName SysUserRoleExtMapper
 * @Description
 * @Author jieyu
 * @Date 2018/12/7 14:49
 * @Version 1.0
 **/
public interface SysUserRoleExtMapper {

    List<SysUserRoleExt> listRoles(String userId);
}
