package com.tju.elm.service.Impl;

import com.tju.elm.dao.BusinessDao;
import com.tju.elm.dao.Impl.BusinessDaoImpl;
import com.tju.elm.po.Business;
import com.tju.elm.service.BusinessService;
import com.tju.elm.util.DBUtil;

import java.util.ArrayList;
import java.util.List;

public class BusinessServiceImpl implements BusinessService {
    @Override
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) {
        List<Business> list = new ArrayList<Business>();
        BusinessDao dao = new BusinessDaoImpl();
        try{
            DBUtil.getConnection();
            list = dao.listBusinessByOrderTypeId(orderTypeId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return list;
    }

    @Override
    public Business getBusinessBuId(Integer businessId) {
        Business business = null;
        BusinessDao dao = new BusinessDaoImpl();
        try {
            DBUtil.getConnection();
            business = dao.getBusinessById(businessId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return business;
    }
}
