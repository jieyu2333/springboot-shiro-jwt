package com.study.dao.ext;

import com.study.model.base.SysUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @InterfaceName SysUserExtMapper
 * @Description 用户相关dao层
 * @Author jieyu
 * @Date 2018/12/20 15:39
 * @Version 1.0
 **/
public interface SysUserExtMapper {

    /**
     * @Author jieyu
     * @Description 查询未删除的所有用户信息
     * @Date 2018/12/20 16:03
     * @Param []
     * @return java.util.List<com.study.model.base.SysUser>
     **/
    List<SysUser> listSysUser();

}
