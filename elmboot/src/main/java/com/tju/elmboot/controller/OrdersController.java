package com.tju.elmboot.controller;

import com.tju.elmboot.mapper.OrdersMapper;
import com.tju.elmboot.po.Orders;
import com.tju.elmboot.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/OrdersController")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/createOrders")
    public int createOrders(Orders orders) {
        return ordersService.createOrders(orders);
    }

}
