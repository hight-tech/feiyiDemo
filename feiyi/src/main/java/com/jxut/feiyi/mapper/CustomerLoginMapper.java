package com.jxut.feiyi.mapper;

import com.jxut.feiyi.entity.CustomerLogin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerLoginMapper {
    int deleteByPrimaryKey(Integer customerId);

    int insert(CustomerLogin record);

    int insertSelective(CustomerLogin record);

    CustomerLogin selectByPrimaryKey(Integer customerId);

    int updateByPrimaryKeySelective(CustomerLogin record);

    int updateByPrimaryKey(CustomerLogin record);

    CustomerLogin selectByNameAndPwd(CustomerLogin customerLogin);
}