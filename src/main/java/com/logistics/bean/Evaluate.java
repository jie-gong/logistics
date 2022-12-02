package com.logistics.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.logistics.bean.Evaluate
 * @Date: 2022年11月28日 20:36
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evaluate implements Serializable {
    @TableId(value = "order_number")
    private Integer orderNumber;
    @TableField("evaluate")
    private String evaluate;
}
