package com.study.dao.ext;

import com.study.model.ext.SysRoleMenuExt;

import java.util.List;

/**
 * @InterfaceName SysRoleMenuExtMapper
 * @Description
 * @Author jieyu
 * @Date 2018/12/7 15:27
 * @Version 1.0
 **/
public interface SysRoleMenuExtMapper {

    List<SysRoleMenuExt> listMenus(String userId);
}
