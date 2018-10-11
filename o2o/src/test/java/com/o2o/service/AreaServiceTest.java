package com.o2o.service;

import com.o2o.BaseTest;
import com.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: yzy
 * @Date: 2018/10/10 21:26
 * @Description: AreaService的测试
 */
public class AreaServiceTest extends BaseTest {

    @Autowired
    private AreaService areaService;

    @Test
    public void getAreaList() {
        List<Area> areaList = areaService.getAreaList();
        assertEquals("北苑", areaList.get(0).getAreaName());
    }
}