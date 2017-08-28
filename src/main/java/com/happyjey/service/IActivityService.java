package com.happyjey.service;

import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * Created by Administrator on 2017/8/28.
 */
public interface IActivityService {
    PageInfo getList(Map<String,Object> map, int pageNum, int pageSize);
}
