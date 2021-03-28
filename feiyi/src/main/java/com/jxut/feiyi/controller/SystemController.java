package com.jxut.feiyi.controller;

import com.jxut.feiyi.entity.CustomerLogin;
import com.jxut.feiyi.service.CustomerLoginService;
import com.jxut.feiyi.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class SystemController {
    @Autowired
    private CustomerLoginService customerLoginService;

    @PostMapping("loginIndex")
    public AjaxResult loginIndex(CustomerLogin customerLogin, HttpServletRequest reqeset){
        CustomerLogin c = customerLoginService.selectByNameAndPwd(customerLogin);
        if (c != null) {
            HttpSession session = reqeset.getSession();
            session.setAttribute("user",c);
            session.setAttribute("userName",c.getLoginName());
            return new AjaxResult(200,"登录成功");
        }else {
            return new AjaxResult(600,"用户名或密码错误！");
        }
    }
}
