package com.immoc.sell.enums;

import lombok.Getter;

/**
 * 支付状态枚举
 */
@Getter
public enum PayStatusEnum implements CodeEnum {

    NEW(0,"等待支付"),
    FINISH(1,"支付完成");

    private Integer code;
    private String message;

    PayStatusEnum(Integer code,String message) {
        this.code = code;
        this.message = message;
    }
}
