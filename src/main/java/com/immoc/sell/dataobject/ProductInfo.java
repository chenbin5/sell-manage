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


    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductIcon() {
        return productIcon;
    }

    public Integer getCategroyType() {
        return categroyType;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }

    public void setCategroyType(Integer categroyType) {
        this.categroyType = categroyType;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
