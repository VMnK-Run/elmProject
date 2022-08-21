package com.elm.po;

public class DeliveryAddress {
    private Integer daId;
    private String contactName;
    private Integer contactSex;
    private String contactTel;
    private String address;
    private String userId;

    public Integer getDaId() {
        return daId;
    }

    public String getContactName() {
        return contactName;
    }

    public Integer getContactSex() {
        return contactSex;
    }

    public String getContactTel() {
        return contactTel;
    }

    public String getAddress() {
        return address;
    }

    public String getUserId() {
        return userId;
    }

    public void setDaId(Integer daId) {
        this.daId = daId;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactSex(Integer contactSex) {
        this.contactSex = contactSex;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
