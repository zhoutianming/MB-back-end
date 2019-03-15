package com.ztm.messageboard.service.impl;

import com.ztm.messageboard.dao.MessageDao;
import com.ztm.messageboard.dao.ReviewDao;
import com.ztm.messageboard.dao.UserDao;
import com.ztm.messageboard.entity.Content;
import com.ztm.messageboard.entity.MessageDO;
import com.ztm.messageboard.entity.ReviewDO;
import com.ztm.messageboard.entity.UserDO;
import com.ztm.messageboard.service.MessageService;
import com.ztm.messageboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("messageService")
public class MessageServiceImpl implements MessageService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private MessageDao messageDao;
    @Autowired
    private ReviewDao reviewDao;
    /**
     *获取所有留言信息
     */
    @Override
    public List<Content> getContent(){
        List<Content> contentList = new ArrayList<>();
        List<MessageDO> messageDOS =messageDao.queryAllMessageData();
        List<ReviewDO> reviewDOS = reviewDao.queryAllReviewData();
        List<UserDO> userDOS = userDao.queryAllUserData();
        for(MessageDO messageDO : messageDOS){
            Content content = new Content();
            content.setMessageId(messageDO.getMessageId());
            content.setUserId(messageDO.getUserId());
            content.setMessageContent(messageDO.getMessageContent());
            content.setMessageImg(messageDO.getMessageImg());
            content.setPraisePoint(messageDO.getPraisePoint());
            content.setPageViews(messageDO.getPageViews());
            Long reviewNum = reviewDOS.stream()
                    .filter(reviewDO ->
                            reviewDO.getReviewedMessageId().toString()
                                    .equals(messageDO.getMessageId().toString()))
                    .count();
            content.setReviewNumber(reviewNum);
            content.setCollectionNumber(messageDO.getCollectionNumber());
            content.setTime(messageDO.getTime());
            List<UserDO> userList = userDOS.stream()
                    .filter(userDO -> userDO.getId().equals(messageDO.getUserId()))
                    .collect(Collectors.toList());
            content.setUserName(userList.get(0).getUserName());
            content.setHeadImg(userList.get(0).getHeadImg());
            contentList.add(content);
        }
        return contentList;
    }
    /**
     *保存留言信息
     */
    @Override
    public Integer addMassage(MessageDO messageDO){
        return messageDao.addMassage(messageDO);
    }
}
