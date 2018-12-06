package com.study.config;

import com.study.common.UserEnum;
import com.study.dao.base.SysUserMapper;
import com.study.model.base.SysUser;
import com.study.model.base.SysUserExample;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName CustomRealm
 * @Description TODO
 * @Author jieyu
 * @Date 2018/12/6 14:30
 * @Version 1.0
 **/
public class MyRealm extends AuthorizingRealm {
    /*https://www.jianshu.com/p/672abf94a857?winzoom=1*/
    @Autowired
    private SysUserMapper sysUserMapper;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限认证方法：MyShiroRealm.doGetAuthenticationInfo()");
        SysUser token = (SysUser) SecurityUtils.getSubject().getPrincipal();
        String userId = token.getId();
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        //根据用户ID查询角色（role），放入到Authorization里。
    /*Map<String, Object> map = new HashMap<String, Object>();
    map.put("user_id", userId);
    List<SysRole> roleList = sysRoleService.selectByMap(map);
    Set<String> roleSet = new HashSet<String>();
    for(SysRole role : roleList){
        roleSet.add(role.getType());
    }*/
        //实际开发，当前登录用户的角色和权限信息是从数据库来获取的，我这里写死是为了方便测试
        Set<String> roleSet = new HashSet<String>();
        roleSet.add("100002");
        info.setRoles(roleSet);
        //根据用户ID查询权限（permission），放入到Authorization里。
    /*List<SysPermission> permissionList = sysPermissionService.selectByMap(map);
    Set<String> permissionSet = new HashSet<String>();
    for(SysPermission Permission : permissionList){
        permissionSet.add(Permission.getName());
    }*/
        Set<String> permissionSet = new HashSet<String>();
        permissionSet.add("权限添加");
        info.setStringPermissions(permissionSet);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("身份认证方法：MyShiroRealm.doGetAuthenticationInfo()");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();
        String password = token.getPassword()==null?null:String.valueOf(token.getPassword());
        SysUser user = null;
        // 从数据库获取对应用户名密码的用户
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUserNameEqualTo(userName).andPasswordEqualTo(password).andDelMarkEqualTo(UserEnum.NO_DEL_MARK.getKey());
        List<SysUser> userList = sysUserMapper.selectByExample(sysUserExample);
        if(userList!=null&&userList.size()==1){
            user = userList.get(0);
        }
        if (user==null) {
            throw new AccountException(UserEnum.ERROR_ACCOUNT_PASSWORD.getMsg());
        }else if(UserEnum.NO_USE_MARK.equals(user.getUseMark())){
            /**
             * 如果用户的useMark为禁用。那么就抛出DisabledAccountException
             */
            throw new DisabledAccountException(UserEnum.ACCOUNT_DISABLED.getMsg());
        }else{
            //更新登录时间 last login time
            user.setLastLoginTime(new Date());
            sysUserMapper.updateByPrimaryKeySelective(user);
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
}
