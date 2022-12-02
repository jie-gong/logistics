package com.logistics.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.logistics.bean.Client
 * @Date: 2022年11月25日 20:47
 * @Description: 运输汽车表
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private long carId;
    private String catName;
    private String carBrand;
    private String carRegion;
    private long carDel;
    private long carRepair;
}
