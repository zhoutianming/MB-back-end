package com.ztm.messageboard.dao;

import com.ztm.messageboard.entity.MessageDO;
import com.ztm.messageboard.entity.MessageVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionDao {
    /**
     *查询所有收藏数据
     */
    List<MessageDO> queryAllCollection();
    /**
     *查询该用户收藏
     */
    List<MessageDO> queryUserCollection(Integer userId);
    /**
     *查询被收藏收藏数
     */
    Long queryUserCollectionByMeId(Long messageId);
    /**
     *删除用户相关数据
     */
    Integer delete(Integer userId);
    /**
     *删除留言
     */
    Integer deleteMessage(Long messageId);
    /**
     *取消收藏
     */
    Integer unCollection(MessageVO messageVO);
}
