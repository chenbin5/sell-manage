package com.immoc.sell.service;

import com.immoc.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductInfoService {

    ProductInfo findOne(String productId);

    /**
     * 查询所有上架的商品
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询所有的商品
     * @param pageRequest
     * @return
     */
    Page<ProductInfo> findAll(PageRequest pageRequest);

    ProductInfo save(ProductInfo productInfo);

    //减库存

    //加库存
}
