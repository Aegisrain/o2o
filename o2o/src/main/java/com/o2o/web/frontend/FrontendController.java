package com.o2o.web.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: yzy
 * @Date: 2019/1/12 13:21
 * @Description: 定义各页面路由
 */
@Controller
@RequestMapping("/frontend")
public class FrontendController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    private String index() {
        return "frontend/index";
    }

    @RequestMapping(value = "/shoplist", method = RequestMethod.GET)
    private String shopList() {
        return "frontend/shoplist";
    }

    @RequestMapping(value = "/shopdetail", method = RequestMethod.GET)
    private String shopdetail() {
        return "frontend/shopdetail";
    }
}
