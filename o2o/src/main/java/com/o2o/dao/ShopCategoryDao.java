package com.o2o.dao;

import com.o2o.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: yzy
 * @Date: 2018/10/12 14:00
 * @Description:
 */
public interface ShopCategoryDao {
    List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategory);
}
