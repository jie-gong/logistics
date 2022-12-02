package com.logistics.bean.vo;

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
 * @Pcakage: com.logistics.bean.vo.ClientAndStepList
 * @Date: 2022年11月30日 15:20
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientAndStepList implements Serializable {
    @TableField("custumer_id")
    private Integer custumerId;
    @TableId(value = "order_number")
    private Integer orderNumber;
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("state_name")
    private String stateName;
    @TableField("address_at")
    private String addressAt;
}
