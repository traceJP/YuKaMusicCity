package com.tracejp.yuka.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
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

    /**
     * 获取一天内的最大时间戳，即当天的23:59:59
     * @return 时间戳
     */
    public static long getOneDayEndTime() {
        Date date = new Date();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        Date overTime = Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
        return overTime.getTime();
    }


}
