package com.jxut.feiyi.mapper;

import com.jxut.feiyi.entity.OrderCollect;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderCollectMapper {
    int deleteByPrimaryKey(Integer collectId);

    int insert(OrderCollect record);

    int insertSelective(OrderCollect record);

    OrderCollect selectByPrimaryKey(Integer collectId);

    int updateByPrimaryKeySelective(OrderCollect record);

    int updateByPrimaryKey(OrderCollect record);

    List<OrderCollect> selectCollectByCId(Integer cid);
}