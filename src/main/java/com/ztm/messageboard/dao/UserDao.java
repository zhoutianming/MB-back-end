package com.ztm.messageboard.dao;

import com.ztm.messageboard.entity.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    /**
     *查询该用户信息
    */
    UserDO queryUser(String userName);
    /**
     *查询该用户信息
     */
    UserDO queryUserById(Integer userId);
    /**
     *查询该用户点赞列表
     */
    UserDO queryUserPraiseList(Integer userId);
    /**
     *模糊查询该用户信息
     */
    List<UserDO> queryUserList(String userName);
    /**
     *插入一条用户信息
     */
    Integer insertUser(UserDO userDO);
    /**
     *删除用户及所有相关数据
     */
    Integer deleteUserData(Integer userId);
    /**
     *查询所有用户信息
     */
    List<UserDO> queryAllUserData();
    /**
     *根据用户名查询用户
     */
    List<UserDO> queryUserDataByUserName(String userName);
    /**
     *根据权限查询用户
     */
    List<UserDO> queryUserDataByType(Integer type);
    /**
     *修改用户名
     */
    Integer editUserName(UserData userData);
    /**
     *修改用户头像
     */
    Integer editUserHeadImage(UserData userData);
    /**
     *修改用户头像和用户名
     */
    Integer editUser(UserData userData);
    /**
     *修改用户权限
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
     *查询是否存在收藏
     */
    Integer queryCarePerson(CarePersonDO carePersonDO);
    /**
     *删除用户关注的人数据
     */
    Integer deleteCarePerson(Integer userId);
    /**
     *获取该用户关注的人
     */
    List<UserDO> getCarePerson(Integer userId);
    /**
     *取消关注
     */
    Integer unfollow(CarePersonDO carePersonDO);
    /**
     *添加点赞留言
     */
    Integer addPraiseMessage(UserData userData);
    /**
     *增加关注增长数
     */
    Integer addCaredAdditions(Integer caredUserId);
    /**
     *减少关注增长数
     */
    Integer reduceCaredAdditions(Integer caredUserId);
    /**
     *添加点赞增长数
     */
    Integer addPraiseAdditions(Integer praisedUserId);
    /**
     *取消关注增长数
     */
    Integer unShowCared(Integer userId);
    /**
     *取消点赞增长数
     */
    Integer unShowPraise(Integer userId);
}
