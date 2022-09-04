package com.tju.elm.dao.Impl;

import com.tju.elm.dao.OrderDetailetDao;
import com.tju.elm.po.Food;
import com.tju.elm.po.OrderDetailet;
import com.tju.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailetDaoImpl implements OrderDetailetDao {

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public int saveOrderDetailetBatch(List<OrderDetailet> list) throws Exception {
        int result = 0;
        StringBuilder stringBuilder = new StringBuilder("insert into orderdetailet(orderId, foodId, quantity) values");
        for (OrderDetailet od : list) {
            stringBuilder.append("(").append(od.getOrderId()).append(",").append(od.getFoodId()).append(",").append(od.getQuantity()).append(")").append(",");
        }
        String sql = stringBuilder.toString().substring(0, stringBuilder.length() - 1);
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql.toString());
            result = pst.executeUpdate();
        } finally {
            DBUtil.close(pst);
        }
        return result;
    }

    @Override
    public List<OrderDetailet> listOrderDetailetByOrderId(Integer orderId) throws Exception {
        List<OrderDetailet> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(" select o.*, ");
        sql.append("        f.foodId ffoodId, ");
        sql.append("        f.foodName ffoodName, ");
        sql.append("        f.foodPrice ffoodPrice ");
        sql.append(" from OrderDetailet o left join food f on o.foodId=f.foodId ");
        sql.append(" where o.orderId=?");
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql.toString());
            pst.setInt(1, orderId);
            rs = pst.executeQuery();
            while (rs.next()) {
                OrderDetailet od = new OrderDetailet();
                od.setOdId(rs.getInt("odId"));
                od.setOrderId(rs.getInt("orderId"));
                od.setFoodId(rs.getInt("foodId"));
                od.setQuantity(rs.getInt("quantity"));

                Food food = new Food();
                food.setFoodId(rs.getInt("ffoodId"));
                food.setFoodName(rs.getString("ffoodName"));
                food.setFoodPrice(rs.getDouble("ffoodPrice"));
                od.setFood(food);

                list.add(od);
            }
        } finally {
            DBUtil.close(pst);
        }
        return list;
    }
}
