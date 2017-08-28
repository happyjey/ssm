package com.happyjey.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.happyjey.dao.ActivityMapper;
import com.happyjey.entity.Activity;
import com.happyjey.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/28.
 */
@Service("iActivityService")
public class ActivityServiceImpl implements IActivityService {

    @Autowired
    ActivityMapper activityMapper;

    @Override
    public PageInfo getList(Map<String, Object> map,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Activity> activityList = activityMapper.selectBySearch(map);
        PageInfo pageInfo = new PageInfo<Activity>(activityList);
        return pageInfo;
    }
}
