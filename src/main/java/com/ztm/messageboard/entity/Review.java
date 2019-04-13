package com.ztm.messageboard.entity;

import java.util.List;

public class Review {
    /**
     * 评论id
     */
    private Integer reviewId;
    /**
     * 被评论的留言id
     */
    private Integer reviewedMessageId;
    /**
     * 评论人id
     */
    private Integer userId;
    /**
     * 评论人名
     */
    private String userName;
    /**
     * 评论人头像
     */
    private String headImg;
    /**
     * 评论内容
     */
    private String reviewContent;
    /**
     * 评论的评论内容
     */
    private List<ReviewPlus> reviewPlusList;

    public Review() {
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getReviewedMessageId() {
        return reviewedMessageId;
    }

    public void setReviewedMessageId(Integer reviewedMessageId) {
        this.reviewedMessageId = reviewedMessageId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public List<ReviewPlus> getReviewPlusList() {
        return reviewPlusList;
    }

    public void setReviewPlusList(List<ReviewPlus> reviewPlusList) {
        this.reviewPlusList = reviewPlusList;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", reviewedMessageId=" + reviewedMessageId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", headImg='" + headImg + '\'' +
                ", reviewContent='" + reviewContent + '\'' +
                ", reviewPlusList=" + reviewPlusList +
                '}';
    }
}
