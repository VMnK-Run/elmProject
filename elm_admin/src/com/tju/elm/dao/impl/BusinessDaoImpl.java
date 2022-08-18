package com.tju.elm.dao.impl;

import com.tju.elm.dao.BusinessDao;
import com.tju.elm.po.Business;
import com.tju.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessDaoImpl implements BusinessDao {

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public List<Business> listBusiness(String businessName, String businessAddress) {
        List<Business> list = new ArrayList<Business>();
        StringBuilder sql = new StringBuilder("select * from business where 1=1 ");
        if(businessName != null && !businessName.equals("")) {
            sql.append("and businessName like '%").append(businessName).append("%' ");
        }
        if(businessAddress != null && !businessAddress.equals("")) {
            sql.append("and businessAddress like '%").append(businessAddress).append("%' ");
        }
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(String.valueOf(sql)); // 预编译
            rs = pst.executeQuery();
            while(rs.next()) {
                // 把数据库中的数据封装到Admin
                // 数据库数据转为java对象
                Business business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setStartPrice(rs.getDouble("startPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                list.add(business);
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
    public int saveBusiness(String businessName) {
        int businessId = 0;
        String sql = "insert into business(businessName, password) values(?, '123')";// 设置初始密码
        try {
            con = DBUtil.getConnection();
            // 设置返回自增长列值
            pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS); // 预编译
            pst.setString(1, businessName);
            pst.executeUpdate();
            // 获取自增长的列值(一行一列)
            rs = pst.getGeneratedKeys();
            if(rs.next()) {
                businessId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 必须释放资源
            DBUtil.closeConnection(rs, pst, con);
        }
        return businessId;
    }

    @Override
    public int removeBusiness(int businessId) {
        // 先删子表
        int res = 0;
        String delFoodSql = "delete from food where businessId=?";
        String delBusinessSql = "delete from business where businessId=?";
        try {
            con = DBUtil.getConnection();
            // 开启一个事务
            con.setAutoCommit(false); // 不自动提交事务
            pst = con.prepareStatement(delFoodSql);
            pst.setInt(1, businessId);
            pst.executeUpdate();

            pst = con.prepareStatement(delBusinessSql);
            pst.setInt(1, businessId);
            res = pst.executeUpdate();

            // 提交事务
            con.commit();

        } catch (SQLException e) {
            res = 0;
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // 必须释放资源
            DBUtil.closeConnection(null, pst, con);
        }
        return res;
    }
}
