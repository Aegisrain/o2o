package com.o2o.service.impl;

import com.o2o.dao.AreaDao;
import com.o2o.entity.Area;
import com.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yzy
 * @Date: 2018/10/10 21:23
 * @Description: AreaService的实现类
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
