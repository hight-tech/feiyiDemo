package com.jxut.feiyi.controller;

import com.jxut.feiyi.entity.ProductInfo;
import com.jxut.feiyi.service.ProductInfoService;
import com.jxut.feiyi.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductInfoController {
    @Autowired
    private ProductInfoService productInfoService;

    /**
     * 商品信息
     * @param pid   商品id
     * @return
     */
    @GetMapping("goodsInfo")
    public AjaxResult goodsInfo(Integer pid){
        ProductInfo productInfo = productInfoService.selectByPid(pid);
        return new AjaxResult(0,"",productInfo);
    }
}
