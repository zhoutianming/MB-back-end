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
     * 用户点赞列表
     */
    private String praiseList;
    /**
     * 点赞涨幅数
     */
    private Long praiseAdditions;
    /**
     * 关注涨幅数
     */
    private Long caredAdditions;

    public UserDO() {
        this.praiseAdditions = 0L;
        this.caredAdditions = 0L;
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

    public String getPraiseList() {
        return praiseList;
    }

    public void setPraiseList(String praiseList) {
        this.praiseList = praiseList;
    }

    public Long getPraiseAdditions() {
        return praiseAdditions;
    }

    public void setPraiseAdditions(Long praiseAdditions) {
        this.praiseAdditions = praiseAdditions;
    }

    public Long getCaredAdditions() {
        return caredAdditions;
    }

    public void setCaredAdditions(Long caredAdditions) {
        this.caredAdditions = caredAdditions;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", headImg='" + headImg + '\'' +
                ", praiseList='" + praiseList + '\'' +
                ", praiseAdditions=" + praiseAdditions +
                ", caredAdditions=" + caredAdditions +
                '}';
    }
}
