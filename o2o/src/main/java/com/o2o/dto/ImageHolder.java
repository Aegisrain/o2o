package com.o2o.dto;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.InputStream;

/**
 * @Auther: yzy
 * @Date: 2018/11/19 18:43
 * @Description:
 */
public class ImageHolder {
    //图片名字
    private String imageName;
    //图片流
    private CommonsMultipartFile image;

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public CommonsMultipartFile getImage() {
        return image;
    }

    public void setImage(CommonsMultipartFile image) {
        this.image = image;
    }

    public ImageHolder(String imageName, CommonsMultipartFile image) {
        this.imageName = imageName;
        this.image = image;
    }
}
