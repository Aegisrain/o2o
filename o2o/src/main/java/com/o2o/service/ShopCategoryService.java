package com.o2o.service;

import com.o2o.entity.ShopCategory;

import java.util.List;

/**
 * @Auther: yzy
 * @Date: 2018/10/12 14:30
 * @Description:
 */
public interface ShopCategoryService {
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
