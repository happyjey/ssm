package com.happyjey.dao;

import com.happyjey.entity.Admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adminId);
    Admin selectByName(String name);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    Set<String> getPermissions(String name);
}