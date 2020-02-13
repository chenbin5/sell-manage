package com.immoc.sell.dataobject;

import com.immoc.sell.enums.OrderStatusEnum;
import com.immoc.sell.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单实体
 */
@Entity
@Data
public class OrderMaster {

    /**
     * 订单id
     */
    @Id
    private String orderId;

    /**
     * 买家姓名
     */
    private String buyerName;

    /**
     * 买家手机号
     */
    private String buyerPhone;

    /**
     * 买家地址
     */
    private String buyerAddress;

    /**
     * 买家微信openId
     */
    private String openId;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态，默认为0新下单
     */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /**
     * 支付状态，默认为待支付
     */
    private Integer payStatus = PayStatusEnum.NEW.getCode();

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @Transient
    private List<OrderDetail> orderDetailList;

    public String getOrderId() {
        return orderId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public String getOpenId() {
        return openId;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
