package com.o2o.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: yzy
 * @Date: 2018/10/12 12:54
 * @Description:主要用来解析路由并转发到相应的html页面中
 */
@Controller
@RequestMapping(value = "/shopadmin", method = {RequestMethod.GET})
public class ShopAdminController {

    @RequestMapping(value = "/shopoperation")
    public String shopOperation() {
        return "shop/shopoperation";
    }

    @RequestMapping(value = "/shoplist")
    public String shopList() {
        return "shop/shoplist";
    }

    @RequestMapping(value = "/shopmanagement")
    public String shopManagement() {
        return "shop/shopmanagement";
    }

    @RequestMapping(value = "/productcategorymanage")
    public String ProductCategoryManage() {
        return "shop/productcategorymanage";
    }

    @RequestMapping(value = "/productoperation")
    public String productOperation() {
        return "shop/productoperation";
    }

    @RequestMapping(value = "/productmanagement")
    public String productManagement() {
        return "shop/productmanagement";
    }
}
