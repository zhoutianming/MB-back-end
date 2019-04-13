package com.ztm.messageboard.service;

import com.ztm.messageboard.entity.*;

import java.util.List;

public interface MessageService {
    /**
     *获取所有留言
     */
    List<Content> getAllContent();
    /**
     *获取分类所有留言
     */
    List<Content> getContent(String messageTabs);
    /**
     *关键字搜索内容
     */
    List<Content> searchContent(String content);
    /**
     *获取该用户留言
     */
    List<Content> getUserContent(Integer userId);

    /**
     *获取该用户收藏
     */
    List<Content> getUserCollection(Integer userId);
    /**
     *保存留言
     */
    Integer addMessage(MessageDO messageDO);
    /**
     *修改留言
     */
    Integer editMessage(MessageDO messageDO);
    /**
     *修改留言文字内容
     */
    Integer editMessageText(MessageDO messageDO);
    /**
     *删除用户该留言
     */
    Integer deleteMessage(Long messageId);
    /**
     *删除留言及所有相关数据
     */
    Integer deleteMessageData(Long messageId);
    /**
     *条件查询用户信息
     */
    List<Content> selectMessage(MessageVO messageVO);
    /**
     *点赞
     */
    Integer addPraise(Long messageId);
    /**
     *收藏
     */
    Integer addCollection(MessageVO messageVO);
    /**
     *浏览
     */
    Integer addView(Long messageId);
}
