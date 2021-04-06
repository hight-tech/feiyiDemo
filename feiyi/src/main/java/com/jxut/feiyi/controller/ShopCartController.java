package com.jxut.feiyi.controller;

import com.jxut.feiyi.entity.CustomerLogin;
import com.jxut.feiyi.entity.OrderCart;
import com.jxut.feiyi.entity.OrderCollect;
import com.jxut.feiyi.entity.ProductInfo;
import com.jxut.feiyi.service.OrderCartService;
import com.jxut.feiyi.service.ProductInfoService;
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
    @Autowired
    private ProductInfoService productInfoService;

    /**
     * 购物车页面
     * @param reqeset
     * @return
     */
    @GetMapping("list")
    public AjaxResult list(HttpServletRequest reqeset){
        CustomerLogin c= (CustomerLogin) reqeset.getSession().getAttribute("user");
        List<OrderCart> list = orderCartService.selectByCId(c.getCustomerId());

        return new AjaxResult(0,"list",list);
    }

    /**
     * 添加到购物车
     * @param reqeset 请求
     * @param pid   商品id
     * @param productAmount 数量
     * @return
     */
    @GetMapping("addToShopCart")
    public AjaxResult addToShopCart(HttpServletRequest reqeset,Integer pid,Integer productAmount){
        CustomerLogin c= (CustomerLogin) reqeset.getSession().getAttribute("user");
        OrderCart orderCart = new OrderCart();
        orderCart.setCustomerId(c.getCustomerId());
        orderCart.setProductAmount(productAmount);
        ProductInfo p = productInfoService.selectByPid(pid);
        orderCart.setPrice(p.getPrice());
        orderCart.setProductId(pid);
        int res=orderCartService.addToShopCart(orderCart);
        if (res>0){
            return AjaxResult.success("添加成功！");
        }else{
            return new AjaxResult(500,"添加失败！");
        }
    }

    /**
     * 删除购物车的商品
     * @param cartId    购物车id
     * @return
     */
    @GetMapping("delOneShopCart")
    public AjaxResult delOneShopCart(Integer cartId){
        int res=orderCartService.delOneShopCart(cartId);
        if (res>0){
            return AjaxResult.success("删除成功");
        }else{
            return new AjaxResult(500,"删除失败！");
        }
    }

    /**
     * 购物车收藏数据
     * @param reqeset
     * @return
     */
    @GetMapping("listCollect")
    public AjaxResult listCollect(HttpServletRequest reqeset){
        CustomerLogin c= (CustomerLogin) reqeset.getSession().getAttribute("user");
        List<OrderCollect> list = orderCartService.selectCollectByCId(c.getCustomerId());
        return new AjaxResult(0,"",list);
    }

    /**
     * 添加收藏
     * @param reqeset
     * @param cartId
     * @return
     */
    @GetMapping("addOneCollect")
    public AjaxResult addOneCollect(HttpServletRequest reqeset,Integer cartId){
        OrderCart o = orderCartService.selectByCartId(cartId);
        OrderCollect oc = new OrderCollect();
        oc.setCustomerId(o.getCustomerId());
        oc.setProductId(o.getProductId());
        oc.setProductNumber(o.getProductAmount());
        oc.setPrice(o.getPrice());
        int res = orderCartService.addOneCollect(oc);
        if (res>0){
            return AjaxResult.success("添加收藏成功！");
        }else{
            return new AjaxResult(500,"添加收藏失败！");
        }
    }

    /**
     * 删除收藏
     * @param collectId
     * @return
     */
    @GetMapping("delOneCollect")
    public AjaxResult delOneCollect(Integer collectId){
        int res=orderCartService.delOneCollect(collectId);
        if (res>0){
            return AjaxResult.success("删除成功");
        }else{
            return new AjaxResult(500,"删除失败！");
        }
    }

}
