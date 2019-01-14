package com.o2o.dao;

import com.o2o.BaseTest;
import com.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: yzy
 * @Date: 2018/10/12 14:10
 * @Description:
 */
public class ShopCategoryDaoTest extends BaseTest {

    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Test
    public void queryShopCategory() {
        List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(null);
        System.out.println(shopCategoryList.get(2).getShopCategoryImg());
//        ShopCategory testCategory = new ShopCategory();
//        ShopCategory parentCategory = new ShopCategory();
//        parentCategory.setShopCategoryId(1l);
//        testCategory.setParent(parentCategory);
//        shopCategoryList = shopCategoryDao.queryShopCategory(testCategory);
//        System.out.println(shopCategoryList.get(0).getShopCategoryName());
    }
}