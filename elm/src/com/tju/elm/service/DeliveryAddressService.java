package com.tju.elm.service;

import com.tju.elm.po.DeliveryAddress;

import java.util.List;

public interface DeliveryAddressService {
    public List<DeliveryAddress> listDeliveryAddressesByUserId(String userId);
    public int saveDeliveryAddresses(DeliveryAddress deliveryAddress);
    public DeliveryAddress getDeliveryAddressById(Integer daId);
    public int updateDeliveryAddress(DeliveryAddress deliveryAddress);
    public int removeDeliveryAddress(Integer daId);
}
