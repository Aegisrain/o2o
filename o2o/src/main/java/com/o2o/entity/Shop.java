package com.o2o.entity;

import java.util.Date;


/**
 * 店家实体类
 */
public class Shop {
    //商品ID
    private Long shopId;
    //商品名称
    private String shopName;
    //商品描述
    private String shopDesc;
    //商品地址
    private String shopAddr;
    //电话
    private String phone;
    //商品图片
    private String shopImd;
    //权重
    private Integer priority;
    //创建时间
    private Date createTime;
    //更新时间
    private Date lastEditTime;
    //状态 -1:不可用  0：审核中  1：可用
    private Integer enableStatus;
    //建议（管理员给店家）
    private String advice;
    private Area area;
    private PersonInfo personInfo;
    private ShopCategory shopCategory;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopDesc() {
        return shopDesc;
    }

    public void setShopDesc(String shopDesc) {
        this.shopDesc = shopDesc;
    }

    public String getShopAddr() {
        return shopAddr;
    }

    public void setShopAddr(String shopAddr) {
        this.shopAddr = shopAddr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getShopImd() {
        return shopImd;
    }

    public void setShopImd(String shopImd) {
        this.shopImd = shopImd;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    public ShopCategory getShopCategory() {
        return shopCategory;
    }

    public void setShopCategory(ShopCategory shopCategory) {
        this.shopCategory = shopCategory;
    }
}
