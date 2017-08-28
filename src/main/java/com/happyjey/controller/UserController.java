package com.happyjey.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户控制器
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        Subject subject = SecurityUtils.getSubject();
        // 是否登录
        if (!subject.isAuthenticated()){
            return "login";
        }
        return "redirect:/index/index";
    }

    @RequestMapping(value = "dologin",method = RequestMethod.POST)
    public String dologin(String username, String pwd){
        System.out.println("username:"+username+"|pwd:"+pwd);

        Subject subject = SecurityUtils.getSubject();
        // 是否登录
        if (!subject.isAuthenticated()){
            UsernamePasswordToken upToken = new UsernamePasswordToken(username,pwd);
            try {
                subject.login(upToken);
            }catch (AuthenticationException e){
                logger.error("认证失败");
                return "redirect:/user/login";
            }
        }
        return "redirect:/index/index";
    }

    @RequestMapping("logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/user/login";
    }


}
