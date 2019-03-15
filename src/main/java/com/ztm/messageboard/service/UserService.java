package com.ztm.messageboard.service;

import com.ztm.messageboard.entity.UserDO;

public interface UserService {
    /**
     *查询该用户信息
     */
    UserDO getUser(String userName);
    /**
     *增加用户
     */
    Integer addUser(UserDO userDO);
}
