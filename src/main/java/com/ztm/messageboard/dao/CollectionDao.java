package com.ztm.messageboard.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface CollectionDao {
    /**
     *删除用户相关数据
     */
    Integer delete(Integer userId);
    /**
     *删除留言
     */
    Integer deleteMessage(Long messageId);
}
