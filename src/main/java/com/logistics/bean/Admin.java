package com.logistics.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.logistics.bean.Admin
 * @Date: 2022年11月25日 20:46
 * @Description: 管理员表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin implements Serializable {
    @TableId(value = "admin_id", type = IdType.AUTO)
    private Integer adminId;
    @TableField("admin")
    private String admin;
    @TableField("password")
    private String password;

}
