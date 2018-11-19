package com.o2o.service.impl;

import com.o2o.dao.ProductDao;
import com.o2o.dao.ProductImgDao;
import com.o2o.dto.ImageHolder;
import com.o2o.dto.ProductException;
import com.o2o.entity.Product;
import com.o2o.entity.ProductImg;
import com.o2o.enums.ProductStateEnum;
import com.o2o.exceptions.ProductOperationException;
import com.o2o.service.ProductService;
import com.o2o.util.ImageUtil;
import com.o2o.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: yzy
 * @Date: 2018/11/19 17:07
 * @Description:
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductImgDao productImgDao;

    @Override
    @Transactional
    /**
     * 1.处理缩略图，获取缩略图相对路径并赋值给product
     * 2.往tb_product写入商品信息，获取productId
     * 3.结合productId批量处理商品详情图
     * 4.将商品详情图列表批量插入tb_product_img中
     */
    public ProductException addProduct(Product product, CommonsMultipartFile thumbnail,
                                       List<CommonsMultipartFile> productImgHolderList)
            throws ProductOperationException {
        //空值判断
        if (product != null && product.getShop() != null && product.getShop().getShopId() != null) {
            //给商品设置上默认属性
            product.setCreateTime(new Date());
            product.setLastEditTime(new Date());
            //设置默认上架状态
            product.setEnableStatus(1);
            //若商品缩略图不为空则添加
            if (thumbnail != null) {
                addThumbnail(product, thumbnail);
            }
            try {
                //创建商品信息
                int effectNum = productDao.insertProduct(product);
                if (effectNum < 0) {
                    throw new ProductOperationException("创建商品失败！");
                }
            } catch (Exception e) {
                throw new ProductOperationException("创建商品失败：" + e.getMessage());
            }
            //若商品详情图不为空则添加
            if (productImgHolderList != null) {
                addProductImgList(product, productImgHolderList);
            }
            return new ProductException(ProductStateEnum.SUCCESS);
        } else {
            //传参为空则返回空值错误信息
            return new ProductException(ProductStateEnum.EMPTY);
        }
    }

    /**
     * 批量添加图片
     *
     * @param product
     * @param productImgHolderList
     */
    private void addProductImgList(Product product, List<CommonsMultipartFile> productImgHolderList) {
        //获取图片存储路径，这里直接存放都相应店铺的w文件夹底下
        String dest = PathUtil.getShopImagePath(product.getShop().getShopId());
        List<ProductImg> productImgList = new ArrayList<ProductImg>();
        //遍历图片，一次处理，并添加进productImg实体类里
        for (CommonsMultipartFile productImgHolder : productImgHolderList) {
            String imgAddr = ImageUtil.generateNormalImg(productImgHolder, dest);
            ProductImg productImg = new ProductImg();
            productImg.setImgAddr(imgAddr);
            product.setProductId(product.getProductId());
            product.setCreateTime(new Date());
            productImgList.add(productImg);
        }
        //如果确实是有图片需要添加，就执行批量添加操作
        if (productImgList.size() > 0) {
            try {
                int effectNum = productImgDao.batchInsertProductImg(productImgList);
                if (effectNum <= 0) {
                    throw new ProductOperationException("创建商品详情图片失败");
                }
            } catch (Exception e) {
                throw new ProductOperationException("创建商品详情图片失败：" + e.toString());
            }
        }
    }

    /**
     * 添加缩略图
     *
     * @param product
     * @param thumbnail
     */
    private void addThumbnail(Product product, CommonsMultipartFile thumbnail) {
        String dest = PathUtil.getShopImagePath(product.getShop().getShopId());
        String thumbnailAddr = ImageUtil.generateThumbnail(thumbnail, dest);
        product.setImgAddr(thumbnailAddr);
    }
}
