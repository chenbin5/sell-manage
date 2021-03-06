package com.immoc.sell.enums;


import lombok.Getter;

/**
 * 订单状态
 */
@Getter
public enum OrderStatusEnum implements CodeEnum{

    NEW(0,"下单"),
    FINISH(1,"完成"),
    CANCEL(2,"取消");

    private Integer code;
    private String message;

    OrderStatusEnum(Integer code,String message) {
        this.code = code;
        this.message = message;
    }
}
