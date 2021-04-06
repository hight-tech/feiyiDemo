package com.jxut.feiyi.service;

import com.jxut.feiyi.entity.ProductInfo;
import com.jxut.feiyi.mapper.ProductInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductInfoService {
    @Autowired
    private ProductInfoMapper productInfoMapper;

    public ProductInfo selectByPid(Integer pid){
        return productInfoMapper.selectByPrimaryKey(pid);
    }
}
