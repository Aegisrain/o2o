package com.o2o.util;

/**
 * @Auther: yzy
 * @Date: 2018/11/15 16:16
 * @Description: rowIndex的转换
 */
public class PageCalculator {
    public static int calculatorRowIndex(int pageIndex, int pageSize) {
        return (pageIndex > 0) ? (pageIndex - 1) * pageSize : 0;
    }
}
