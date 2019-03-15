package com.ztm.messageboard.service;

import com.ztm.messageboard.entity.Content;
import com.ztm.messageboard.entity.MessageDO;

import java.util.List;

public interface MessageService {
    /**
     *获取所有留言信息
     */
    List<Content> getContent();
    /**
     *保存留言信息
     */
    Integer addMassage(MessageDO messageDO);
}
