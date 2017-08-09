package com.happyjey.common;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
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
        // 如下是使用字符串密码，不安全，改为char[]类型密码
        String tokenPassword = String.valueOf(tokenCredentialsChar);
        String tokenCredentials = DigestUtils.md5Hex(tokenPassword);
        System.out.println("加密前"+tokenPassword+" | 加密后"+tokenCredentials);
        System.out.println("数据库密码"+infoCredentials);
        // 内容一致就返回true,不一致就返回false（string,byte[],char[]等最终都会转为byte[]做比较）
        return this.equals(tokenCredentials, infoCredentials);
    }


}