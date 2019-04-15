package com.ztm.messageboard.entity;

public class Content {
    /**
     * 留言id
     */
    private Long messageId;
    /**
     * 留言内容
     */
    private String messageContent;
    /**
     * 留言图片
     */
    private String messageImg;
    /**
     * 留言图片宽
     */
    private Integer imageWidth;
    /**
     * 留言图片高
     */
    private Integer imageHeight;
    /**
     * 点赞数
     */
    private Long praisePoint;
    /**
     * 收藏数
     */
    private Long collectionNumber;
    /**
     * 评论数
     */
    private Long reviewNumber;
    /**
     * 浏览量
     */
    private Long pageViews;
    /**
     * 留言时间
     */
    private String time;
    /**
     * 留言人id
     */
    private Integer userId;
    /**
     * 留言人名
     */
    private String userName;
    /**
     * 留言人头像
     */
    private String headImg;
    /**
     * 是否点赞过
     */
    private String isPraise;
    /**
     * 是否收藏过
     */
    private String isCollection;

    public Content() {
        this.isPraise = "#ffffff";
        this.isCollection = "#ffffff";
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageImg() {
        return messageImg;
    }

    public void setMessageImg(String messageImg) {
        this.messageImg = messageImg;
    }

    public Integer getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(Integer imageWidth) {
        this.imageWidth = imageWidth;
    }

    public Integer getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(Integer imageHeight) {
        this.imageHeight = imageHeight;
    }

    public Long getPraisePoint() {
        return praisePoint;
    }

    public void setPraisePoint(Long praisePoint) {
        this.praisePoint = praisePoint;
    }

    public Long getCollectionNumber() {
        return collectionNumber;
    }

    public void setCollectionNumber(Long collectionNumber) {
        this.collectionNumber = collectionNumber;
    }

    public Long getReviewNumber() {
        return reviewNumber;
    }

    public void setReviewNumber(Long reviewNumber) {
        this.reviewNumber = reviewNumber;
    }

    public Long getPageViews() {
        return pageViews;
    }

    public void setPageViews(Long pageViews) {
        this.pageViews = pageViews;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public String getIsPraise() {
        return isPraise;
    }

    public void setIsPraise(String isPraise) {
        this.isPraise = isPraise;
    }

    public String getIsCollection() {
        return isCollection;
    }

    public void setIsCollection(String isCollection) {
        this.isCollection = isCollection;
    }

    @Override
    public String toString() {
        return "Content{" +
                "messageId=" + messageId +
                ", messageContent='" + messageContent + '\'' +
                ", messageImg='" + messageImg + '\'' +
                ", imageWidth=" + imageWidth +
                ", imageHeight=" + imageHeight +
                ", praisePoint=" + praisePoint +
                ", collectionNumber=" + collectionNumber +
                ", reviewNumber=" + reviewNumber +
                ", pageViews=" + pageViews +
                ", time='" + time + '\'' +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", headImg='" + headImg + '\'' +
                ", isPraise='" + isPraise + '\'' +
                ", isCollection='" + isCollection + '\'' +
                '}';
    }
}
