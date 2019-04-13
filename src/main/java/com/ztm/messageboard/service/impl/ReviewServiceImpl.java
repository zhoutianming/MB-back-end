package com.ztm.messageboard.service.impl;

import com.ztm.messageboard.dao.ReviewDao;
import com.ztm.messageboard.dao.UserDao;
import com.ztm.messageboard.entity.*;
import com.ztm.messageboard.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewDao reviewDao;
    @Autowired
    private UserDao userDao;
    /**
     *查询所有留言的留言评论
     */
    @Override
    public List<ReviewData> getAllMessageReview(){
        return reviewDao.getAllMessageReview();
    }
    /**
     *查询该评论的所有评论
     */
    @Override
    public List<ReviewData> getRemarkReview(ReviewData reviewData){
        return reviewDao.getRemarkReview(reviewData.getReviewId());
    }
    /**
     *条件查询留言评论
     */
    @Override
    public List<ReviewData> selectReview(ReviewData reviewData){
        List<ReviewData> reviewDataList;
        if(reviewData.getUserName()!= null){
            reviewDataList = reviewDao.queryReviewDataByUserName(reviewData.getUserName());
            return reviewDataList;
        }else if(reviewData.getReviewedContent()!= null){
            reviewDataList = reviewDao.queryMessageDataByReviewedContent(reviewData.getReviewedContent());
            return reviewDataList;
        }else{
            reviewDataList = reviewDao.queryMessageDataByReviewContent(reviewData.getReviewContent());
            return reviewDataList;
        }
    }
    /**
     *获取该留言所有评论
     */
    public List<Review> getMessageReview(Long messageId){
        List<Review> reviewList = new ArrayList<>();
        List<ReviewDO> reviewDOList = reviewDao.queryReview(messageId);
        List<ReviewDO> reviewDOS = reviewDOList.stream()
                .filter(reviewDO -> reviewDO.getReviewedReviewId().equals(0))
                .collect(Collectors.toList());
        for(ReviewDO reviewDO : reviewDOS){
            Review review = new Review();
            review.setReviewId(reviewDO.getReviewId());
            review.setUserId(reviewDO.getUserId());
            review.setReviewedMessageId(reviewDO.getReviewedMessageId());
            review.setUserName(reviewDO.getUserName());
            review.setHeadImg(reviewDO.getHeadImg());
            review.setReviewContent(reviewDO.getReviewContent());
            List<ReviewDO> reviewDOSS = reviewDOList.stream()
                    .filter(reviewD ->
                            reviewD.getReviewedReviewId().equals(reviewDO.getReviewId()))
                    .collect(Collectors.toList());
            List<ReviewPlus> reviewPlusList = new ArrayList<>();
            for(ReviewDO reviews : reviewDOSS){
                ReviewPlus reviewPlus = new ReviewPlus();
                reviewPlus.setReviewId(reviews.getReviewId());
                reviewPlus.setUserId(reviews.getUserId());
                reviewPlus.setReviewedReviewId(reviews.getReviewedReviewId());
                reviewPlus.setReviewContent(reviews.getReviewContent());
                reviewPlus.setUserName(reviews.getUserName());
                reviewPlusList.add(reviewPlus);
            }
            review.setReviewPlusList(reviewPlusList);
            reviewList.add(review);
        }
        return reviewList;
    }

    /**
     *保存评论
     */
    @Override
    public Integer addReview(ReviewDO reviewDO){
        return reviewDao.addReview(reviewDO);
    }
    /**
     *保存评论的评论
     */
    @Override
    public Integer addPlusReview(ReviewDO reviewDO){
        return reviewDao.addPlusReview(reviewDO);
    }
    /**
     * 修改评论内容
     */
    @Override
    public Integer editReview(ReviewData reviewData){
        return reviewDao.editReview(reviewData);
    }
    /**
     * 删除评论
     */
    @Override
    public Integer deleteReview(Integer reviewId){

        return reviewDao.deleteReview(reviewId);
    }
}
