package com.tju.elm.dao.Impl;

import com.tju.elm.dao.OrdersDao;
import com.tju.elm.po.Business;
import com.tju.elm.po.Orders;
import com.tju.elm.util.Common;
import com.tju.elm.util.DBUtil;

import javax.persistence.criteria.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrdersDaoImpl implements OrdersDao {

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public int saveOrders(Orders orders) throws Exception {
        int orderId = 0;
        String sql = "insert into orders values(null,?,?,?,?,?)";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, orders.getUserId());
            pst.setInt(2, orders.getBusinessId());
            pst.setString(3, Common.getCurrentDate());
            pst.setDouble(4, orders.getOrderTotal());
            pst.setInt(5, orders.getDaId());
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();// 获取自增长列值(一行一列)
            if(rs.next()) {
                orderId = rs.getInt(1);
            }
        } finally {
            DBUtil.close(pst);
        }
        return orderId;
    }

    @Override
    public Orders getOrdersById(Integer orderId) throws Exception {
        Orders orders = null;
        StringBuilder sql = new StringBuilder();
        sql.append(" select o.*, ");
        sql.append("        b.businessId bbusinessId, ");
        sql.append("        b.businessName bbusinessName, ");
        sql.append("        b.deliveryPrice bdeliveryPrice ");
        sql.append(" from orders o left join business b on o.businessId=b.businessId ");
        sql.append(" where o.orderId=? ");
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql.toString());
            pst.setInt(1, orderId);
            rs = pst.executeQuery();
            while(rs.next()) {
                orders = new Orders();
                orders.setOrderId(rs.getInt("orderId"));
                orders.setUserId(rs.getString("userId"));
                orders.setBusinessId(rs.getInt("businessId"));
                orders.setOrderDate(rs.getString("orderDate"));
                orders.setOrderTotal(rs.getDouble("orderTotal"));
                orders.setDaId(rs.getInt("daId"));
                orders.setOrderState(rs.getInt("orderState"));

                Business business = new Business();
                business.setBusinessId(rs.getInt("bbusinessId"));
                business.setBusinessName(rs.getString("bbusinessName"));
                business.setDeliveryPrice(rs.getDouble("bdeliveryPrice"));
                orders.setBusiness(business);
            }
        } finally {
            DBUtil.close(rs, pst);
        }
        return orders;
    }

    @Override
    public List<Orders> listOrdersByUserId(String userId) throws Exception {
        List<Orders> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(" select o.*, ");
        sql.append("        b.businessId bbusinessId, ");
        sql.append("        b.businessName bbusinessName, ");
        sql.append("        b.deliveryPrice bdeliveryPrice ");
        sql.append(" from orders o left join business b on o.businessId=b.businessId ");
        sql.append(" where o.userId=? ");
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql.toString());
            pst.setString(1, userId);
            rs = pst.executeQuery();
            while (rs.next()) {
                Orders orders = new Orders();
                orders.setOrderId(rs.getInt("orderId"));
                orders.setUserId(rs.getString("userId"));
                orders.setBusinessId(rs.getInt("businessId"));
                orders.setOrderDate(rs.getString("orderDate"));
                orders.setOrderTotal(rs.getDouble("orderTotal"));
                orders.setDaId(rs.getInt("daId"));
                orders.setOrderState(rs.getInt("orderState"));

                Business business = new Business();
                business.setBusinessId(rs.getInt("bbusinessId"));
                business.setBusinessName(rs.getString("bbusinessName"));
                business.setDeliveryPrice(rs.getDouble("bdeliveryPrice"));
                orders.setBusiness(business);

                list.add(orders);
            }
        } finally {
            DBUtil.close(rs, pst);
        }
        return list;
    }

}
