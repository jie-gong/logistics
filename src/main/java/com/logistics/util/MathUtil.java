package com.logistics.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.logistics.util.MathUtil
 * @Date: 2022年11月26日 21:09
 * @Description:
 */
public class MathUtil {
    public static String getMath() {
        String randomNum;
        List<String> numList1 = new ArrayList<>();
        List<String> numList2 = new ArrayList<>();
        randomNum = String.format("%010d", Math.abs(new Random().nextInt()));
        if (numList1.contains(randomNum)) {
            numList2.add(randomNum);
        } else {
            numList1.add(randomNum);
        }
        return randomNum;
    }


}
