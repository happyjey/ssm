package com.happyjey.common;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * 告诉shiro如何验证加密密码，通过SimpleCredentialsMatcher或HashedCredentialsMatcher
 *
 */
public class MyCredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        // 数据库查询出来的加密密码
        Object infoCredentials = info.getCredentials();
        // 用户输入的明文密码
        char[] tokenCredentialsChar = (char[]) token.getCredentials();
        String tokenPassword = String.valueOf(tokenCredentialsChar);
        String tokenCredentials = DigestUtils.md5Hex(tokenPassword);
//        String tokenCredentials = Base64.encodeBase64String(tokenPassword.getBytes());//不等于32 是用户输入的密码。 如果用户输入的密码长度位32那么里面会有一个bug
        System.out.println("加密前"+tokenPassword+" | 加密后"+tokenCredentials);
        System.out.println("数据库密码"+infoCredentials);
        // 内容一致就返回true,不一致就返回false
        return tokenCredentials.equals(infoCredentials);
    }


}