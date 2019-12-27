package com.immoc.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品包含类目信息
 */
@Data
public class ProductVO {

    /**类目名称*/
    @JsonProperty("name")
    private String categroyName;
    /**类目类型*/
    @JsonProperty("type")
    private Integer categroyType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVos;

}
