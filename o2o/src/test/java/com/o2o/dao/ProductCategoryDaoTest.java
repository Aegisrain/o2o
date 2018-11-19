package com.o2o.dao;

import com.o2o.BaseTest;
import com.o2o.entity.ProductCategory;
import com.sun.org.apache.bcel.internal.generic.POP2;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: yzy
 * @Date: 2018/11/17 20:19
 * @Description:
 */
public class ProductCategoryDaoTest extends BaseTest {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void queryProductCategory() {
        long shopId = 1;
        List<ProductCategory> productCategoryDaoList = productCategoryDao.queryProductCategory(shopId);
        System.out.println("总数：" + productCategoryDaoList.size());
    }

    @Test
    public void batchInsertProductCategory() {
        List<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
        ProductCategory productCategory1 = new ProductCategory();
        productCategory1.setProductCategoryName("test1");
        productCategory1.setCreateTime(new Date());
        productCategory1.setPriority(11);
        productCategory1.setShopId(2l);
        ProductCategory productCategory2 = new ProductCategory();
        productCategory2.setProductCategoryName("test2");
        productCategory2.setCreateTime(new Date());
        productCategory2.setPriority(14);
        productCategory2.setShopId(2l);
        productCategoryList.add(productCategory1);
        productCategoryList.add(productCategory2);

        int effectNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
        System.out.println(effectNum);
    }

    @Test
    public void deleteProductCategory() {
        int effectNum = productCategoryDao.deleteProductCategory(1l, 1l);
        System.out.println(effectNum);
    }
}