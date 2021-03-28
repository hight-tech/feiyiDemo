package com.jxut.feiyi.service;

import com.jxut.feiyi.entity.OrderCart;
import com.jxut.feiyi.mapper.OrderCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderCartService {
    @Autowired
    private OrderCartMapper orderCartMapper;

    public List<OrderCart> selectByCId(Integer cid) {
        List<OrderCart> orderCarts = orderCartMapper.selectByCId(cid);
        for (OrderCart o : orderCarts) {
            o.setPriceCount(o.getPrice().multiply(BigDecimal.valueOf(o.getProductAmount())));
        }
        return orderCarts;
    }
}
