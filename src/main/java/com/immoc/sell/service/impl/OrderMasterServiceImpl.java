package com.immoc.sell.service.impl;

import com.immoc.sell.dataobject.OrderDetail;
import com.immoc.sell.dataobject.ProductInfo;
import com.immoc.sell.dto.OrderDTO;
import com.immoc.sell.enums.ResultEnum;
import com.immoc.sell.enums.SellException;
import com.immoc.sell.repository.OrderDetailRespository;
import com.immoc.sell.repository.OrderMasterRespository;
import com.immoc.sell.service.OrderMasterService;
import com.immoc.sell.service.ProductInfoService;
import com.immoc.sell.util.GetSequence16;
import com.immoc.sell.util.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class OrderMasterServiceImpl implements OrderMasterService {

    @Autowired
    private OrderMasterRespository orderMasterRespository;
    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private OrderDetailRespository orderDetailRespository;


    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        BigDecimal orderAmount = new BigDecimal(0);
        //1.需要查询商品价格等
        String orderId = GetSequence16.getSequence16();
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
          ProductInfo productInfo = productInfoService.findOne(orderDetail.getProductId());
          if (productInfo == null) {
              throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
          }
            //2.计算订单总价格
            orderAmount = orderDetail.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);
          //订单详情入口
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            orderDetailRespository.save(orderDetail);
        }
        //3.写入订单表和订单详情表
        //4.扣除库存
        return null;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String orderId, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
