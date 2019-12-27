package com.immoc.sell.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.immoc.sell.dataobject.OrderDetail;
import com.immoc.sell.dataobject.OrderMaster;
import com.immoc.sell.dto.OrderDTO;
import com.immoc.sell.service.OrderMasterService;
import org.aspectj.weaver.ast.Or;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterServiceImplTest {

    @Autowired
    private OrderMasterService orderMasterService;

    private final String OPENID = "121212";
    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("二师兄");
        orderDTO.setBuyerAddress("测试地址");
        orderDTO.setOpenId(OPENID);
        orderDTO.setBuyerPhone("18143798073");
        //购物车
        List<OrderDetail> orderDetails = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("157743188029757");
        o1.setProductQuantity(10);
        OrderDetail o2 = new OrderDetail();
        o2.setProductId("654321");
        o2.setProductQuantity(10);
        orderDetails.add(o1);
        orderDetails.add(o2);
        orderDTO.setOrderDetailList(orderDetails);
        OrderDTO result = orderMasterService.create(orderDTO);
        System.out.println(JSONObject.toJSON(result));

    }

    @Test
    public void findOne() {
        OrderDTO orderDTO = orderMasterService.findOne("2019122715270052");
        System.out.println(JSONObject.toJSON(orderDTO));
    }

    @Test
    public void findList() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}