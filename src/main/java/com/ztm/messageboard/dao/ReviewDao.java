package com.ztm.messageboard.dao;

import com.ztm.messageboard.entity.ReviewDO;
import com.ztm.messageboard.entity.ReviewData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewDao {
    /**
     *查询所有评论
    */
    List<ReviewDO> queryAllReview();
    /**
     *查询所有留言的留言评论
     */
    List<ReviewData> getAllMessageReview();
    /**
     *查询该评论的所有评论
     */
    List<ReviewData> getRemarkReview(Integer reviewId);
    /**
     *根据用户id查询评论
     */
    List<ReviewData> queryReviewDataByUserName(String userName);
    /**
     *根据被评论的内容查询评论
     */
    List<ReviewData> queryMessageDataByReviewedContent(String reviewedContent);
    /**
     *根据评论内容查询评论
     */
    List<ReviewData> queryMessageDataByReviewContent(String reviewContent);
    /**
     *查询该留言所有评论
     */
    List<ReviewDO> queryReview(Long messageId);
    /**
     *保存评论
     */
    Integer addReview(ReviewDO reviewDO);
    /**
     *保存评论的评论
     */
    Integer addPlusReview(ReviewDO reviewDO);
    /**
     *删除留言的所有评论
     */
    Integer deleteMessageReview(Long messageId);
    /**
     *删除用户所有相关评论
     */
    Integer deleteUserAllReview(Integer userId);
    /**
     * 修改评论内容
     */
    Integer editReview(ReviewData reviewData);
    /**
     * 删除评论
     */
    Integer deleteReview(Integer reviewId);
}
