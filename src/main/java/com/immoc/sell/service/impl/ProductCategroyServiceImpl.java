package com.immoc.sell.service.impl;

import com.immoc.sell.dataobject.ProductCategroy;
import com.immoc.sell.repository.ProductCategroyRespository;
import com.immoc.sell.service.ProductCategroyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductCategroyServiceImpl implements ProductCategroyService {

    @Autowired
    private ProductCategroyRespository productCategroyRespository;

    @Override
    public ProductCategroy findOne(Integer catagroyId) {
        return productCategroyRespository.findOne(catagroyId);
    }

    @Override
    public List<ProductCategroy> findAll() {
        return productCategroyRespository.findAll();
    }

    @Override
    public List<ProductCategroy> findByCategroyTypeIn(List<Integer> categroyType) {
        return productCategroyRespository.findByCategroyTypeIn(categroyType);
    }

    @Override
    public ProductCategroy save(ProductCategroy productCategroy) {
        return productCategroyRespository.save(productCategroy);
    }
}
