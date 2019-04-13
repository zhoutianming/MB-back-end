package com.ztm.messageboard.dao;

import com.ztm.messageboard.entity.Content;
import com.ztm.messageboard.entity.MessageDO;
import com.ztm.messageboard.entity.MessageVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDao {
    /**
     *查询所有留言数据
    */
    List<MessageDO> queryAllMessageData();
    /**
     *查询该用户留言数据
     */
    List<MessageDO> getUserMessage(Integer userId);
    /**
     *获取该用户收藏
     */
    List<MessageDO> getUserCollection(Integer userId);
    /**
     *根据内容查询留言
     */
    List<MessageDO> queryMessageDataByContent(String messageContent);
    /**
     *保存留言
     */
    Integer addMessage(MessageDO messageDO);
    /**
     *修改留言文字内容
     */
    Integer editMessageText(MessageDO messageDO);
    /**
     *修改留言
     */
    Integer editMessage(MessageDO messageDO);
    /**
     *删除用户该留言
     */
    Integer deleteMessage(Long messageId);
    /**
     *删除用户所有留言
     */
    Integer deleteUserMessage(Integer userId);
    /**
     *点赞
     */
    Integer addPraise(Long messageId);
    /**
     *增加收藏数
     */
    Integer addCollectionNum(Long messageId);
    /**
     *添加收藏
     */
    Integer addCollection(MessageVO messageVO);
    /**
     *查询是否存在收藏
     */
    Integer queryCollection(MessageVO messageVO);
    /**
     *浏览
     */
    Integer addView(Long messageId);
    /**
     *获取点赞数
     */
    Long getPraiseNum(Integer userId);
    /**
     *获取关注度
     */
    Long getBeCaredNum(Integer userId);
    /**
     *关键字搜索内容
     */
    List<MessageDO> searchContent(String content);
}
