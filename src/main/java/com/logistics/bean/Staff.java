package com.logistics.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.logistics.bean.Admin
 * @Date: 2022年11月25日 20:46
 * @Description:  员工表
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff implements Serializable {

    private Integer staffId;
    private String name;
    private Integer sex;
    private String brith;
    private String cardId;
    private String phone;
    private Integer adminId;
    private String department;
    private String site;


}
