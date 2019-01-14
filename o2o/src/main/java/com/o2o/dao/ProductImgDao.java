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

    /**
     * 根据productId删除该商品下的所有详情图
     *
     * @param productId
     * @return
     */
    int deleteProductImgById(long productId);

    /**
     * 根据productId获取商品图片列表
     * @param productId
     * @return
     */
    List<ProductImg> queryProductImgList(long productId);
}
