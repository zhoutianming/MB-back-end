package com.ztm.messageboard.entity;

import org.springframework.web.multipart.MultipartFile;

public class MessageVO {
    /**
     * 留言id
     */
    private Long messageId;
    /**
     * 留言人名
     */
    private String userName;
    /**
     * 留言内容
     */
    private String messageContent;
    /**
     * 留言图片宽
     */
    private Integer imageWidth;
    /**
     * 留言图片高
     */
    private Integer imageHeight;
    /**
     * 留言图片
     */
    private MultipartFile image;

    /**
     * 留言人id
     */
    private Integer userId;
    /**
     * 留言时间
     */
    private String time;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 留言标签
     */
    private String messageTabs;

    public MessageVO() {
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getMessageTabs() {
        return messageTabs;
    }

    public void setMessageTabs(String messageTabs) {
        this.messageTabs = messageTabs;
    }


    @Override
    public String toString() {
        return "MessageVO{" +
                "messageId=" + messageId +
                ", userName='" + userName + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", imageWidth=" + imageWidth +
                ", imageHeight=" + imageHeight +
                ", image=" + image +
                ", userId=" + userId +
                ", time='" + time + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", messageTabs='" + messageTabs + '\'' +
                '}';
    }
}
