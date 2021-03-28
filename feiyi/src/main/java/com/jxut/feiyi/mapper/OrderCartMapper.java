package com.jxut.feiyi.mapper;

import com.jxut.feiyi.entity.OrderCart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderCartMapper {
    int deleteByPrimaryKey(Integer cartId);

    int insert(OrderCart record);

    int insertSelective(OrderCart record);

    OrderCart selectByPrimaryKey(Integer cartId);

    List<OrderCart> selectByCId(Integer customerId);

    int updateByPrimaryKeySelective(OrderCart record);

    int updateByPrimaryKey(OrderCart record);
}