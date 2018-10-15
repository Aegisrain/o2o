package com.o2o.service;

import com.o2o.dto.ShopExecution;
import com.o2o.entity.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


/**
 * @Auther: yzy
 * @Date: 2018/10/11 15:05
 * @Description:
 */

public interface ShopService {
    ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg);
}
