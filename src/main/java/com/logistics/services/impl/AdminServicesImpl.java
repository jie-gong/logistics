package com.logistics.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.logistics.bean.Admin;
import com.logistics.bean.Client;
import com.logistics.bean.StepList;
import com.logistics.bean.vo.ClientAndStepList;
import com.logistics.mapper.AdminMapper;
import com.logistics.mapper.ClientMapper;
import com.logistics.mapper.StepListMapper;
import com.logistics.services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.logistics.services.impl.AdminServicesImpl
 * @Date: 2022年11月25日 21:06
 * @Description:
 */
@Service
public class AdminServicesImpl implements AdminServices {
    @Autowired
    private AdminMapper adminMapper;

    //账号注册
    public boolean Register(Admin admin) {
        int insert = adminMapper.insert(admin);
        if (insert == 1) {
            return true;
        } else {
            return false;
        }
    }

    //账号登录
    public boolean Login(Admin admin) {
        QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<>();
        adminQueryWrapper.eq("admin", admin.getAdmin());
        adminQueryWrapper.eq("password", admin.getPassword());
        Admin admin1 = adminMapper.selectOne(adminQueryWrapper);
        if (admin1 == null) {
            return false;
        } else {
            return true;
        }
    }

    @Autowired
    private ClientMapper clientMapper;
    //通过单号查询订单

    public Client selectByClient(Client client) {
        QueryWrapper<Client> clientQueryWrapper = new QueryWrapper<>();
        clientQueryWrapper.eq("order_number", client.getOrderNumber());
        Client client1 = clientMapper.selectOne(clientQueryWrapper);
        return client1;
    }

    //查询全部订单
    public List<Client> selectAll() {
        List<Client> clients = clientMapper.selectList(new QueryWrapper<>());
        return clients;
    }

    //查询个人订单
    public List<Client> selectList(Client client) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("custumer_id", client.getCustumerId());
        List<Client> clients = clientMapper.selectByMap(map);
        return clients;
    }

    //修改订单地址(管理员通过订单号订单修改信息)
    public int updateById(Client client) {
        Client client1 = new Client();
        client1.setSite(client.getSite());
        client1.setOrderNumber(client.getOrderNumber());
        client1.setPhone(client.getPhone());
        client1.setCustumerId(client.getCustumerId());
        client1.setCompany(client.getCompany());
        client1.setEMail(client.getEMail());
        client1.setUsername(client.getUsername());
        int i = clientMapper.updateById(client1);
        return i;
    }

    //查询当前地区的订单
    //模糊查询
    public List<Client> selectBySite(Client client) {
        QueryWrapper<Client> clientQueryWrapper = new QueryWrapper<>();
        clientQueryWrapper.like("site", client.getSite());
        List<Client> clients = clientMapper.selectList(clientQueryWrapper);
        return clients;
    }

    //查看待修改的订单
    //delete==1
    public List<Client> selectByDel() {
        QueryWrapper<Client> clientQueryWrapper = new QueryWrapper<>();
        clientQueryWrapper.eq("deleted", 1);
        List<Client> clients = clientMapper.selectList(clientQueryWrapper);
        return clients;
    }

    //修改完毕删除待修改状态
    public Integer updateByDel(Client client) {
        Client client1 = new Client();
        client1.setOrderNumber(client.getOrderNumber());
        int i = clientMapper.updateByAdmin(client1);
        return i;
    }

    @Autowired
    private StepListMapper stepListMapper;

    //通过单号 生成物流状态信息
    public int stepList(ClientAndStepList clientAndStepList) {
        StepList stepList = new StepList();
        stepList.setOrderNumber(clientAndStepList.getOrderNumber());
        stepList.setAddressAt(clientAndStepList.getAddressAt());
        stepList.setStateName("快递发出");
        int insert = stepListMapper.insert(stepList);
        return insert;
    }

    //通过单号查询订单状态详情
    public List<StepList> selectStepList(Client client) {
        QueryWrapper<StepList> stepListQueryWrapper = new QueryWrapper<>();
        stepListQueryWrapper.eq("order_number", client.getOrderNumber());
        List<StepList> stepLists = stepListMapper.selectList(stepListQueryWrapper);
        return stepLists;
    }

    //更新订单完成状态
    public Integer updateBySex(Client client) {
        Client client1 = new Client();
        client1.setOrderNumber(client.getOrderNumber());
        int i = clientMapper.deleteById(client1);
        return i;
    }
}
