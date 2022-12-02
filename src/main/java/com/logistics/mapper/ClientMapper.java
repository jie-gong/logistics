package com.logistics.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.logistics.bean.Client;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.logistics.mapper.ClientMapper
 * @Date: 2022年11月25日 20:58
 * @Description:
 */
@Repository
public interface ClientMapper extends BaseMapper<Client> {
    //客户申请修改订单状态
    int updateByDel(Client client);

    //管理员恢复订单状态
    int updateByAdmin(Client client);
}
