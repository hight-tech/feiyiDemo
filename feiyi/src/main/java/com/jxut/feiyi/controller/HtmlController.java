package com.jxut.feiyi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 转跳的配置页面
 */
@Controller
public class HtmlController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/index")
    public String index2(){
        return "html/index";
    }
    @RequestMapping("/login")
    public String login(){
        return "html/login";
    }
    @RequestMapping("/register")
    public String register(){
        return "html/register";
    }
    @RequestMapping("/aboutus")
    public String aboutus(){
        return "html/aboutus";
    }
    @RequestMapping("/culture")
    public String culture(){
        return "html/culture";
    }
    @RequestMapping("/shopcart")
    public String shopcart(){
        return "html/shopcart";
    }
    @RequestMapping("/collect")
    public String collect(){
        return "html/collect";
    }
}
