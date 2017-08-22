package com.happyjey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
