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
        return "login";
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
                return "redirect:/user/success";
            }
        }
        return "redirect:/user/success";
    }

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String test(){
        System.out.println("test");
        return "test";
    }

    @RequestMapping(value = "success",method = RequestMethod.GET)
    public String success(){
        Subject subject = SecurityUtils.getSubject();
        boolean isPermitted = subject.isPermitted("user:*");
        System.out.println("isPermitted:user:*="+isPermitted);
        boolean isPermitted2 = subject.isPermitted("user:edit");
        System.out.println("isPermitted:user:edit="+isPermitted2);
        System.out.println("success");
        return "success";
    }

    @RequestMapping(value = "unauthorized",method = RequestMethod.GET)
    public String unauthorized(){
        System.out.println("unauthorized");
        return "unauthorized";
    }
}
