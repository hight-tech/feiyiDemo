package com.jxut.feiyi.service;

import com.jxut.feiyi.entity.CustomerLogin;
import com.jxut.feiyi.mapper.CustomerLoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerLoginService {
    @Autowired
    private CustomerLoginMapper customerLoginMapper;


    public CustomerLogin selectByNameAndPwd(CustomerLogin customerLogin) {
        return customerLoginMapper.selectByNameAndPwd(customerLogin);
    }
}
