package com.logistics.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.logistics.bean.Admin
 * @Date: 2022年11月25日 20:46
 * @Description:  仓库
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Warehouse implements Serializable {
    @TableId(value = "warehouse_id", type = IdType.AUTO)
    private long warehouseId;
    @TableField("warehouse_address")
    private String warehouseAddress;
    @TableField("warehouse_region")
    private String warehouseRegion;
    @TableField("warehouse_adname")
    private String warehouseAdname;
    @TableField("warehouse_adtel")
    private String warehouseAdtel;
    @TableLogic//逻辑删除注解
    private long warehouseDel;
    @TableField("warehouse_repertory")
    private long warehouseRepertory;
    @TableField("warehouse_goods")
    private String warehouseGoods;

}
