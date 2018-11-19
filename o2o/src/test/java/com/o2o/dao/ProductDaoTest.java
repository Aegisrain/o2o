package com.o2o.dao;

import com.o2o.BaseTest;
import com.o2o.entity.Product;
import com.o2o.entity.ProductCategory;
import com.o2o.entity.Shop;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Auther: yzy
 * @Date: 2018/11/19 16:33
 * @Description:
 */
public class ProductDaoTest extends BaseTest {

    @Autowired
    private ProductDao productDao;

    @Test
    public void insertProduct() {
        Product product = new Product();
        product.setProductName("test product");
        product.setProductDesc("test");
        product.setCreateTime(new Date());
        product.setEnableStatus(1);
        product.setImgAddr("图片test");
        product.setLastEditTime(new Date());
        product.setNormalPrice("100");
        product.setPromotionPrice("70");
        product.setPriority(15);
        Shop shop = new Shop();
        shop.setShopId(1l);
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryId(2l);
        product.setShop(shop);
        product.setProductCategory(productCategory);
        int effectNum = productDao.insertProduct(product);
        System.out.println(effectNum);
    }
}