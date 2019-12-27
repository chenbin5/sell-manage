package com.immoc.sell.repository;

import com.alibaba.fastjson.JSONObject;
import com.immoc.sell.dataobject.OrderMaster;
import com.immoc.sell.util.GetSequence16;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRespositoryTest {


    @Autowired
    private OrderMasterRespository orderMasterRespository;

    private final static String OPENID = "xiaoma123";

    @Test
    public void findByOpenId() {
        PageRequest request = new PageRequest(0,2);
        Page<OrderMaster> result = orderMasterRespository.findByOpenId(OPENID,request);
        System.out.println(JSONObject.toJSON(result));
    }

    @Test
    public void saveTest() {
        OrderMaster master = new OrderMaster();
        master.setOrderId(GetSequence16.getSequence16());
        master.setBuyerName("测试");
        master.setBuyerAddress("兰州市丰台区育芳园63号楼");
        master.setOpenId(OPENID);
        master.setBuyerPhone("18143798073");
        master.setOrderAmount(new BigDecimal(8));
        master.setCreateTime(new Date());
        master.setUpdateTime(new Date());
        orderMasterRespository.save(master);
    }
}