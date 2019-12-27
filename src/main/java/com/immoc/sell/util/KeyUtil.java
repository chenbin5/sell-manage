package com.immoc.sell.util;

import java.util.Random;

public class KeyUtil {

    /**
     * 生成唯一的主键
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        System.currentTimeMillis();
        Integer number = random.nextInt(90) + 10;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
