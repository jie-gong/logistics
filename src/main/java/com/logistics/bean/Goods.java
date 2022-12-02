package com.logistics.bean;


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
 * @Description: 物品表
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods implements Serializable {
    private long goodsId;
    private String goodsName;
    private String goodsAmount;
    //出库状态
    @TableLogic//逻辑删除注解
    private long goodsDel;
}
