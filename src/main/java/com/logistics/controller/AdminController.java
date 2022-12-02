package com.logistics.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.logistics.bean.Client;
import com.logistics.bean.StepList;
import com.logistics.bean.vo.ClientAndStepList;
import com.logistics.returnjson.ReturnObject;
import com.logistics.services.impl.AdminServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.logistics.controller.AdminController
 * @Date: 2022年11月27日 17:14
 * @Description:
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminServicesImpl adminServices;


    //通过订单号查询
    @PostMapping("/selectByClient")
    @ResponseBody
    public Object selectByClient(@RequestBody Client client) {
        Client client1 = adminServices.selectByClient(client);
        List<StepList> stepLists = adminServices.selectStepList(client);
        client1.setStepList(stepLists);
        if (client1 == null) {
            return JSONObject.toJSON(new ReturnObject(500, "没有单号"));
        } else {
            return JSONObject.toJSON(new ReturnObject(200, "查询成功", 1, client1));
        }
    }

    //查询全部订单
    @GetMapping("/selectAll")
    @ResponseBody
    public Object selectAll() {
        List<Client> clients = adminServices.selectAll();
        return JSONObject.toJSON(new ReturnObject(200, "操成功", clients.size(), clients));
    }

    //统计个人订单数目
    @PostMapping("/selectList")
    @ResponseBody
    public Object selectList(@RequestBody Client client) {
        List<Client> clients = adminServices.selectList(client);
        if (clients.size() == 0) {
            return JSONObject.toJSON(new ReturnObject(500, "当前暂无物流信息"));
        } else {
            return JSONObject.toJSON(new ReturnObject(200, "当前订单量为" + clients.size() + "条", clients.size(), null));
        }
    }

    //查询当前地区的订单  模糊查询
    @PostMapping("/selectBySite")
    @ResponseBody
    public Object selectBySite(@RequestBody Client client) {
        List<Client> clients = adminServices.selectBySite(client);
        if (clients.size() == 0) {
            return JSONObject.toJSON(new ReturnObject(404, "操作失败(没有查询到订单信息)"));
        } else {
            return JSONObject.toJSON(new ReturnObject(200, "操作成功", clients.size(), clients));
        }
    }

    //修改订单信息(管理员通过订单号修改)
    @PostMapping("/updateById")
    @ResponseBody
    public Object updateById(@RequestBody Client client) {
        int i = adminServices.updateById(client);
        if (i == 1) {
            return JSONObject.toJSON(new ReturnObject(200, "修改成功"));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "修改失败"));
        }
    }

    //查询有修改申请的订单
    @GetMapping("/selectByDel")
    @ResponseBody
    public Object selectByDel() {
        List<Client> clients = adminServices.selectByDel();
        if (clients.size() != 0) {
            return JSONObject.toJSON(new ReturnObject(200, "当前有" + clients.size() + "条待修改", clients.size(), clients));
        } else {
            return JSONObject.toJSON(new ReturnObject(404, "当前没有订单需要修改"));
        }
    }

    //修改完毕删除待修改状态
    @PostMapping("/updateByDel")
    @ResponseBody
    public Object updateByDel(@RequestBody Client client) {
        Integer integer = adminServices.updateByDel(client);
        if (integer == 1) {
            return JSONObject.toJSON(new ReturnObject(200, "修改完毕"));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "恢复失败"));
        }
    }

    //添加物流中专信息
    @PostMapping("/stepList")
    @ResponseBody
    /**
     * 三个参数  单号、快递发出状态、中转站
     */
    public Object stepList(@RequestBody ClientAndStepList client) {
        int i = adminServices.stepList(client);
        if (i == 1) {
            return JSONObject.toJSON(new ReturnObject(200, "更新成功"));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "更新失败"));
        }
    }

    //订单完成状态(通过订单号更新)
    @PostMapping("/updateBySex")
    @ResponseBody
    public Object updateBySex(@RequestBody Client client) {
        Integer integer = adminServices.updateBySex(client);
        if (integer == 1) {
            return JSONObject.toJSON(new ReturnObject(200, "更新成功"));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "请求失败(通过订单号更新或订单已经完成)"));
        }
    }

}
