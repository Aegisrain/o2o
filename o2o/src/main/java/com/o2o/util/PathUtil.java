package com.o2o.util;

/**
 * @Auther: yzy
 * @Date: 2018/10/11 13:44
 * @Description:路径处理
 */
public class PathUtil {
    //获取当前操作系统文件的分隔符
    private static String seperator = System.getProperty("file.separator");

    //返回图片根路径
    public static String getImgBasePath() {
        //获取当前操作系统的名称
        String os = System.getProperty("os.name");
        String basePath = "";
        //根据用户的系统设置保存路径
        if (os.toLowerCase().startsWith("win")) {
            basePath = "E:/image";
        } else {
            basePath = "/home/yzy/image/";
        }
        //转换成当前操作系统使用的分隔符
        basePath = basePath.replace("/", seperator);
        return basePath;
    }

    //返回图片子路径
    public static String getShopImagePath(long shopId) {
        String imagePath = "/upload/item/shop/" + shopId + "/";
        return imagePath.replace("/", seperator);
    }
}
