package com.o2o.service;

import com.o2o.dto.ImageHolder;
import com.o2o.dto.ProductException;
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
     * @param productImgList
     * @return
     * @throws ProductOperationException
     */
    ProductException addProduct(Product product, CommonsMultipartFile thumbnail, List<CommonsMultipartFile> productImgHolderList)
            throws ProductOperationException;
}
