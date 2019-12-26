package com.immoc.sell.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.immoc.sell.dataobject.ProductCategroy;
import com.immoc.sell.service.ProductCategroyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategroyServiceImplTest {

    @Autowired
    private ProductCategroyService productCategroyService;

    @Test
    public void findOne() {
        ProductCategroy productCategroy = productCategroyService.findOne(1);
        System.out.println(JSONObject.toJSON(productCategroy));
    }

    @Test
    public void findAll() {
        List<ProductCategroy> resultList = productCategroyService.findAll();
        System.out.println(JSONObject.toJSON(resultList));
    }

    @Test
    public void save() {
        ProductCategroy productCategroy = new ProductCategroy();
        productCategroy.setCategroyType(2);
        productCategroy.setCategroyName("男生专享");
        productCategroy.setCreateTime(new Date());
        productCategroy.setUpdateTime(new Date());
        productCategroyService.save(productCategroy);
    }
}