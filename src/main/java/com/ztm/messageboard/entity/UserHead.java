package com.ztm.messageboard.entity;

import org.springframework.web.multipart.MultipartFile;

public class MessageVO {

    /**
     * 留言内容
     */
    private String messageContent;
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


    public MessageVO() {
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

    @Override
    public String toString() {
        return "MessageVO{" +
                "messageContent='" + messageContent + '\'' +
                ", image=" + image +
                ", userId=" + userId +
                ", time='" + time + '\'' +
                '}';
    }
}
