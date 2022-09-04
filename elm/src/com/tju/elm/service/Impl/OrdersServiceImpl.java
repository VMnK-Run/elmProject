package com.tju.elm.service.Impl;

import com.tju.elm.dao.CartDao;
import com.tju.elm.dao.Impl.CartDaoImpl;
import com.tju.elm.dao.Impl.OrderDetailetDaoImpl;
import com.tju.elm.dao.Impl.OrdersDaoImpl;
import com.tju.elm.dao.OrderDetailetDao;
import com.tju.elm.dao.OrdersDao;
import com.tju.elm.po.Cart;
import com.tju.elm.po.OrderDetailet;
import com.tju.elm.po.Orders;
import com.tju.elm.service.OrdersService;
import com.tju.elm.util.DBUtil;

import java.util.ArrayList;
import java.util.List;

public class OrdersServiceImpl implements OrdersService {

    @Override
    public int createOrders(String userId, Integer businessId, Integer daId, Double orderTotal) {
        int orderId = 0;
        CartDao cartDao = new CartDaoImpl();
        OrdersDao orderDao = new OrdersDaoImpl();
        OrderDetailetDao orderDetailetDao = new OrderDetailetDaoImpl();

        try{
            DBUtil.beginTransaction(); // 开启一个事务

            // 1. 查询当前用户购物车中当前商家的所有食品，放入订单明细(从数据库中获取)
            Cart cart = new Cart();
            cart.setUserId(userId);
            cart.setBusinessId(businessId);
            List<Cart> list = new ArrayList<>();
            list = cartDao.listCart(cart);

            // 2. 创建一个订单，并获取订单编号(存入数据库中)
            Orders orders = new Orders();
            orders.setUserId(userId);
            orders.setBusinessId(businessId);
            orders.setOrderTotal(orderTotal);
            orders.setDaId(daId);
            orderId = orderDao.saveOrders(orders);

            // 3. 向订单明细表中批量添加明细数据(OrdersDetailet中)
            List<OrderDetailet> orderDetailetList = new ArrayList<>();
            for (Cart c : list) {
                OrderDetailet orderDetailet = new OrderDetailet();
                orderDetailet.setOrderId(orderId);
                orderDetailet.setFoodId(c.getFoodId());
                orderDetailet.setQuantity(c.getQuantity());
                orderDetailetList.add(orderDetailet);
            }

            int result = orderDetailetDao.saveOrderDetailetBatch(orderDetailetList);

            // 4. 清空购物车，条件为当前用户和当前商家
            cartDao.removeCart(cart);

            DBUtil.commitTransaction(); // 提交一个事务

        } catch (Exception e) {
            orderId = 0;
            try {
                DBUtil.rollbackTransaction(); // 回滚一个事务
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return orderId;
    }

    @Override
    public Orders getOrdersById(Integer orderId) {
        Orders orders = null;
        OrdersDao orderDao = new OrdersDaoImpl();
        OrderDetailetDao orderDetailetDao = new OrderDetailetDaoImpl();
        try {
            DBUtil.getConnection();

            // 1. 根据ID查询订单信息，包括商家信息
            orders = orderDao.getOrdersById(orderId);
            // 2. 根据订单ID查询订单明细信息
            List<OrderDetailet> list = orderDetailetDao.listOrderDetailetByOrderId(orderId);
            orders.setList(list);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }

        return orders;
    }

    @Override
    public List<Orders> listOrdersByUserId(String userId) throws Exception {
        List<Orders> list = new ArrayList<>();

        OrdersDao orderDao = new OrdersDaoImpl();
        OrderDetailetDao orderDetailetDao = new OrderDetailetDaoImpl();

        try {
            DBUtil.getConnection();

            // 1. 根据用户ID查询订单信息，包括商家信息
            list = orderDao.listOrdersByUserId(userId);
            // 2. 根据订单ID查询订单明细信息
            for(Orders orders : list) {
                orders.setList(orderDetailetDao.listOrderDetailetByOrderId(orders.getOrderId()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }

        return list;
    }
}
