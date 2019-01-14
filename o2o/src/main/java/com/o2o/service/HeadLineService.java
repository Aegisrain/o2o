package com.o2o.service;

import com.o2o.entity.HeadLine;

import java.io.IOException;
import java.util.List;

/**
 * @Auther: yzy
 * @Date: 2018/11/21 14:54
 * @Description:
 */
public interface HeadLineService {
    /**
     * 根据传入的条件返回指定的头条列表
     *
     * @param headLineCondition
     * @return
     * @throws IOException
     */
    List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws IOException;
}
