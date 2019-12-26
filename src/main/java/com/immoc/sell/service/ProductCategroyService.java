package com.immoc.sell.service;

import com.immoc.sell.dataobject.ProductCategroy;

import java.util.List;

/**
 * 商品类目服务
 */
public interface ProductCategroyService {

    ProductCategroy findOne(Integer catagroyId);

    List<ProductCategroy> findAll();

    List<ProductCategroy> findByCategroyTypeIn(List<Integer> categroyType);

    ProductCategroy save(ProductCategroy productCategroy);
}
