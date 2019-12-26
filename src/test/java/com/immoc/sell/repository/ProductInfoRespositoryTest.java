package com.immoc.sell.repository;

import com.alibaba.fastjson.JSONObject;
import com.immoc.sell.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRespositoryTest {

    @Autowired
    private ProductInfoRespository productInfoRespository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("皮蛋瘦肉粥");
        productInfo.setProductPrice(new BigDecimal(3.5));
        productInfo.setProductStock(12);
        productInfo.setProductDescription("很不错的粥");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategroyType(1);
        productInfo.setCreateTime(new Date());
        productInfo.setUpdateTime(new Date());
        productInfoRespository.save(productInfo);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> resultList = productInfoRespository.findByProductStatus(0);
        System.out.println(JSONObject.toJSON(resultList));
    }
}