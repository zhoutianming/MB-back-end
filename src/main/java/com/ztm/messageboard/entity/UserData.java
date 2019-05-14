package com.ztm.messageboard.entity;

public class UserData {
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
     * 用户关注的人数
     */
    private Long carePersonNum;
    /**
     * 用户个人收藏数
     */
    private Long collectionNum;
    /**
     * 用户关注度
     */
    private Long beCaredNum;
    /**
     * 用户点赞数
     */
    private Long praisedNum;
    /**
     * 用户点赞列表
     */
    private String praiseList;
    /**
     * 被点赞用户id
     */
    private Integer praisedUserId;
    /**
     * 点赞涨幅数
     */
    private Long praiseAdditions;
    /**
     * 关注涨幅数
     */
    private Long caredAdditions;

    public UserData() {
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

    public Long getCarePersonNum() {
        return carePersonNum;
    }

    public void setCarePersonNum(Long carePersonNum) {
        this.carePersonNum = carePersonNum;
    }

    public Long getCollectionNum() {
        return collectionNum;
    }

    public void setCollectionNum(Long collectionNum) {
        this.collectionNum = collectionNum;
    }

    public Long getBeCaredNum() {
        return beCaredNum;
    }

    public void setBeCaredNum(Long beCaredNum) {
        this.beCaredNum = beCaredNum;
    }

    public Long getPraisedNum() {
        return praisedNum;
    }

    public void setPraisedNum(Long praisedNum) {
        this.praisedNum = praisedNum;
    }

    public String getPraiseList() {
        return praiseList;
    }

    public void setPraiseList(String praiseList) {
        this.praiseList = praiseList;
    }

    public Integer getPraisedUserId() {
        return praisedUserId;
    }

    public void setPraisedUserId(Integer praisedUserId) {
        this.praisedUserId = praisedUserId;
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
        return "UserData{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", headImg='" + headImg + '\'' +
                ", carePersonNum=" + carePersonNum +
                ", collectionNum=" + collectionNum +
                ", beCaredNum=" + beCaredNum +
                ", praisedNum=" + praisedNum +
                ", praiseList='" + praiseList + '\'' +
                ", praisedUserId=" + praisedUserId +
                ", praiseAdditions=" + praiseAdditions +
                ", caredAdditions=" + caredAdditions +
                '}';
    }
}
