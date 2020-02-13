package com.immoc.sell;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

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
            File file = new File("E:\\20191230image\\1.jpeg");
            System.out.println(file.exists());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
