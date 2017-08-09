package com.happyjey.common;

import com.happyjey.entity.Admin;
import com.happyjey.service.IAdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * shiro安全数据源
 */
public class MyRealm extends JdbcRealm {

    private static final Logger logger = LoggerFactory.getLogger(MyRealm.class);

    @Autowired
    IAdminService iAdminService;

    /**
     * 认证
     * @param token 用户输入的用户名/密码
     * @return AuthenticationInfo
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        if (username == null){
            throw new AccountException("null username are not allowed by this realm.");
        }
        logger.info("MyRealm-1:"+upToken.toString());
        Admin admin = iAdminService.getUserByName(username);
        logger.info("MyRealm-2:"+admin.toString());
        if (admin == null){
            throw new AuthenticationException("用户【"+username+"】不存在");
        }
        // 密码使用toCharArray()转为字符数组是为了安全
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(admin.getAdminName(),admin.getAdminPwd().toCharArray(),getName());
        logger.info("MyRealm-3:"+info.toString());
        return info;
    }

    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        Set<String> permissionList = iAdminService.getPermissions(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissionList);
        return simpleAuthorizationInfo;
    }
}
