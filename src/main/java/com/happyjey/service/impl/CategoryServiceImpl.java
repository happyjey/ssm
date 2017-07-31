package com.happyjey.service.impl;

import com.happyjey.dao.CategoryMapper;
import com.happyjey.entity.Category;
import com.happyjey.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/7/31.
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Transactional
    @Override
    public Category getInfo(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }
}
