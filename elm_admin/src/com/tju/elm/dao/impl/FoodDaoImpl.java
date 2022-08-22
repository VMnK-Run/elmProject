package com.tju.elm.dao.impl;

import com.tju.elm.dao.FoodDao;
import com.tju.elm.po.Business;
import com.tju.elm.po.Food;
import com.tju.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl implements FoodDao {

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        List<Food> list = new ArrayList<Food>();
        String sql = "select * from food where businessId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql); // 预编译
            pst.setInt(1, businessId);
            rs = pst.executeQuery();
            while(rs.next()) {
                // 把数据库中的数据封装到Admin
                // 数据库数据转为java对象
                Food food = new Food();
                food.setFoodId(rs.getInt("foodId"));
                food.setFoodName(rs.getString("foodName"));
                food.setFoodExplain(rs.getString("foodExplain"));
                food.setFoodPrice(rs.getDouble("foodPrice"));
                food.setBusinessId(rs.getInt("businessId"));
                list.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 必须释放资源
            DBUtil.closeConnection(rs, pst, con);
        }
        return list;
    }

    @Override
    public int saveFood(Food food) {
        int res = 0;
        String sql = "insert into food values(null, ?, ?, ?, ?)";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, food.getFoodName());
            pst.setString(2, food.getFoodExplain());
            pst.setDouble(3, food.getFoodPrice());
            pst.setInt(4, food.getBusinessId());
            res = pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 必须释放资源
            DBUtil.closeConnection(null, pst, con);
        }
        return res;
    }

    @Override
    public Food getFoodByFoodId(Integer foodId) {
        Food food = null;
        String sql = "select * from food where foodId=?";
        try{
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, foodId);
            rs = pst.executeQuery();
            while(rs.next()) {
                food = new Food();
                food.setFoodId(rs.getInt("foodId"));
                food.setFoodName(rs.getString("foodName"));
                food.setFoodExplain(rs.getString("foodExplain"));
                food.setFoodPrice(rs.getDouble("foodPrice"));
                food.setBusinessId(rs.getInt("businessId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(rs, pst, con);
        }

        return food;
    }

    @Override
    public int updateFood(Food food) {
        //只做和数据库的交互，修改的信息需要在参数中，因此不调用上面的get方法，把这一步交给view层
        int res = 0;
        String sql = "update food set foodName=?, foodExplain=?, foodPrice=? where foodId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, food.getFoodName());
            pst.setString(2, food.getFoodExplain());
            pst.setDouble(3, food.getFoodPrice());
            pst.setInt(4, food.getFoodId());
            res = pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 必须释放资源
            DBUtil.closeConnection(null, pst, con);
        }
        return res;
    }

    @Override
    public int removeFood(Integer foodId) {
        int res = 0;
        String sql = "delete from food where foodId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, foodId);
            res = pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 必须释放资源
            DBUtil.closeConnection(null, pst, con);
        }
        return res;
    }
}
