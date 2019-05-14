package com.ztm.messageboard.entity;

import org.springframework.web.multipart.MultipartFile;

public class UserHead {
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户旧头像
     */
    private String oldHeadImg;
    /**
     * 用户头像
     */
    private MultipartFile headImg;

    public UserHead() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOldHeadImg() {
        return oldHeadImg;
    }

    public void setOldHeadImg(String oldHeadImg) {
        this.oldHeadImg = oldHeadImg;
    }

    public MultipartFile getHeadImg() {
        return headImg;
    }

    public void setHeadImg(MultipartFile headImg) {
        this.headImg = headImg;
    }

    @Override
    public String toString() {
        return "UserHead{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", oldHeadImg='" + oldHeadImg + '\'' +
                ", headImg=" + headImg +
                '}';
    }
}
