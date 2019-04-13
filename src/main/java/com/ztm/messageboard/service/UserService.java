package com.ztm.messageboard.service;

import com.ztm.messageboard.entity.CarePerson;
import com.ztm.messageboard.entity.CarePersonDO;
import com.ztm.messageboard.entity.UserDO;
import com.ztm.messageboard.entity.UserData;

import java.util.List;

public interface UserService {
    /**
     *查询该用户信息
     */
    UserDO getUser(String userName);
    /**
     *查询所有用户信息
     */
    List<UserDO> queryAllUserData();
    /**
     *条件查询用户信息
     */
    List<UserDO> selectUser(UserData userData);
    /**
     *增加用户
     */
    Integer addUser(UserDO userDO);
    /**
     *删除用户及所有相关数据
     */
    Integer deleteUserData(Integer userId);
    /**
     *修改用户头像和用户名
     */
    Integer editUser(UserData userData);
    /**
     * 修改用户权限
     */
    Integer editUserType(UserData userData);
    /**
     *添加关注的人
     */
    Integer addCarePerson(CarePersonDO carePersonDO);
    /**
     *获取该用户关注的人
     */
    List<CarePerson> getCarePerson(Integer userId);
    /**
     *取消关注
     */
    Integer unfollow(CarePersonDO carePersonDO);
}
