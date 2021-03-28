package com.jxut.feiyi.controller;

import com.jxut.feiyi.entity.CustomerLogin;
import com.jxut.feiyi.entity.OrderCart;
import com.jxut.feiyi.service.OrderCartService;
import com.jxut.feiyi.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/shopCart/")
public class ShopCartController {

    @Autowired
    private OrderCartService orderCartService;
    @GetMapping("list")
    public AjaxResult list(HttpServletRequest reqeset){
        CustomerLogin c= (CustomerLogin) reqeset.getSession().getAttribute("user");
        List<OrderCart> list = orderCartService.selectByCId(c.getCustomerId());

        return new AjaxResult(0,"list",list);
    }

}
