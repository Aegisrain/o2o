package com.o2o.dao;

import com.o2o.entity.Area;

import java.util.List;

/**
 * @Auther: yzy
 * @Date: 2018/10/10 20:57
 * @Description:
 */
public interface AreaDao {
    /**
     * 列出区域列表
     * @return areaList
     */
    List<Area> queryArea();
}
