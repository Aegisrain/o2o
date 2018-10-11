package com.o2o.entity;

import java.util.Date;

/**
 * 微信账号实体类
 */
public class WeChatAuth {
    //ID
    private Long weChatAuthId;
    //openId
    private String openId;
    //创建时间
    private Date createTime;
    //关联用户实体类
    private PersonInfo personInfo;

    public Long getWeChatAuthId() {
        return weChatAuthId;
    }

    public void setWeChatAuthId(Long weChatAuthId) {
        this.weChatAuthId = weChatAuthId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }
}
