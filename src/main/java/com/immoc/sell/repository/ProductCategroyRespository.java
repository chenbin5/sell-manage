package com.immoc.sell.repository;

import com.immoc.sell.dataobject.ProductCategroy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategroyRespository extends JpaRepository<ProductCategroy, Integer> {


    /**
     * 查询类目信息
     * @param categroyType
     * @return
     */
   List<ProductCategroy> findByCategroyTypeIn(List<Integer> categroyType);
}
