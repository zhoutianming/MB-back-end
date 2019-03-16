package com.ztm.messageboard.entity;

public class UserDO {
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
     * 用户类型
     */
    private Integer type;

    /**
     * 用户头像
     */
    private String headImg;

    /**
     * 用户签名
     */
    private String writed;


    public UserDO() {
    }

    public UserDO(Integer id, String userName, String password, Integer type, String headImg, String writed) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.type = type;
        this.headImg = headImg;
        this.writed = writed;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getWrited() {
        return writed;
    }

    public void setWrited(String writed) {
        this.writed = writed;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", headImg='" + headImg + '\'' +
                ", writed='" + writed + '\'' +
                '}';
    }
}
