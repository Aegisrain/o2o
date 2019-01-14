package com.o2o.service;

import com.o2o.dto.ProductExecution;
import com.o2o.entity.Product;
import com.o2o.exceptions.ProductOperationException;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

/**
 * @Auther: yzy
 * @Date: 2018/11/19 16:52
 * @Description:
 */
public interface ProductService {
    /**
     * 添加商品信息及图片处理
     *
     * @param product
     * @param thumbnail
     * @param productImgHolderList
     * @return
     * @throws ProductOperationException
     */
    ProductExecution addProduct(Product product, CommonsMultipartFile thumbnail,
                                List<CommonsMultipartFile> productImgHolderList)
            throws ProductOperationException;

    /**
     * 通过productId得到商品
     *
     * @param productId
     * @return
     */
    Product getProductById(long productId);

    /**
     * 修改商品信息以及图片处理
     *
     * @param product
     * @param thumbnail
     * @param productImgList
     * @return
     * @throws ProductOperationException
     */
    ProductExecution modifyProduct(Product product, CommonsMultipartFile thumbnail,
                                   List<CommonsMultipartFile> productImgList)
            throws ProductOperationException;

    /**
     * 查询商品列表并分页，可输入的条件有：商品名（模糊），商品状态，店铺ID，商品类别
     * @param productCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);
}
