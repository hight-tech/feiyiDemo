package com.jxut.feiyi.mapper;

import com.jxut.feiyi.entity.ProductInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductInfoMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(ProductInfo record);

    int insertSelective(ProductInfo record);

    ProductInfo selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);
}