package com.logistics.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.logistics.bean.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.logistics.mapper.StaffMapper
 * @Date: 2022年11月25日 20:59
 * @Description:
 */
@Repository
public interface StaffMapper extends BaseMapper<Staff> {
}
