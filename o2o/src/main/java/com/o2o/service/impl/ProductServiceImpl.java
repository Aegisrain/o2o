package com.o2o.service.impl;

import com.o2o.dao.ProductDao;
import com.o2o.dao.ProductImgDao;
import com.o2o.dto.ProductExecution;
import com.o2o.entity.Product;
import com.o2o.entity.ProductImg;
import com.o2o.enums.ProductStateEnum;
import com.o2o.exceptions.ProductOperationException;
import com.o2o.service.ProductService;
import com.o2o.util.ImageUtil;
import com.o2o.util.PageCalculator;
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

    /**
     * 添加商品
     * 1.处理缩略图，获取缩略图相对路径并赋值给product
     * 2.往tb_product写入商品信息，获取productId
     * 3.结合productId批量处理商品详情图
     * 4.将商品详情图列表批量插入tb_product_img中
     */
    @Override
    @Transactional
    public ProductExecution addProduct(Product product, CommonsMultipartFile thumbnail,
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
            return new ProductExecution(ProductStateEnum.SUCCESS);
        } else {
            //传参为空则返回空值错误信息
            return new ProductExecution(ProductStateEnum.EMPTY);
        }
    }

    /**
     * 通过productId查询商品
     *
     * @param productId
     * @return
     */
    @Override
    public Product getProductById(long productId) {
        return productDao.queryProductById(productId);
    }

    /**
     * 修改商品信息
     * 1.若缩略图参数有值，则处理缩略图
     * a.若原先存在缩略图则先删除在添加新图
     * b.然后获取缩略图相对路径并赋值给product
     * 2.若商品详情列表参数有值，对商品详情图片列表进行同样的操作
     * 3.将tb_product_img下面的该商品原来的商品详情图全部删除
     * 4.更新tb_product和tb_product_img的信息。
     *
     * @param product
     * @param thumbnail
     * @param productImgList
     * @return
     * @throws ProductOperationException
     */
    @Override
    @Transactional
    public ProductExecution modifyProduct(Product product, CommonsMultipartFile thumbnail,
                                          List<CommonsMultipartFile> productImgList)
            throws ProductOperationException {
        //空值判断
        if (product != null && product.getShop() != null && product.getShop().getShopId() != null) {
            //给商品设置上默认属性
            product.setLastEditTime(new Date());
            //若缩略图thumbnail不为空，且原缩略图不为空则删除原有的在添加
            if (thumbnail != null) {
                //先获取原有商品信息
                Product tempProduct = productDao.queryProductById(product.getProductId());
                if (tempProduct.getImgAddr() != null) {
                    //删除原有的缩略图
                    ImageUtil.deleteFileOrPath(tempProduct.getImgAddr());
                }
                //最后添加新的缩略图信息
                addThumbnail(product, thumbnail);
            }

            //若有新存入的商品详情图，则将原先的删除，再添加新的
            if (productImgList != null && productImgList.size() > 0) {
                deleteProductImgList(product.getProductId());
                addProductImgList(product, productImgList);
            }

            try {
                //更新商品信息
                int effectedNum = productDao.updateProduct(product);
                if (effectedNum < 0) {
                    throw new ProductOperationException("商品信息更新失败！");
                }
                return new ProductExecution(ProductStateEnum.SUCCESS, product);
            } catch (ProductOperationException e) {
                throw new ProductOperationException("商品信息更新失败:" + e.getMessage());
            }
        } else {
            return new ProductExecution(ProductStateEnum.EMPTY);
        }
    }

    /**
     * 查询商品列表并分页，可输入的条件有：商品名（模糊），商品状态，店铺ID，商品类别
     *
     * @param productCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize) {
        //页码转换成数据库的代码，并调用dao层取回指定页码的商品列表
        int rowIndex = PageCalculator.calculatorRowIndex(pageIndex, pageSize);
        List<Product> productList = productDao.queryProductList(productCondition, pageIndex, pageSize);
        //基于同样的查询条件返回该查询条件下的商品总数
        int count = productDao.queryProductCount(productCondition);
        ProductExecution pe = new ProductExecution();
        pe.setProductList(productList);
        pe.setCount(count);
        return pe;
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

    /**
     * 删除某个商品下的所有详情图
     *
     * @param productId
     */
    private void deleteProductImgList(Long productId) {
        //根据productId获取原来的图片
        List<ProductImg> productImgList = productImgDao.queryProductImgList(productId);
        //删除原来的图片
        for (ProductImg productImg : productImgList) {
            ImageUtil.deleteFileOrPath(productImg.getImgAddr());
        }
        //删除数据库中原来图片的信息
        productImgDao.deleteProductImgById(productId);
    }
}
