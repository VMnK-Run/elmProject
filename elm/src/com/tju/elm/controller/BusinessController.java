package com.tju.elm.controller;

import com.tju.elm.po.Business;
import com.tju.elm.service.BusinessService;
import com.tju.elm.service.Impl.BusinessServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class BusinessController {

    public Object listBusinessByOrderTypeId(HttpServletRequest request) throws Exception{
        Integer orderTypeId = Integer.valueOf(request.getParameter("orderTypeId"));
        BusinessService service = new BusinessServiceImpl();
        List<Business> list = service.listBusinessByOrderTypeId(orderTypeId);
        return list;
    }

    public Object getBusinessById(HttpServletRequest request) throws Exception {
        Integer businessId = Integer.valueOf(request.getParameter("businessId"));
        BusinessService service = new BusinessServiceImpl();
        Business business = service.getBusinessBuId(businessId);
        return business;
    }
}
