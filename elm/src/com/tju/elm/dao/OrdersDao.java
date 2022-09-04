package com.tju.elm.dao;

import com.tju.elm.po.Orders;

import java.util.List;

public interface OrdersDao {

    public int saveOrders(Orders orders) throws Exception;
    public Orders getOrdersById(Integer orderId) throws Exception;
    public List<Orders> listOrdersByUserId(String userId) throws Exception;

}
