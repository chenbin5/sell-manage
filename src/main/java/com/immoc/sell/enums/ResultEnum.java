package com.immoc.sell.enums;

import lombok.Getter;

@Getter
public enum ResultEnum implements CodeEnum{

    PRODUCT_NOT_EXIST(10,"商品不存在");
    private Integer code;
    private String message;

    ResultEnum(Integer code,String message) {
        this.code = code;
        this.message = message;
    }
}
