package com.ztm.messageboard.service.impl;

import com.ztm.messageboard.dao.CollectionDao;
import com.ztm.messageboard.dao.MessageDao;
import com.ztm.messageboard.dao.ReviewDao;
import com.ztm.messageboard.dao.UserDao;
import com.ztm.messageboard.entity.*;
import com.ztm.messageboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private MessageDao messageDao;
    @Autowired
    private ReviewDao reviewDao;
    @Autowired
    private CollectionDao collectionDao;
    /**
     *查询所有用户信息
     */
    @Override
    public List<UserDO> queryAllUserData(){
        return userDao.queryAllUserData();
    }
    /**
     *查询条件用户信息
     */
    @Override
    public List<UserDO> selectUser(UserData userData){
        if(userData.getUserName()!= null){
            return userDao.queryUserDataByUserName(userData.getUserName());
        }else {
            return userDao.queryUserDataByType(userData.getType());
        }
    }
    /**
     *查询该用户信息
     */
    @Override
    public UserData getUser(String userName){
        UserDO userDO = userDao.queryUser(userName);
        UserData userData = new UserData();
        if (userDO != null) {
            userData.setType(userDO.getType());
            userData.setUserName(userDO.getUserName());
            userData.setHeadImg(userDO.getHeadImg());
            userData.setPraiseList(userDO.getPraiseList());
            userData.setId(userDO.getId());
            userData.setPassword(userDO.getPassword());
            if (userDO.getCaredAdditions() < 0L) {
                userData.setPraiseAdditions(0L);
            } else {
                userData.setPraiseAdditions(userDO.getPraiseAdditions());
            }
            if (userDO.getCaredAdditions() < 0L) {
                userData.setCaredAdditions(0L);
            } else {
                userData.setCaredAdditions(userDO.getCaredAdditions());
            }
            List<UserDO> userDOS = userDao.getCarePerson(userDO.getId());
            Long careNum = userDOS.stream()
                    .count();
            userData.setCarePersonNum(careNum);
            List<MessageDO> messageDOS =messageDao.getUserCollection(userDO.getId());
            Long collectionNum = messageDOS.stream()
                    .count();
            userData.setCollectionNum(collectionNum);
            Long caredNum = messageDao.getBeCaredNum(userDO.getId());
            userData.setBeCaredNum(caredNum);
            Long praisedNum = messageDao.getPraiseNum(userDO.getId());
            userData.setPraisedNum(praisedNum);
        }
        return userData;
    }
    /**
     *增加用户
     */
    @Override
    public Integer addUser(UserDO userDO){
        UserDO userDO1 = userDao.queryUser(userDO.getUserName());
        if (userDO1 != null) {
            return 2;
        }
        return userDao.insertUser(userDO);
    }
    /**
     *删除用户及所有相关数据
     */
    @Override
    public Integer deleteUserData(Integer userId){
        messageDao.deleteUserMessage(userId);
        reviewDao.deleteUserAllReview(userId);
        collectionDao.delete(userId);
        userDao.deleteCarePerson(userId);
        return userDao.deleteUserData(userId);
    }
    /**
     *修改用户名
     */
    @Override
    public Integer editUserName(UserData userData){
        UserDO userDO1 = userDao.queryUser(userData.getUserName());
        if (userDO1 != null) {
            return 2;
        }
        return userDao.editUserName(userData);
    }
    /**
     *修改用户头像和用户名
     */
    @Override
    public Integer editUser(UserData userData){
        UserDO userDO1 = userDao.queryUser(userData.getUserName());
        if (userDO1 != null) {
            return 2;
        }
        return userDao.editUser(userData);
    }

    /**
     * 修改用户权限
     */
    @Override
    public Integer editUserType(UserData userData){
        UserDO userDO = userDao.queryUser(userData.getUserName());
        if(userDO.getType()==2){
            userData.setType(1);
        }else if(userDO.getType()==1){
            userData.setType(2);
        }
        return userDao.editUserType(userData);
    }
    /**
     * 修改密码
     */
    @Override
    public Integer editPassword(UserVO userVO){
        UserDO userDO = userDao.queryUser(userVO.getName());
        if (userDO.getPassword().equals(userVO.getOldPassword())){
            return userDao.editPassword(userVO);
        }
        return 2;
    }
    /**
     *添加关注的人
     */
    @Override
    public Integer addCarePerson(CarePersonDO carePersonDO){
        Integer number = userDao.queryCarePerson(carePersonDO);
        if(number == 0){
            userDao.addCaredAdditions(carePersonDO.getCarePersonId());
            return userDao.addCarePerson(carePersonDO);
        }else{
            return -1;
        }
    }
    /**
     *获取该用户关注的人
     */
    @Override
    public List<CarePerson> getCarePerson(Integer userId){
        List<CarePerson> carePersonList = new ArrayList<>();
        List<UserDO> userDOList = userDao.getCarePerson(userId);
        for(UserDO userDO : userDOList){
            CarePerson carePerson = new CarePerson();
            carePerson.setId(userDO.getId());
            carePerson.setUserName(userDO.getUserName());
            carePerson.setHeadImg(userDO.getHeadImg());
            carePerson.setPraisedNum(0L);
            carePerson.setBeCaredNum(0L);
            Long praisedNum = messageDao.getPraiseNum(userDO.getId());
            Long caredNum = messageDao.getBeCaredNum(userDO.getId());
            if(praisedNum != null){
                carePerson.setPraisedNum(praisedNum);
            }
            if(caredNum != null){
                carePerson.setBeCaredNum(caredNum);
            }
            carePersonList.add(carePerson);
        }
        return carePersonList;
    }
    /**
     *取消关注
     */
    @Override
    public Integer unfollow(CarePersonDO carePersonDO){
        userDao.reduceCaredAdditions(carePersonDO.getCarePersonId());
        return userDao.unfollow(carePersonDO);
    }

    /**
     *取消关注
     */
    @Override
    public Integer unCollection(MessageVO messageVO){
        return collectionDao.unCollection(messageVO);
    }
    /**
     *取消关注增长数
     */
    @Override
    public Integer unShowCared(Integer userId){
        return userDao.unShowCared(userId);
    }
    /**
     *取消点赞增长数
     */
    @Override
    public Integer unShowPraise(Integer userId){
        return userDao.unShowPraise(userId);
    }
}
