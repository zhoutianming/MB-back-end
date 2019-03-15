package com.ztm.messageboard.entity;

public class ReviewDO {
    /**
     * 评论id
     */
    private Integer reviewId;

    /**
     * 评论人id
     */
    private Integer userId;

    /**
     * 评论内容
     */
    private String reviewContent;

    /**
     * 被评论的留言id
     */
    private Integer reviewedMessageId;

    public ReviewDO() {
    }

    public ReviewDO(Integer reviewId, Integer userId, String reviewContent, Integer reviewedMessageId) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.reviewContent = reviewContent;
        this.reviewedMessageId = reviewedMessageId;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public Integer getReviewedMessageId() {
        return reviewedMessageId;
    }

    public void setReviewedMessageId(Integer reviewedMessageId) {
        this.reviewedMessageId = reviewedMessageId;
    }

    @Override
    public String toString() {
        return "ReviewDO{" +
                "reviewId=" + reviewId +
                ", userId=" + userId +
                ", reviewContent='" + reviewContent + '\'' +
                ", reviewedMessageId=" + reviewedMessageId +
                '}';
    }
}
