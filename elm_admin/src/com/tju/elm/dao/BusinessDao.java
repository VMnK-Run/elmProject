package com.tju.elm.dao;

import com.tju.elm.po.Business;

import java.util.List;

public interface BusinessDao {
    // Dao层负责和数据库的交互，不要有输入输出在这里面
    public List<Business> listBusiness(String businessName, String businessAddress);
    public int saveBusiness(String businessName);
    public int removeBusiness(int businessId);

    public Business getBusinessByIdByPassword(Integer businessId, String password);
    public Business getBusinessById(Integer businessID);

    public int updateBusiness(Business business);
    public int updatePassword(Integer businessID, String password);
}
