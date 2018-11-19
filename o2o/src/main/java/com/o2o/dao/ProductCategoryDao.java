package com.o2o.dao;

import com.o2o.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: yzy
 * @Date: 2018/11/17 20:13
 * @Description:
 */
public interface ProductCategoryDao {
    /**
     * 根据shopId查询店铺商品类别
     *
     * @param shopId
     * @return
     */
    List<ProductCategory> queryProductCategory(long shopId);

    /**
     * 批量添加商品类别
     *
     * @param productCategoryList
     * @return
     */
    int batchInsertProductCategory(List<ProductCategory> productCategoryList);

    /**
     * 删除指定商品类别
     * @param productCategroyId
     * @param shopId
     * @return
     */
    int deleteProductCategory(@Param("productCategoryId") long productCategroyId,
                              @Param("shopId") long shopId);
}
