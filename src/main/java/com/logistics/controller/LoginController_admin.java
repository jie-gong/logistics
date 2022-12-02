package com.logistics.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.logistics.bean.Admin;
import com.logistics.returnjson.ReturnObject;
import com.logistics.services.impl.AdminServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.logistics.controller.LoginController
 * @Date: 2022年11月25日 21:05
 * @Description:
 */
@RestController
@RequestMapping("/admin")
public class LoginController_admin {

    @Autowired
    private AdminServicesImpl services;

    //账号注册
    @PostMapping("/register")
    @ResponseBody
    public Object Register(@RequestBody Admin admin) {
        //账号
        admin.setAdmin(admin.getAdmin());
        if (admin.getAdmin().equals("")) {
            return JSONObject.toJSON(new ReturnObject(200, "账号不能为空"));
        }
        //密码
        admin.setPassword(admin.getPassword());
        if (admin.getPassword().equals("")) {
            return JSONObject.toJSON(new ReturnObject(200, "密码不能为空"));
        }
        boolean register = services.Register(admin);
        if (register) {
            return JSONObject.toJSON(new ReturnObject(200, "注册成功"));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "注册失败"));
        }
    }

    //账号登录
    @PostMapping("/Login")
    @ResponseBody
    public Object Login(@RequestBody Admin admin) {
        admin.setAdmin(admin.getAdmin());
        admin.setPassword(admin.getPassword());
        boolean login = services.Login(admin);
        if (login) {
            return JSONObject.toJSON(new ReturnObject(200, "登录成功"));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "登陆失败"));
        }
    }

}
