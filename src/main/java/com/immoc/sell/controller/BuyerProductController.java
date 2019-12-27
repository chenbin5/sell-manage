package com.immoc.sell.controller;

import com.alibaba.fastjson.JSONObject;
import com.immoc.sell.VO.ProductInfoVO;
import com.immoc.sell.VO.ProductVO;
import com.immoc.sell.VO.ResultVO;
import com.immoc.sell.dataobject.ProductCategroy;
import com.immoc.sell.dataobject.ProductInfo;
import com.immoc.sell.service.ProductCategroyService;
import com.immoc.sell.service.ProductInfoService;
import com.immoc.sell.util.ResultVoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    private final Logger logger = LoggerFactory.getLogger(BuyerProductController.class);

    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private ProductCategroyService productCategroyService;

    @GetMapping("/list")
    public ResultVO queryProductList() {

        //1.查询所有上架的商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        //2.查询类目（一次性查询类目）
        //List<Integer> categroyTypeList = new ArrayList<>();
        //传统的方法
        /*for (ProductInfo productInfo : productInfoList) {
            categroyTypeList.add(productInfo.getCategroyType());
        }*/
        //使用jdk1.8新特性
        List<Integer> categroyTypeList = productInfoList.stream()
                .map(e->e.getCategroyType())
                .collect(Collectors.toList());
        List<ProductCategroy> productCategroyList = productCategroyService.findByCategroyTypeIn(categroyTypeList);
        //3.数据的拼装
        List<ProductVO> productVOList  = new ArrayList<>();
        for (ProductCategroy productCategroy : productCategroyList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategroyName(productCategroy.getCategroyName());
            productVO.setCategroyType(productCategroy.getCategroyType());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategroyType().equals(productCategroy.getCategroyType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVos(productInfoVOList);
            productVOList.add(productVO);
        }
        //logger.info(JSONObject.toJSONString(productVOList));
        return ResultVoUtil.success(productVOList);
    }
}
