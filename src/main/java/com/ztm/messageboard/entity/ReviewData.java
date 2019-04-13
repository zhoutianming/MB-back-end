package com.ztm.messageboard.entity;

public class ReviewData {
    /**
     * 评论id
     */
    private Integer reviewId;
    /**
     * 评论人名
     */
    private String userName;
    /**
     * 被评论内容
     */
    private String reviewedContent;
    /**
     * 评论内容
     */
    private String reviewContent;

    public ReviewData() {
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReviewedContent() {
        return reviewedContent;
    }

    public void setReviewedContent(String reviewedContent) {
        this.reviewedContent = reviewedContent;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    @Override
    public String toString() {
        return "ReviewData{" +
                "reviewId=" + reviewId +
                ", userName='" + userName + '\'' +
                ", reviewedContent='" + reviewedContent + '\'' +
                ", reviewContent='" + reviewContent + '\'' +
                '}';
    }
}
