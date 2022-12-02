package com.logistics.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.logistics.bean.Warehouse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.logistics.mapper.WarehouseMapper
 * @Date: 2022年11月26日 16:07
 * @Description:
 */
@Repository
public interface WarehouseMapper extends BaseMapper<Warehouse> {
}
