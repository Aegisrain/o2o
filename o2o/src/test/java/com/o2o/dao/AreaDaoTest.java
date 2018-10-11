package com.o2o.dao;

import com.o2o.BaseTest;
import com.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: yzy
 * @Date: 2018/10/10 21:09
 * @Description:
 */
public class AreaDaoTest extends BaseTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    public void queryArea() {
        List<Area> areaList = areaDao.queryArea();
        for(Area area : areaList) {
            System.out.println(area);
        }
    }
}