package com.immoc.sell;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {


    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test() {
        String userName = "zhangsan";
        String passWord = "123456";
        logger.info("name：" + userName + ", passWord：" + passWord);
        logger.info("name：{}, passWord：{}",userName,passWord);
    }
    @Test
    public void delFile() {
        try {
            String str = "1,2,5";
            String str1 = "2";

            if (str.contains(str1)) {
                System.out.println("qwwqeqwewq");
            }

            File file = new File("E:\\20191230image\\1.jpeg");
           // System.out.println(file.exists());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取当前月第一天
     * @return
     */
    public static String getFirstDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat firstDay= new SimpleDateFormat("yyyy-MM-dd");
        return  firstDay.format(calendar.getTime());
    }

    public static Date getLastYearDate(Date ddaterClose) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(ddaterClose);
        int year = calendar.get(Calendar.YEAR);
        calendar.set(Calendar.YEAR,year +1);
        return calendar.getTime();
    }

    /**
     * 计算两个月的差值
     * ((Y1-Y2)*360+(M1-M2)*30+d1+d2)/30
     * @param ddateclosed
     * @param dbillingdate
     * @return
     */
    public static boolean monthdif(String ddateclosed,String dbillingdate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date dateClsoe = null;
        Date dbillingDate = null;
        boolean flag = false;
        try {
            dateClsoe = format.parse(ddateclosed);
            dbillingDate = format.parse(dbillingdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.setTime(dateClsoe);
        int y1 = calendar.get(Calendar.YEAR);
        int m1 = calendar.get(Calendar.MONTH);
        int d1 = calendar.get(Calendar.DATE);
        calendar.setTime(dbillingDate);
        int y2 = calendar.get(Calendar.YEAR);
        int m2 = calendar.get(Calendar.MONTH);
        int d2 = calendar.get(Calendar.DATE);
        int result = ((y1 - y2)*360 + (m1-m2)*30 + d1 + d2) / 30;
        if (result <= 12) {
            flag = true;
        }
        return flag;
    }

    @Test
    public void main() {
        System.out.println(getLastYearDate(new Date()));
    }
}
