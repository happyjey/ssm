package com.happyjey.dao;

import com.happyjey.entity.ActivityIn;

public interface ActivityInMapper {
    int insert(ActivityIn record);

    int insertSelective(ActivityIn record);
}