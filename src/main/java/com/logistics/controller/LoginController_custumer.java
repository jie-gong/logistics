package com.logistics.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.logistics.bean.Custumer;
import com.logistics.returnjson.ReturnObject;
import com.logistics.services.impl.CustumerServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.logistics.controller.LoginController_custumer
 * @Date: 2022年11月26日 16:39
 * @Description: 客户登录注册
 */
@RestController
@RequestMapping("/custumer")
public class LoginController_custumer {

    @Autowired
    private CustumerServicesImpl services;

    //客户注册
    @PostMapping("/register")
    @ResponseBody
    public Object Register(@RequestBody Custumer custumer) {
        Object register = services.Register(custumer);
        if (register.equals(true)) {
            return JSONObject.toJSON(new ReturnObject(200, "注册成功"));
        } else if (register.equals("")) {
            return JSONObject.toJSON(new ReturnObject(500, "已被注册"));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "注册失败"));
        }
    }

    //客户登录
    @PostMapping("/login")
    @ResponseBody
    public Object Login(@RequestBody Custumer custumer) {
        Custumer login = services.Login(custumer);
        if (login == null) {
            return JSONObject.toJSON(new ReturnObject(500, "登陆失败"));
        } else {
            return JSONObject.toJSON(new ReturnObject(200, "登陆成功", 1, login));
        }
    }

}
