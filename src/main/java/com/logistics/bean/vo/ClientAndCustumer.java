package com.logistics.bean.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.logistics.bean.vo.ClientAndCustumer
 * @Date: 2022年11月26日 21:54
 * @Description: 客户与订单
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientAndCustumer {
    @TableField("order_number")
    private long orderNumber;
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

    @TableField("get_name")
    private String getName;
    @TableField("get_phone")
    private String getPhone;

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
