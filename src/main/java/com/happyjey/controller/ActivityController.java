package com.happyjey.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.happyjey.entity.Activity;
import com.happyjey.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 活动管理
 * Created by Administrator on 2017/8/28.
 */
@RequestMapping("/activity/")
@Controller
public class ActivityController {

    @Autowired
    IActivityService iActivityService;

    @RequestMapping("list")
    public String list(Activity activity, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, Model model){
        System.out.println("pageNum:"+pageNum);
        System.out.println("pageSize:"+pageSize);
        System.out.println(activity.toString());
        Map<String, Object> map = Maps.newHashMap();
        PageInfo pageInfo = iActivityService.getList(map,pageNum,pageSize);
        model.addAttribute("pageInfo", pageInfo);
        System.out.println(pageInfo.toString());
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(pageInfo);
        return "activity/list";
    }
}
