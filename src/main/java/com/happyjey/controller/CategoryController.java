package com.happyjey.controller;

import com.happyjey.entity.Category;
import com.happyjey.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/7/31.
 */
@Controller
@RequestMapping("/category/")
public class CategoryController {

    @Autowired
    ICategoryService iCategoryService;

    @RequestMapping(value = "get_info")
    @ResponseBody
    public String getInfo(Integer id){
        Category category = iCategoryService.getInfo(id);
        return category.toString();
    }
}
