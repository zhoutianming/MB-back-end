package com.ztm.messageboard.entity;

public class CarePersonDO {
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 关注的人id
     */
    private Integer carePersonId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCarePersonId() {
        return carePersonId;
    }

    public void setCarePersonId(Integer carePersonId) {
        this.carePersonId = carePersonId;
    }

    @Override
    public String toString() {
        return "CarePersonDO{" +
                "userId=" + userId +
                ", carePersonId='" + carePersonId + '\'' +
                '}';
    }
}
