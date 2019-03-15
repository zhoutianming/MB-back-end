package com.ztm.messageboard.entity;

public class MessageDO {
    /**
     * 留言id
     */
    private Long messageId;
    /**
     * 留言内容
     */
    private String messageContent;
    /**
     * 留言人id
     */
    private Integer userId;

    /**
     * 留言图片
     */
    private String messageImg;

    /**
     * 点赞数
     */
    private Long praisePoint;
    /**
     * 收藏数
     */
    private Long collectionNumber;
    /**
     * 浏览量
     */
    private Long pageViews;
    /**
     * 留言时间
     */
    private String time;


    public MessageDO() {
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMessageImg() {
        return messageImg;
    }

    public void setMessageImg(String messageImg) {
        this.messageImg = messageImg;
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

}
