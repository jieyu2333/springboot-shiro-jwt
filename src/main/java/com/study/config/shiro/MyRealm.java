package com.study.config.shiro;

import com.auth0.jwt.interfaces.Claim;
import com.study.config.shiro.jwt.JwtToken;
import com.study.config.shiro.jwt.JwtUtils;
import com.study.sys.entity.RoleMenu;
import com.study.sys.entity.UserRole;
import com.study.sys.mapper.RoleMenuMapper;
import com.study.sys.mapper.UserRoleMapper;
import com.study.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
@Slf4j
public class MyRealm extends AuthorizingRealm{

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    /**
     * 必须重写此方法，不然会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("————身份认证方法开始————");
        String token = (String) authenticationToken.getCredentials();
        // 解密获得userId
        Map<String, Claim> map =JwtUtils.verifyToken(token);
        String userId = map.get("userId").asString();
        if (StringUtils.isBlank(userId)){
            throw new AuthenticationException("token已失效");
        }

        return new SimpleAuthenticationInfo(token, token, "MyRealm");
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("————权限认证方法开始————");
        // 解密获得userId
        Map<String, Claim> map =JwtUtils.verifyToken(principals.toString());
        String userId = map.get("userId").asString();
        if (StringUtils.isBlank(userId)){
            throw new AuthenticationException("token已失效");
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //角色集合
        Set<String> roleSet = new HashSet<>();
        //权限集合
        Set<String> permissionSet = new HashSet<>();
        //获得该用户角色
        String role = null;
        UserRole userRole = userRoleMapper.selectRoleByUserId(userId);
        if (null!=userRole){
            role = userRole.getRole();
        }

        roleSet.add(role);

        //获取每个用户的权限
        List<RoleMenu> roleMenus = roleMenuMapper.listRoleMenusByUserId(userId);
        for (RoleMenu roleMenu:roleMenus){
            permissionSet.add(roleMenu.getPermission());
        }

        //设置该用户拥有的角色和权限
        info.setRoles(roleSet);
        info.setStringPermissions(permissionSet);

        return info;
    }
}
