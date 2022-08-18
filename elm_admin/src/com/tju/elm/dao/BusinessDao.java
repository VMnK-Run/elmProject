package com.tju.elm.dao;

import com.tju.elm.po.Business;

import java.util.List;

public interface BusinessDao {

    public List<Business> listBusiness(String businessName, String businessAddress);
    public int saveBusiness(String businessName);
    public int removeBusiness(int businessId);
}
