package com.o2o.dao;

import com.o2o.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: yzy
 * @Date: 2018/10/11 12:18
 * @Description:店家接口
 */
public interface ShopDao {
    /**
     * 新增店铺
     *
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺信息
     *
     * @param shop
     * @return
     */
    int updateShop(Shop shop);

    /**
     * 根据shop id 查询店铺
     */
    Shop queryByShopId(long shopId);

    /**
     * 分页查询店铺，可输入的条件有：店铺名（模糊），店铺状态，店铺类别，区域ID，owner
     *
     * @param shopCondition
     * @param rowIndex      从第几行开始取数据
     * @param pageSize      返回的条数
     * @return
     */
    List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition, @Param("rowIndex") int rowIndex,
                             @Param("pageSize") int pageSize);

    /**
     * 获取店铺总数
     * @param shopCoundition
     * @return
     */
    int queryShopCount(@Param("shopCondition") Shop shopCondition);

}
