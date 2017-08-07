package com.happyjey.common;

import com.happyjey.entity.Admin;
import com.happyjey.service.IAdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * shiro安全数据源
 */
public class MyRealm extends JdbcRealm {

    private static final Logger logger = LoggerFactory.getLogger(MyRealm.class);

    @Autowired
    IAdminService iAdminService;

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
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(admin.getAdminName(),admin.getAdminPwd(),getName());
        logger.info("MyRealm-3:"+info.toString());
        return info;
    }
}
