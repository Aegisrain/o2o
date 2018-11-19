package com.o2o.dao;

import com.o2o.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: yzy
 * @Date: 2018/11/19 16:13
 * @Description:
 */
public interface ProductDao {

    /**
     * 插入商品
     * @param product
     * @return
     */
    int insertProduct(Product product);
}
