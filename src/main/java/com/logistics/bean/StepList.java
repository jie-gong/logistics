package com.logistics.bean;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.logistics.bean.StepList
 * @Date: 2022年11月30日 15:14
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StepList implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("order_number")
    private Integer orderNumber;
    @TableField("state_name")
    private String stateName;
    @TableField("address_at")
    private String addressAt;
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;
}
