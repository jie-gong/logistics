package com.logistics.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.logistics.bean.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.logistics.mapper.AdminMapper
 * @Date: 2022年11月25日 20:58
 * @Description:
 */
@Repository//持久层框架
public interface AdminMapper extends BaseMapper<Admin> {
}
