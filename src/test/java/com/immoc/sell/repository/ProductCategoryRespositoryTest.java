package com.immoc.sell.repository;

import com.alibaba.fastjson.JSONObject;
import com.immoc.sell.dataobject.ProductCategroy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRespositoryTest {


    @Autowired
    private ProductCategroyRespository respository;

    @Test
    public void findOneTest() {
        ProductCategroy productCategory = respository.findOne(1);
        System.out.println(JSONObject.toJSON(productCategory));
    }

    @Test
    @Transactional
    public void saveOneTest() {
        ProductCategroy productCategroy = new ProductCategroy();
        productCategroy.setCategroyName("男生最爱1");
        productCategroy.setCategroyType(12);
        productCategroy.setCreateTime(new Date());
        productCategroy.setUpdateTime(new Date());
        respository.save(productCategroy);
    }

    @Test
    public void updateTest() {
        ProductCategroy productCategroy = respository.findOne(2);
        productCategroy.setCategroyId(2);
        productCategroy.setCategroyName("男生最爱");
        productCategroy.setUpdateTime(new Date());
        respository.save(productCategroy);
    }

    @Test
    public void findByCategroyTypeListTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        List<ProductCategroy> resultList = respository.findByCategroyTypeIn(list);
        System.out.println(JSONObject.toJSON(resultList));
    }
}