package com.elm.po;

public class Business {
    private Integer businessId;
    private String businessName;
    private String businessAddress;
    private String businessExplain;
    private String businessImg;
    private Integer orderTypeId;
    private double starPrice;
    private double deliveryPrice;
    private String remarks;

    public Integer getBusinessId() {
        return businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public String getBusinessExplain() {
        return businessExplain;
    }

    public String getBusinessImg() {
        return businessImg;
    }

    public Integer getOrderTypeId() {
        return orderTypeId;
    }

    public double getStarPrice() {
        return starPrice;
    }

    public double getDeliveryPrice() {
        return deliveryPrice;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public void setBusinessExplain(String businessExplain) {
        this.businessExplain = businessExplain;
    }

    public void setBusinessImg(String businessImg) {
        this.businessImg = businessImg;
    }

    public void setOrderTypeId(Integer orderTypeId) {
        this.orderTypeId = orderTypeId;
    }

    public void setStarPrice(double starPrice) {
        this.starPrice = starPrice;
    }

    public void setDeliveryPrice(double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
