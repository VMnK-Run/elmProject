package com.tju.elm.dao.Impl;

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
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) throws Exception {
        List<Business> list = new ArrayList<>();
        String sql = "select * from business where orderTypeId=? order by businessId";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, orderTypeId);
            rs = pst.executeQuery();
            while(rs.next()) {
                Business business = new Business();
                createBusiness(business);
                list.add(business);
            }
        } finally {
            DBUtil.close(rs, pst);
        }

        return list;
    }

    @Override
    public Business getBusinessById(Integer businessId) throws Exception {
        Business business = null;
        String sql = "select * from business where businessId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, businessId);
            rs = pst.executeQuery();
            while(rs.next()) {
                business = new Business();
                createBusiness(business);
            }
        } finally {
            DBUtil.close(rs, pst);
        }
        return business;
    }

    private void createBusiness(Business business) throws SQLException {
        business.setBusinessId(rs.getInt("businessId"));
        business.setBusinessName(rs.getString("businessName"));
        business.setBusinessAddress(rs.getString("businessAddress"));
        business.setBusinessExplain(rs.getString("businessExplain"));
        business.setBusinessImg(rs.getString("businessImg"));
        business.setOrderTypeId(rs.getInt("orderTypeId"));
        business.setStarPrice(rs.getDouble("starPrice"));
        business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
        business.setRemarks(rs.getString("remarks"));
    }
}
