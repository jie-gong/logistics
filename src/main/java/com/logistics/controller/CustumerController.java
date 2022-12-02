package com.logistics.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.logistics.bean.Client;
import com.logistics.bean.Custumer;
import com.logistics.bean.Evaluate;
import com.logistics.bean.vo.ClientAndCustumer;
import com.logistics.returnjson.ReturnObject;
import com.logistics.services.impl.CustumerServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.Oneway;
import java.util.List;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.logistics.controller.CustumerController
 * @Date: 2022年11月26日 16:50
 * @Description:
 */
@RestController
@RequestMapping("/custumer")
public class CustumerController {
    @Autowired
    private CustumerServicesImpl custumerServices;

    //生成订单信息
    @PostMapping("/create")
    @ResponseBody
    public Object Create(@RequestBody ClientAndCustumer clientAndCustumer) {
        Integer shipments = (Integer) custumerServices.Shipments(clientAndCustumer);
        if (shipments != 0) {
            return JSONObject.toJSON(new ReturnObject(200, "插入成功", 1, shipments));
        } else if (shipments == 0) {
            return JSONObject.toJSON(new ReturnObject(404, "没有找到用户"));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "插入失败"));

        }
    }


    //订单查询
    //查询自己的全部订单(通过客户id查询)
    @PostMapping("/selectById")
    @ResponseBody
    public Object selectByName(@RequestBody Client client) {
        List<Client> clients = custumerServices.selectById(client);
        if (clients.size() == 0) {
            return JSONObject.toJSON(new ReturnObject(500, "当前暂无订单信息"));
        } else {
            return JSONObject.toJSON(new ReturnObject(200, "查询成功", clients.size(), clients));
        }
    }

    //订单修改申请
    @PostMapping("/updateByDel")
    @ResponseBody
    public Object updateByDel(@RequestBody Client client) {
        Integer integer = custumerServices.updateByDel(client);
        if (integer == 1) {
            return JSONObject.toJSON(new ReturnObject(200, "申请成功"));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "申请失败"));
        }
    }


    //查看完成的订单(通过用户id)
    @PostMapping("/selectListById")
    @ResponseBody
    public Object selectList(@RequestBody Client client) {
        List<Client> clients = custumerServices.selectList(client);
        if (clients.size() == 0) {
            return JSONObject.toJSON(new ReturnObject(404, "暂无订单"));
        } else {
            return JSONObject.toJSON(new ReturnObject(200, "查询成功", clients.size(), clients));
        }
    }

    //评价订单(通过订单号评价)
    @PostMapping("/updateEva")
    @ResponseBody
    public Object updateEva(@RequestBody Evaluate evaluate) {
        Integer integer = custumerServices.updateEva(evaluate);
        if (integer == 1) {
            return JSONObject.toJSON(new ReturnObject(200, "评价成功"));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "评价失败"));
        }
    }

    //客户申请修改订单
//    @PostMapping("/updateSex")
}
