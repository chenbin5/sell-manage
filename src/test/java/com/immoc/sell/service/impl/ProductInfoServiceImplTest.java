package com.immoc.sell.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.immoc.sell.dataobject.ProductInfo;
import com.immoc.sell.service.ProductInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoService productInfoService;

    @Test
    public void findOne() {
       ProductInfo productInfo = productInfoService.findOne("123456");
       System.out.println(JSONObject.toJSON(productInfo));
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> resultList = productInfoService.findUpAll();
        System.out.println(JSONObject.toJSON(resultList));
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0,2);
        Page<ProductInfo> productInfos = productInfoService.findAll(request);
        System.out.println(JSONObject.toJSON(productInfos));
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("654321");
        productInfo.setProductName("兰州牛肉面");
        productInfo.setProductPrice(new BigDecimal(6.9));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很不错的粥");
        productInfo.setProductIcon("https://xxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategroyType(1);
        productInfo.setCreateTime(new Date());
        productInfo.setUpdateTime(new Date());
        productInfoService.save(productInfo);
    }
}