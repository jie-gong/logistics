package com.logistics.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.logistics.bean.Client;
import com.logistics.bean.Custumer;
import com.logistics.bean.Evaluate;
import com.logistics.bean.vo.ClientAndCustumer;
import com.logistics.mapper.ClientMapper;
import com.logistics.mapper.CustumerMapper;
import com.logistics.mapper.EvaluateMapper;
import com.logistics.services.CustumerServices;
import com.logistics.util.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.WeakHashMap;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.logistics.services.impl.CustumerServicesImpl
 * @Date: 2022年11月26日 16:48
 * @Description:
 */
@Service
public class CustumerServicesImpl implements CustumerServices {


    @Autowired
    private CustumerMapper custumerMapper;

    //客户注册
    public Object Register(Custumer custumer) {
        Custumer custumer1 = new Custumer();
        custumer1.setCustumerId(custumer.getCustumerId());
        QueryWrapper<Custumer> custumerQueryWrapper = new QueryWrapper<>();
        custumerQueryWrapper.eq("custumer_id", custumer.getCustumerId());
        Custumer custumer2 = custumerMapper.selectOne(custumerQueryWrapper);
        if (custumer2 == null) {
            custumer1.setCustumerPassword(custumer.getCustumerPassword());
            custumer1.setCustumerTel(custumer.getCustumerTel());
            custumer1.setCustumerAddress(custumer.getCustumerAddress());
            custumer1.setCustumerDel(0);
            custumer1.setCustumerId(custumer.getCustumerId());
            int insert = custumerMapper.insert(custumer1);
            if (insert == 0) {
                return false;
            } else {
                return true;
            }
        } else {
            return "";
        }
    }

    //客户登录
    public Custumer Login(Custumer custumer) {
        QueryWrapper<Custumer> custumerQueryWrapper = new QueryWrapper<>();
        custumerQueryWrapper.eq("custumer_id", custumer.getCustumerId());
        custumerQueryWrapper.eq("custumer_password", custumer.getCustumerPassword());
        Custumer custumer1 = custumerMapper.selectOne(custumerQueryWrapper);
        return custumer1;
    }

    //发货 生成订单
    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private EvaluateMapper evaluateMapper;

    public Object Shipments(ClientAndCustumer clientAndCustumer) {
        //获取客户数据
        QueryWrapper<Custumer> custumerQueryWrapper = new QueryWrapper<>();
        custumerQueryWrapper.eq("custumer_id", clientAndCustumer.getCustumerId());
        Custumer custumer1 = custumerMapper.selectOne(custumerQueryWrapper);
        if (custumer1 == null) {
            return 0;
        } else {
            Client client1 = new Client();
            String math = MathUtil.getMath();
            Evaluate evaluate = new Evaluate();
            int a = Integer.parseInt(math);//生成订单号
            evaluate.setOrderNumber(a);
            client1.setOrderNumber(a);//插入订单号
            client1.setCustumerId(clientAndCustumer.getCustumerId());//插入客户id
            client1.setPhone(custumer1.getCustumerTel());//插入电话号码
            client1.setUsername(custumer1.getCustumerName());//插入客户姓名
            client1.setSite(clientAndCustumer.getSite());//插入用户地区
            client1.setGetName(clientAndCustumer.getGetName());//插入收件人姓名
            client1.setGetPhone(clientAndCustumer.getGetPhone());//插入收件人电话
            clientMapper.insert(client1);
            evaluateMapper.insert(evaluate);
            return a;
        }

    }


    //订单查询
    //查询自己的全部订单(通过客户id查询)
    public List<Client> selectById(Client client) {
        QueryWrapper<Client> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("custumer_id", client.getCustumerId());
        List<Client> clients = clientMapper.selectList(objectQueryWrapper);
        return clients;
    }

    //客户申请修改订单信息
    public Integer updateByDel(Client client) {
        Client client1 = new Client();
        client1.setOrderNumber(client.getOrderNumber());
        int i = clientMapper.updateByDel(client1);
        return i;
    }



    //查看完成的订单(通过用户id)
    public List<Client> selectList(Client client) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("custumer_id", client.getCustumerId());
        List<Client> clients = clientMapper.selectByMap(map);
        return clients;
    }

    //订单评价（通过订单号）
    public Integer updateEva(Evaluate evaluate) {
        Evaluate evaluate1 = new Evaluate();
        evaluate1.setOrderNumber(evaluate.getOrderNumber());
        evaluate1.setEvaluate(evaluate.getEvaluate());
        int i = evaluateMapper.updateById(evaluate1);
        return i;
    }


}
