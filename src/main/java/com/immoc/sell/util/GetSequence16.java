package com.immoc.sell.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetSequence16 {

    public static synchronized String getSequence16() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssss");//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间
    }
}
