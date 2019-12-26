package com.immoc.sell.dataobject;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;
    /**商品名称*/
    private String productName;
    /**商品价格*/
    private BigDecimal productPrice;
    /**商品描述*/
    private String productDescription;
    /**商品图片*/
    private String productIcon;
    /**商品类目编号*/
    private Integer categroyType;
    /**商品库存*/
    private Integer productStock;
    /**商品状态 0：上架 1：下架*/
    private Integer productStatus;
    /**创建时间*/
    private Date createTime;
    /**更新时间*/
    private Date updateTime;




}
