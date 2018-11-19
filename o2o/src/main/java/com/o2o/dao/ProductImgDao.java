package com.o2o.dao;

import com.o2o.entity.ProductImg;

import java.util.List;

/**
 * @Auther: yzy
 * @Date: 2018/11/19 16:17
 * @Description:
 */
public interface ProductImgDao {
    /**
     * 批量插入商品详情图片
     *
     * @param productList
     * @return
     */
    int batchInsertProductImg(List<ProductImg> productList);
}
