package com.ztm.messageboard.dao;

import com.ztm.messageboard.entity.MessageDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDao {
    /**
     *查询所有留言数据
    */
    List<MessageDO> queryAllMessageData();
    /**
     *保存留言信息
     */
    Integer addMassage(MessageDO messageDO);
}
