package com.o2o.service.impl;

import com.o2o.dao.ShopCategoryDao;
import com.o2o.entity.ShopCategory;
import com.o2o.service.ShopCtegoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yzy
 * @Date: 2018/10/12 14:31
 * @Description:
 */
@Service
public class ShopCategoryServiceImpl implements ShopCtegoryService {

    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Override
    public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
        return shopCategoryDao.queryShopCategory(shopCategoryCondition);
    }
}
