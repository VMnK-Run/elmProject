package com.tju.elm.dao.impl;

import com.tju.elm.dao.AdminDao;
import com.tju.elm.po.Admin;
import com.tju.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 如果返回null，则说明没有查询到数据
public class AdminDaoImpl implements AdminDao {

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public Admin getAdminByNameByPassword(String adminName, String password) {
        Admin admin = null;
        String sql = "select * from admin where adminName=? and password=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);// 预编译
            pst.setString(1, adminName); // 设置参数
            pst.setString(2, password);
            rs = pst.executeQuery();
            while(rs.next()) {
                // 把数据库中的数据封装到Admin
                // 数据库数据转为java对象
                admin = new Admin();
                admin.setAdminId(rs.getInt("adminId"));
                admin.setAdminName(rs.getString("adminName"));
                admin.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 必须释放资源
            DBUtil.closeConnection(rs, pst, con);
        }
        return admin;
    }
}
