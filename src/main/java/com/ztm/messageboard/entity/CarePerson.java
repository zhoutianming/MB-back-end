package com.ztm.messageboard.entity;

public class CarePerson {
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户头像
     */
    private String headImg;
    /**
     * 用户关注度
     */
    private Long beCaredNum;
    /**
     * 用户点赞数
     */
    private Long praisedNum;

    public CarePerson() {
        this.beCaredNum = 0L;
        this.praisedNum = 0L;
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

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
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

    @Override
    public String toString() {
        return "CarePerson{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", headImg='" + headImg + '\'' +
                ", beCaredNum=" + beCaredNum +
                ", praisedNum=" + praisedNum +
                '}';
    }
}
