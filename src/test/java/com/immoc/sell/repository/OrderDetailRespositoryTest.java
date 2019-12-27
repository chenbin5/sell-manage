package com.immoc.sell.repository;

import com.alibaba.fastjson.JSONObject;
import com.immoc.sell.dataobject.OrderDetail;
import com.immoc.sell.util.GetSequence16;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRespositoryTest {

    @Autowired
    private OrderDetailRespository orderDetailRespository;

    @Test
    public void findByOrderId() {
      List<OrderDetail> result = orderDetailRespository.findByOrderId("2019122714160039");
      System.out.println(JSONObject.toJSON(result));
    }

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId(GetSequence16.getSequence16());
        orderDetail.setOrderId(GetSequence16.getSequence16());
        orderDetail.setProductName("测试");
        orderDetail.setProductId("123456");
        orderDetail.setProductIcon("http://www.xxxx.jpg");
        orderDetail.setProductQuantity(12);
        orderDetail.setProductPrice(new BigDecimal(65));
        orderDetail.setCreateTime(new Date());
        orderDetail.setUpdateTime(new Date());
        orderDetailRespository.save(orderDetail);
    }
}