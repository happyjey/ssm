package com.happyjey.service;

import com.happyjey.entity.Admin;

/**
 * Created by Administrator on 2017/8/4.
 */
public interface IAdminService {
    Admin getUserById(Integer id);

    Admin getUserByName(String name);
}
