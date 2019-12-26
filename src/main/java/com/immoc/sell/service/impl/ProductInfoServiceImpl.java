package com.immoc.sell.service.impl;

import com.immoc.sell.dataobject.ProductInfo;
import com.immoc.sell.repository.ProductInfoRespository;
import com.immoc.sell.service.ProductInfoService;
import com.immoc.sell.util.ProductStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRespository productInfoRespository;

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoRespository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRespository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(PageRequest pageRequest) {
        return productInfoRespository.findAll(pageRequest);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRespository.save(productInfo);
    }
}
