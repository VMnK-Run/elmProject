package com.tju.elm.dao;

import com.tju.elm.po.OrderDetailet;

import java.util.List;

public interface OrderDetailetDao {

    public int saveOrderDetailetBatch(List<OrderDetailet> list) throws Exception;
    public List<OrderDetailet> listOrderDetailetByOrderId(Integer orderId) throws Exception;
}
