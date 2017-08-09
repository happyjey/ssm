package com.happyjey.service.impl;

import com.happyjey.dao.AdminMapper;
import com.happyjey.entity.Admin;
import com.happyjey.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/8/4.
 */
@Service("adminService")
public class AdminServiceImpl implements IAdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin getUserById(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public Admin getUserByName(String name) {
        return adminMapper.selectByName(name);
    }

    @Override
    public Set<String> getPermissions(String name) {
        return adminMapper.getPermissions(name);
    }
}
