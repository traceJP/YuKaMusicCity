package com.tracejp.yuka.utils;

import java.util.Random;

/*********************************
 * @author traceJP
 *********************************/
public class Util {

    /**
     * 获取随机数（大小写字母和数字）
     * @param length 传入获取数字长度
     * @return 随机数
     */
    public static String getRandomString(int length) {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }


}
