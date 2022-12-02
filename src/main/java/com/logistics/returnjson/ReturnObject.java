package com.logistics.returnjson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.logistics.returnjson.ReturnObject
 * @Date: 2022年11月25日 21:04
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnObject {
    private Integer code = 200;
    private Integer total = 0;
    private String message = "";
    private Object data = "没有数据";

    public ReturnObject(Integer code, String message, Integer total, Object result) {
        this.code = code;
        this.message = message;
        this.total = total;
        this.data = result;
    }

    public ReturnObject(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
