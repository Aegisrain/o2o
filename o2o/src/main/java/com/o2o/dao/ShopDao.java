package com.o2o.dao;

import com.o2o.entity.Shop;

/**
 * @Auther: yzy
 * @Date: 2018/10/11 12:18
 * @Description:店家接口
 */
public interface ShopDao {
    /**
     * 新增店铺
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺信息
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
}
