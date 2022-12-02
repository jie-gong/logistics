package com.logistics.bean;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.logistics.bean.Client
 * @Date: 2022年11月25日 20:47
 * @Description: 客户表1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client implements Serializable {
    @TableField("custumer_id")
    private Integer custumerId;
    @TableId(value = "order_number")
    private Integer orderNumber;
    @TableField("username")
    private String username;
    @TableField("e_mail")
    private String eMail;
    @TableField("phone")
    private String phone;
    @TableField("company")
    private String company;
    @TableField("site")
    private String site;
    @TableField("deleted")
    private Integer deleted;
    @TableLogic(value = "0", delval = "1")//逻辑删除注解
    private Integer sex;
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;

    @TableField("get_name")
    private String getName;
    @TableField("get_phone")
    private String getPhone;
    @TableField(exist = false)
    private List<StepList> stepList;


}
