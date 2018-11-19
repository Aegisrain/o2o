package com.o2o.dto;

import com.o2o.entity.Product;
import com.o2o.enums.ProductStateEnum;

import java.util.List;

/**
 * @Auther: yzy
 * @Date: 2018/11/19 16:54
 * @Description:封装商品信息以及状态信息
 */
public class ProductException {
    //结果状态
    private int state;

    //状态标识
    private String stateInfo;

    //商品数量
    private int count;

    //操作的product
    private Product product;

    //获取product列表
    private List<Product> productList;

    public ProductException() {

    }

    //失败时调用的构造器
    public ProductException(ProductStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    //成功时调用的构造器(针对单个添加)
    public ProductException(ProductStateEnum stateEnum, Product product) {
        this.stateInfo = stateEnum.getStateInfo();
        this.state = stateEnum.getState();
        this.product = product;
    }

    //成功时调用的构造器(针对多个添加)
    public ProductException(ProductStateEnum stateEnum, List<Product> productList) {
        this.stateInfo = stateEnum.getStateInfo();
        this.state = stateEnum.getState();
        this.productList = productList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
