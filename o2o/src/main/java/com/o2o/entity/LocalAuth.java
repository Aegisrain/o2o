package com.o2o.entity;

import java.util.Date;

/**
 * 本地账号实体类
 */
public class LocalAuth {
    //本地账号ID
    private Long localAuthId;
    //本地账号用户名
    private String userName;
    //本地账号密码
    private String passWord;
    //本地账号创建时间
    private Date createTime;
    //本地账号更新时间
    private Date lastEditTime;
    //关联用户实体类
    private PersonInfo personInfo;

    public Long getLocalAuthId() {
        return localAuthId;
    }

    public void setLocalAuthId(Long localAuthId) {
        this.localAuthId = localAuthId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }
}
