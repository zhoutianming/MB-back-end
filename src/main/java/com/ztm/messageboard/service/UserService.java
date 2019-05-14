package com.ztm.messageboard.service;

import com.ztm.messageboard.entity.*;

import java.util.List;

public interface UserService {
    /**
     *查询该用户信息
     */
    UserData getUser(String userName);
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
     *修改用户名
     */
    Integer editUserName(UserData userData);
    /**
     *修改用户头像和用户名
     */
    Integer editUser(UserData userData);
    /**
     * 修改用户权限
     */
    Integer editUserType(UserData userData);
    /**
     * 修改密码
     */
    Integer editPassword(UserVO userVO);
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
    /**
     *取消收藏
     */
    Integer unCollection(MessageVO messageVO);
    /**
     *取消关注增长数
     */
    Integer unShowCared(Integer userId);
    /**
     *取消点赞增长数
     */
    Integer unShowPraise(Integer userId);
}
