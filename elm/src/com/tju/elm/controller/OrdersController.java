package com.tju.elm.controller;

import com.tju.elm.po.Orders;
import com.tju.elm.service.Impl.OrdersServiceImpl;
import com.tju.elm.service.OrdersService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class OrdersController {

    public Object createOrders(HttpServletRequest request) throws Exception{
        String userId = request.getParameter("userId");
        Integer businessId = Integer.valueOf(request.getParameter("businessId"));
        Integer daId = Integer.valueOf(request.getParameter("daId"));
        Double orderTotal = Double.valueOf(request.getParameter("orderTotal"));

        OrdersService service = new OrdersServiceImpl();
        int orderId = service.createOrders(userId, businessId, daId, orderTotal);
        return orderId;
    }

    public Object getOrderId(HttpServletRequest request) throws Exception{
        Integer orderId = Integer.valueOf(request.getParameter("orderId"));
        OrdersService service = new OrdersServiceImpl();
        Orders orders = service.getOrdersById(orderId);
        return orders;
    }

    public Object listOrdersByUserId(HttpServletRequest request) throws Exception {
        List<Orders> list;
        String userId = request.getParameter("userId");
        OrdersService service = new OrdersServiceImpl();
        list = service.listOrdersByUserId(userId);
        return list;
    }
}
