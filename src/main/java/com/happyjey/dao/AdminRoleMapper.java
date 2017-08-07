package com.happyjey.dao;

import com.happyjey.entity.AdminRole;

public interface AdminRoleMapper {
    int insert(AdminRole record);

    int insertSelective(AdminRole record);
}