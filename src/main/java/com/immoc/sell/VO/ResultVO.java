package com.immoc.sell.VO;

import lombok.Data;

/**
 * 返回前端对象
 */
@Data
public class ResultVO<T> {

    /**状态码*/
    private Integer code;
    /**提示信息*/
    private String msg;
    /**返回对象*/
    private T data;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }
}
