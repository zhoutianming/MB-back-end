package com.ztm.messageboard.dao;

import com.ztm.messageboard.entity.ReviewDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewDao {
    /**
     *查询所有留言数据
    */
    List<ReviewDO> queryAllReviewData();
}
