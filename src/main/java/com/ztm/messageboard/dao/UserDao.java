package com.ztm.messageboard.dao;

import com.ztm.messageboard.entity.UserDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    /**
     *查询该用户信息
    */
    UserDO queryUser(String userName);
    /**
     *插入一条用户信息
     */
    Integer insertUser(UserDO userDO);

    /**
     *查询所有用户信息
     */
    List<UserDO> queryAllUserData();
}
