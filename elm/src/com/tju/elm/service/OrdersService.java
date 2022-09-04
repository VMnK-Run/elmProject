package com.tju.elm.service;

import com.tju.elm.po.Orders;

import java.util.List;

public interface OrdersService {

    public int createOrders(String userId, Integer businessId, Integer daId, Double orderTotal);
    public Orders getOrdersById(Integer orderId);
    public List<Orders> listOrdersByUserId(String userId) throws Exception;
}
