package com.immoc.sell.repository;


import com.immoc.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRespository extends JpaRepository<OrderMaster,String> {


    /**
     * 根据openId查询所有的订单信息
     * @param openId
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByOpenId(String openId,Pageable pageable);
}
