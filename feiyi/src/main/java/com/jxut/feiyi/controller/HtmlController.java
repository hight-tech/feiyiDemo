package com.jxut.feiyi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 转跳的配置页面
 */
@Controller
public class HtmlController {

    /*@RequestMapping("/")
    public String index(){
        return "index";
    }*/

    /**
     * 主页面
     * @return
     */
    @RequestMapping("/index")
    public String index2(){
        return "html/index";
    }

    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "html/login";
    }

    /**
     * 注册页面
     * @return
     */
    @RequestMapping("/register")
    public String register(){
        return "html/register";
    }

    /**
     * 关于我们页面
     * @return
     */
    @RequestMapping("/aboutus")
    public String aboutus(){
        return "html/aboutus";
    }

    /**
     * 文化页面
     * @return
     */
    @RequestMapping("/culture")
    public String culture(){
        return "html/culture";
    }

    /**
     * 购物车页面
     * @return
     */
    @RequestMapping("/shopcart")
    public String shopcart(){
        return "html/shopcart";
    }

    /**
     * 收藏页面
     * @return
     */
    @RequestMapping("/collect")
    public String collect(){
        return "html/collect";
    }

    /**
     * vip页面
     * @return
     */
    @RequestMapping("/vip")
    public String vip(){
        return "html/VIP";
    }

    /**
     * 商品信息页面
     * @param reqeset
     * @param pid 商品id
     * @return
     */
    @RequestMapping("/product_details")
    public String product_details(HttpServletRequest reqeset,Integer pid){
        reqeset.setAttribute("pid",pid);
        return "html/product_details";
    }

    /**
     * 结算页面
     * @return
     */
    @RequestMapping("/payforsuccess")
    public String payforsuccess(){
        return "/html/payforsuccess";
    }
}
