package com.ztm.messageboard.service.impl;

import com.ztm.messageboard.dao.CollectionDao;
import com.ztm.messageboard.dao.MessageDao;
import com.ztm.messageboard.dao.ReviewDao;
import com.ztm.messageboard.dao.UserDao;
import com.ztm.messageboard.entity.*;
import com.ztm.messageboard.service.MessageService;
import com.ztm.messageboard.utils.TimeUtil;
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
    @Autowired
    private CollectionDao collectionDao;
    /**
     *获取所有留言
     */
    @Override
    public List<Content> getAllContent(){
        List<MessageDO> messageDOS = messageDao.queryAllMessageData();
        return DOtoContent(messageDOS);
    }
    /**
     *获取分类下所有留言
     */
    @Override
    public List<Content> getContent(String messageTabs){
        List<MessageDO> messageDOS = messageDao.queryAllMessageData();
        List<MessageDO> messageDOList = messageDOS.stream()
                .filter(messageDO ->isTab(messageDO,messageTabs))
                .collect(Collectors.toList());
        return DOtoContent(messageDOList);
    }
    /**
     *关键字搜索内容
     */
    @Override
    public List<Content> searchContent(String content){
        List<MessageDO> messageDOS = messageDao.searchContent(content);
        return DOtoContent(messageDOS);
    }
    /**
     *获取该用户留言
     */
    @Override
    public List<Content> getUserContent(Integer userId){
        List<Content> contentList = new ArrayList<>();
        List<MessageDO> messageDOS =messageDao.getUserMessage(userId);
        List<ReviewDO> reviewDOList = reviewDao.queryAllReview();
        List<ReviewDO> reviewDOS = reviewDOList.stream()
                .filter(reviewDO -> reviewDO.getReviewedReviewId().equals(0))
                .collect(Collectors.toList());
        for(MessageDO messageDO : messageDOS){
            Content content = changeData(messageDO,reviewDOS);
            contentList.add(content);
        }
        return contentList;
    }

    /**
     *获取该用户收藏
     */
    @Override
    public List<Content> getUserCollection(Integer userId){
        List<Content> contentList = new ArrayList<>();
        List<MessageDO> messageDOS =messageDao.getUserCollection(userId);
        List<ReviewDO> reviewDOList = reviewDao.queryAllReview();
        List<ReviewDO> reviewDOS = reviewDOList.stream()
                .filter(reviewDO -> reviewDO.getReviewedReviewId().equals(0))
                .collect(Collectors.toList());
        List<UserDO> userDOS = userDao.queryAllUserData();
        for(MessageDO messageDO : messageDOS){
            List<UserDO> userList = userDOS.stream()
                    .filter(userDO -> userDO.getId().equals(messageDO.getUserId()))
                    .collect(Collectors.toList());
            Content content = changeData(messageDO,reviewDOS);
            content.setUserName(userList.get(0).getUserName());
            content.setHeadImg(userList.get(0).getHeadImg());
            contentList.add(content);
        }
        return contentList;
    }

    /**
     *保存留言
     */
    @Override
    public Integer addMessage(MessageDO messageDO){
        return messageDao.addMessage(messageDO);
    }

    /**
     *修改留言
     */
    @Override
    public Integer editMessage(MessageDO messageDO){
        return messageDao.editMessage(messageDO);
    }

    /**
     *修改留言文字内容
     */
    @Override
    public Integer editMessageText(MessageDO messageDO){
        return messageDao.editMessageText(messageDO);
    }
    /**
     *删除用户该留言
     */
    @Override
    public Integer deleteMessage(Long messageId){
        reviewDao.deleteMessageReview(messageId);
        return messageDao.deleteMessage(messageId);
    }

    /**
     *删除用户及所有相关数据
     */
    @Override
    public Integer deleteMessageData(Long messageId){
        reviewDao.deleteMessageReview(messageId);
        collectionDao.deleteMessage(messageId);
        return messageDao.deleteMessage(messageId);
    }

    /**
     *条件查询用户信息
     */
    @Override
    public List<Content> selectMessage(MessageVO messageVO){
        if(messageVO.getUserName()!= null){
            List<MessageDO> messageDOS = new ArrayList<>();
            List<UserDO> userDOList = userDao.queryUserList(messageVO.getUserName());
            if(userDOList.size() == 0){
                return null;
            }
            for(UserDO userDO : userDOList){
                List<MessageDO> messageDOList = messageDao.getUserMessage(userDO.getId());
                messageDOS.addAll(messageDOList);
            }
            return DOtoContent(messageDOS);
        }else if(messageVO.getMessageContent()!= null){
            List<MessageDO> messageDOS = messageDao.queryMessageDataByContent(messageVO.getMessageContent());
            return DOtoContent(messageDOS);
        }else{
            List<MessageDO> messageDOList = messageDao.queryAllMessageData();
            List<MessageDO> messageDOS = messageDOList.stream()
                    .filter(messageDO -> isTime(messageDO,messageVO))
                    .collect(Collectors.toList());
            return DOtoContent(messageDOS);
        }
    }
    /**
     *点赞
     */
    @Override
    public Integer addPraise(Long messageId){
        return messageDao.addPraise(messageId);
    }

    /**
     *收藏
     */
    @Override
    public Integer addCollection(MessageVO messageVO){
        Integer number = messageDao.queryCollection(messageVO);
        if(number == 0){
            Integer num = messageDao.addCollection(messageVO);
            if(!num.equals(1)){
                return 0;
            }
            return messageDao.addCollectionNum(messageVO.getMessageId());
        }else{
            return -1;
        }
    }
    /**
     *浏览
     */
    @Override
    public Integer addView(Long messageId){
        return messageDao.addView(messageId);
    }

    /**
     *数据转换
     */
    public Content changeData(MessageDO messageDO,List<ReviewDO> reviewDOS){
        Content content = new Content();
        content.setMessageId(messageDO.getMessageId());
        content.setUserId(messageDO.getUserId());
        content.setMessageContent(messageDO.getMessageContent());
        content.setMessageImg(messageDO.getMessageImg());
        content.setImageWidth(messageDO.getImageWidth());
        content.setImageHeight(messageDO.getImageHeight());
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
        return content;
    }
    /**
     *数据转换
     */
    public List<Content> DOtoContent(List<MessageDO> messageDOS){
        List<Content> contentList = new ArrayList<>();
        List<ReviewDO> reviewDOList = reviewDao.queryAllReview();
        List<ReviewDO> reviewDOS = reviewDOList.stream()
                .filter(reviewDO -> reviewDO.getReviewedReviewId().equals(0))
                .collect(Collectors.toList());
        List<UserDO> userDOS = userDao.queryAllUserData();
        for(MessageDO messageDO : messageDOS){
            Content content = changeData(messageDO,reviewDOS);
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
     *判断是否在该时间范围内
     */
    public Boolean isTime(MessageDO messageDO,MessageVO messageVO){
        Boolean isFlag = false;
        String startTime = messageVO.getStartTime();
        String endTime = messageVO.getEndTime();
        Integer bool1 = TimeUtil.stringToDate(messageDO.getTime()).compareTo(TimeUtil.stringToDate(startTime));
        Integer bool2 = TimeUtil.stringToDate(messageDO.getTime()).compareTo(TimeUtil.stringToDate(endTime));
        if(bool1 >= 0 && bool2 <= 0){
            isFlag = true;
        }
        return isFlag;
    }

    /**
     *查找该类型留言
     */
    public Boolean isTab(MessageDO messageDO,String messageTabs){
        Boolean isFlag = false;
        String tabs = messageDO.getMessageTabs();
        String[] tabList = tabs.split(",");
        for(int i = 0;i<tabList.length; i++){
            if(tabList[i].equals(messageTabs)){
                isFlag = true;
            }
        }
        return isFlag;
    }

}
