package com.o2o.dao;

import com.o2o.entity.HeadLine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: yzy
 * @Date: 2018/11/21 14:42
 * @Description:
 */
public interface HeadLineDao {
    /**
     * 根据传入的条件返回指定的头条列表
     *
     * @param headLineCondition
     * @return
     */
    List<HeadLine> queryHeadLine(@Param("headLineCondition") HeadLine headLineCondition);
}
