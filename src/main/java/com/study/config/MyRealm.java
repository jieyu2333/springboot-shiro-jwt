package com.study.config;

import com.study.common.GlobalEnum;
import com.study.common.UserEnum;
import com.study.dao.base.SysRoleMenuMapper;
import com.study.dao.base.SysUserMapper;
import com.study.dao.base.SysUserRoleMapper;
import com.study.dao.ext.SysRoleMenuExtMapper;
import com.study.dao.ext.SysUserRoleExtMapper;
import com.study.model.base.*;
import com.study.model.ext.SysRoleMenuExt;
import com.study.model.ext.SysUserRoleExt;
import com.study.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @ClassName MyRealm
 * @Description shiro自定义realm
 * @Author jieyu
 * @Date 2018/12/6 14:30
 * @Version 1.0
 **/
public class MyRealm extends AuthorizingRealm {
    /*https://www.jianshu.com/p/672abf94a857?winzoom=1*/
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private SysUserRoleExtMapper sysUserRoleExtMapper;
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;
    @Autowired
    private SysRoleMenuExtMapper sysRoleMenuExtMapper;



    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限认证方法：MyRealm.doGetAuthenticationInfo()");
        SysUser token = (SysUser) SecurityUtils.getSubject().getPrincipal();
        String userId = token.getId();
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        //根据用户ID查询角色（role），放入到Authorization里。
        List<SysUserRoleExt> sysUserRoleKeys = sysUserRoleExtMapper.listRoles(userId);
        Set<String> roleSet = new HashSet<>();
        for(SysUserRoleExt role : sysUserRoleKeys){
            roleSet.add(role.getRole());
        }
        info.setRoles(roleSet);

        //根据用户ID查询权限（permission），放入到Authorization里。
        List<SysRoleMenuExt> sysRoleMenuKeys = sysRoleMenuExtMapper.listMenus(userId);
        Set<String> permissionSet = new HashSet<>();
        for(SysRoleMenuExt permission : sysRoleMenuKeys){
            if (StringUtils.isNotBlank(permission.getPermission())){
                permissionSet.add(permission.getPermission());
            }
        }
        info.setStringPermissions(permissionSet);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("身份认证方法：MyRealm.doGetAuthenticationInfo()");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();
        SysUser user = null;
        // 从数据库获取对应用户名的用户
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUserNameEqualTo(userName).andDelMarkEqualTo(GlobalEnum.NO_DEL_MARK.getKey());
        List<SysUser> userList = sysUserMapper.selectByExample(sysUserExample);
        if(userList==null||userList.size()!=1){
            throw new UnknownAccountException(UserEnum.ERROR_ACCOUNT.getMsg());
        }
        user = userList.get(0);
        if(GlobalEnum.NO_USE_MARK.equals(user.getUseMark())){
            throw new LockedAccountException(UserEnum.ACCOUNT_DISABLED.getMsg());
        }
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getId());//盐值
        return new SimpleAuthenticationInfo(user, user.getPassword(),credentialsSalt ,getName());
    }
}
