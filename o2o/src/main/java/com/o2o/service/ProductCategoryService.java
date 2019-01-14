package com.o2o.service;

import com.o2o.dto.ProductCategoryExecution;
import com.o2o.entity.ProductCategory;
import com.o2o.exceptions.ProductCategoryOperationException;

import java.util.List;

/**
 * @Auther: yzy
 * @Date: 2018/11/17 20:27
 * @Description:
 */
public interface ProductCategoryService {
    /**
     * 根据shopId得到ProductCategory列表
     *
     * @param shopId
     * @return
     */
    List<ProductCategory> getProductCategoryList(Long shopId);

    /**
     * 批量添加商品类别
     *
     * @param productCategoryList
     * @return
     * @throws ProductCategoryOperationException
     */
    ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
            throws ProductCategoryOperationException;

    /**
     * 删除商品类别
     * @param productCategoryId
     * @param shopId
     * @return
     * @throws ProductCategoryOperationException
     */
    ProductCategoryExecution deleteProductCategroy(long productCategoryId, long shopId)
            throws ProductCategoryOperationException;

}
