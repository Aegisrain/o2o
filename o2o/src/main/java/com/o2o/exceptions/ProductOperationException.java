package com.o2o.exceptions;

/**
 * @Auther: yzy
 * @Date: 2018/11/19 16:53
 * @Description:
 */
public class ProductOperationException extends RuntimeException{
    public ProductOperationException(String msg) {
        super(msg);
    }
}
