package com.happyjey.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/8/11.
 */
@Controller
@RequestMapping("/test/")
public class TestController {

    @RequestMapping("freemarker")
    public String freemarker(Model model){
        model.addAttribute("title","我是ftl标题");
        model.addAttribute("content","我是ftl内容");
        return "testfreemarker";
    }

    @RequestMapping("freemarker2")
    public String freemarker2(Model model){
        model.addAttribute("title","我是ftl标题");
        model.addAttribute("content","我是ftl内容");
        return "index";
    }

    @RequestMapping("jsp")
    public String jsp(Model model){
        model.addAttribute("title","我是jsp标题");
        model.addAttribute("content","我是jsp内容");
        return "testjsp";
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
