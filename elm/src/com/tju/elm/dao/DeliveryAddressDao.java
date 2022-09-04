package com.tju.elm.dao;

import com.tju.elm.po.DeliveryAddress;

import java.util.List;

public interface DeliveryAddressDao {

    public List<DeliveryAddress> listDeliveryAddressesByUserId(String userId) throws Exception;
    public int saveDeliveryAddresses(DeliveryAddress deliveryAddress) throws Exception;
    public DeliveryAddress getDeliveryAddressById(Integer daId) throws Exception;
    public int updateDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception;
    public int removeDeliveryAddress(Integer daId) throws Exception;
}
