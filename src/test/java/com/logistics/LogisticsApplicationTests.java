package com.logistics;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.logistics.bean.*;
import com.logistics.mapper.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class LogisticsApplicationTests {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    DataSource dataSource;

    @Test
    void TestSql() {
        try {
            System.out.println("获取的数据库连接为:" + dataSource.getConnection());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("连接失败");
        }
    }

    @Test
    void contextLoads() {
        Admin user = new Admin();
        user.setAdmin("admin");
        user.setPassword("password");
        int insert = adminMapper.insert(user);
        Integer adminId = user.getAdminId();
        System.out.println(adminId);
    }

    @Autowired
    WarehouseMapper warehouseMapper;

    @Test
    void List() {
//        List<Warehouse> warehouses = warehouseMapper.selectList(new QueryWrapper<>());
//        warehouses.forEach(System.out::println);
        Warehouse warehouse = warehouseMapper.selectById(1);
        System.out.println(warehouse);
    }

    @Autowired
    CustumerMapper custumerMapper;

    @Test
    void Login() {
        QueryWrapper<Custumer> custumerQueryWrapper = new QueryWrapper<>();
        custumerQueryWrapper.eq("custumer_name", "客户姓名");
        custumerQueryWrapper.eq("custumer_password", "客户密码");
        Custumer custumer = custumerMapper.selectOne(custumerQueryWrapper);
        System.out.println(custumer);
    }

    @Autowired
    ClientMapper clientMapper;

    @Autowired
    StepListMapper stepListMapper;

    @Test
    void Ts() {
        Client client1 = new Client();
        client1.setOrderNumber(438862905);
        QueryWrapper<StepList> stepListQueryWrapper = new QueryWrapper<>();
        stepListQueryWrapper.eq("order_number", client1.getOrderNumber());
        List<StepList> stepLists = stepListMapper.selectList(stepListQueryWrapper);
        stepLists.forEach(System.out::println);
    }

}
