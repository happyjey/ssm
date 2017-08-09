package com.happyjey.service;

import com.happyjey.entity.Admin;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/8/4.
 */
public interface IAdminService {
    Admin getUserById(Integer id);

    Admin getUserByName(String name);

    Set<String> getPermissions(String name);
}
