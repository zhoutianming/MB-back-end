package com.ztm.messageboard.entity;

public class ReviewPlus {
    /**
     * 评论id
     */
    private Integer reviewId;
    /**
     * 被评论的评论id
     */
    private Integer reviewedReviewId;
    /**
     * 评论人id
     */
    private Integer userId;
    /**
     * 评论人名
     */
    private String userName;
    /**
     * 评论内容
     */
    private String reviewContent;

    public ReviewPlus() {
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getReviewedReviewId() {
        return reviewedReviewId;
    }

    public void setReviewedReviewId(Integer reviewedReviewId) {
        this.reviewedReviewId = reviewedReviewId;
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

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    @Override
    public String toString() {
        return "ReviewPlus{" +
                "reviewId=" + reviewId +
                ", reviewedReviewId=" + reviewedReviewId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", reviewContent='" + reviewContent + '\'' +
                '}';
    }
}
