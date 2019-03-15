package com.ztm.messageboard.service.impl;

import com.ztm.messageboard.dao.UserDao;
import com.ztm.messageboard.entity.UserDO;
import com.ztm.messageboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public UserDO getUser(String userName){
        return userDao.queryUser(userName);
    }

    @Override
    public Integer addUser(UserDO userDO){
        return userDao.insertUser(userDO);
    }
}
