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
 * @Description: 客户表2
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Custumer implements Serializable {
    @TableId(value = "custumer_id", type = IdType.AUTO)
    private Integer custumerId;
    @TableField("custumer_name")
    private String custumerName;
    @TableField("custumer_password")
    private String custumerPassword;
    @TableField("custumer_tel")
    private String custumerTel;
    @TableField("custumer_address")
    private String custumerAddress;
    @TableLogic//逻辑删除
    private long custumerDel;
}
