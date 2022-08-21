package com.elm.po;

import java.util.List;

public class Orders {
    private Integer orderId;
    private String userId;
    private Integer businessId;
    private String orderDate;
    private Double orderTotal;
    private Integer daId; //送货地址编号
    private Integer orderState; //订单状态（0：未支付； 1：已支付）

    //Many-to-one: Merchants
    private Business business;
    //One-to-many: order details
    private List<OrderDetailet> list;

    public Integer getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public Integer getDaId() {
        return daId;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public Business getBusiness() {
        return business;
    }

    public List<OrderDetailet> getList() {
        return list;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public void setDaId(Integer daId) {
        this.daId = daId;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public void setList(List<OrderDetailet> list) {
        this.list = list;
    }
}
