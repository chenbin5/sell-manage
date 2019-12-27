package com.immoc.sell.service;

import com.immoc.sell.dataobject.ProductInfo;
import com.immoc.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

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

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void descreaseStock(List<CartDTO> cartDTOList);
}
