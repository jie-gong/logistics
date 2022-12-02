package com.logistics.test;

import com.logistics.util.MathUtil;

import java.util.*;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.logistics.test.Test01
 * @Date: 2022年11月26日 16:03
 * @Description:
 */
public class Test01 {


    public static void main(String[] args) {
        String math = MathUtil.getMath();
        int a = Integer.parseInt(math);
        System.out.println(a);

//        String randomNum;
//        List<String> numList1 = new ArrayList<>();
//        List<String> numList2 = new ArrayList<>();
//        randomNum = String.format("%010d", Math.abs(new Random().nextInt()));
//        if (numList1.contains(randomNum)) {
//            numList2.add(randomNum);
//        } else {
//            numList1.add(randomNum);
//        }
//        System.out.println(randomNum);
//        System.out.println("随机生机10位数，100000次测试，生成不重复个数：" + numList1.size() + "，重复个数：" + numList2.size());
    }

    public static String generate8RateUuid() {
        String[] chars = new String[]{"a", "b", "c", "d", "e", "f",
                "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
                "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
                "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
                "W", "X", "Y", "Z"};
        Random r = new Random();
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString() + (r.nextInt(899) + 100);
    }


}
