package com.o2o.dao;

import com.o2o.BaseTest;
import com.o2o.entity.HeadLine;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: yzy
 * @Date: 2018/11/21 14:47
 * @Description:
 */
public class HeadLineDaoTest extends BaseTest {
    @Autowired
    private HeadLineDao headLineDao;

    @Test
    public void queryHeadLine() {
        HeadLine headLineCondition = new HeadLine();
        List<HeadLine> headLineList = headLineDao.queryHeadLine(headLineCondition);
        System.out.println(headLineList.size());
    }
}