package com.jxut.feiyi.service;

import com.jxut.feiyi.entity.OrderCart;
import com.jxut.feiyi.entity.OrderCollect;
import com.jxut.feiyi.entity.ProductInfo;
import com.jxut.feiyi.mapper.OrderCartMapper;
import com.jxut.feiyi.mapper.OrderCollectMapper;
import com.jxut.feiyi.mapper.ProductInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderCartService {
    @Autowired
    private OrderCartMapper orderCartMapper;
    @Autowired
    private ProductInfoMapper productInfoMapper;
    @Autowired
    private OrderCollectMapper orderCollectMapper;

    public OrderCart selectByCartId(Integer cartId) {
        return orderCartMapper.selectByPrimaryKey(cartId);
    }

    public List<OrderCart> selectByCId(Integer cid) {
        List<OrderCart> orderCarts = orderCartMapper.selectByCId(cid);
        for (OrderCart o : orderCarts) {
            ProductInfo p = productInfoMapper.selectByPrimaryKey(o.getProductId());
            o.setProductName(p.getProductName());
            o.setDescript(p.getDescript());
            o.setPic(p.getPic());
            //计算价格
            o.setPriceCount(o.getPrice().multiply(BigDecimal.valueOf(o.getProductAmount())));
        }
        return orderCarts;
    }

    public int addToShopCart(OrderCart orderCart) {
        return orderCartMapper.insertSelective(orderCart);
    }

    public int delOneShopCart(Integer cartId) {
        return orderCartMapper.deleteByPrimaryKey(cartId);
    }

    /**
     * 收藏商品数据
     * @param cid
     * @return
     */
    public List<OrderCollect> selectCollectByCId(Integer cid){
        List<OrderCollect> orderCollects = orderCollectMapper.selectCollectByCId(cid);
        for (OrderCollect o : orderCollects) {
            ProductInfo p = productInfoMapper.selectByPrimaryKey(o.getProductId());
            o.setProductName(p.getProductName());
            o.setDescript(p.getDescript());
            o.setPic(p.getPic());
        }
        return orderCollects;
    }

    public int addOneCollect(OrderCollect oc) {
        return orderCollectMapper.insertSelective(oc);
    }

    public int delOneCollect(Integer collectId) {
        return orderCollectMapper.deleteByPrimaryKey(collectId);
    }
}
