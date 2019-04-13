package com.ztm.messageboard.service;

import com.ztm.messageboard.entity.Review;
import com.ztm.messageboard.entity.ReviewDO;
import com.ztm.messageboard.entity.ReviewData;

import java.util.List;

public interface ReviewService {
    /**
     *查询所有留言的留言评论
     */
    List<ReviewData> getAllMessageReview();
    /**
     *查询该评论的所有评论
     */
    List<ReviewData> getRemarkReview(ReviewData reviewData);
    /**
     *条件查询留言评论
     */
    List<ReviewData> selectReview(ReviewData reviewData);
    /**
     *获取该留言所有评论
     */
    List<Review> getMessageReview(Long messageId);
    /**
     *保存评论
     */
    Integer addReview(ReviewDO reviewDO);
    /**
     *保存评论的评论
     */
    Integer addPlusReview(ReviewDO reviewDO);
    /**
     * 修改评论内容
     */
    Integer editReview(ReviewData reviewData);
    /**
     * 删除评论
     */
    Integer deleteReview(Integer reviewId);
}
