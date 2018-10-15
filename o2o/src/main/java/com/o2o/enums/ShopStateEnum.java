package com.o2o.enums;

/**
 * @Auther: yzy
 * @Date: 2018/10/11 14:44
 * @Description:店铺状态枚举类
 */
public enum ShopStateEnum {
    CHECk(0, "审核中"), OFFLINE(-1, "非法店铺"), SUCCESS(1, "操作成功"), PASS(2, "通过认证"),
    INNER_ERROR(-1001, "内部系统错误"), NULL_SHOPID(-1002, "ShopId为空"), NULL_SHOP(-1003, "shop信息为空");
    private int state;
    private String stateInfo;

    private ShopStateEnum(int state, String sateInfo) {
        this.state = state;
        this.stateInfo = sateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    /**
     * 根据传入的state返回相应的enum值
     */
    public static ShopStateEnum stateOf(int state) {
        for (ShopStateEnum shopStateEnum : values()) {
            if (shopStateEnum.getState() == state) {
                return shopStateEnum;
            }
        }
        return null;
    }
}
