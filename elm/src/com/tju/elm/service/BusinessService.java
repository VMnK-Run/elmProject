package com.tju.elm.service;

import com.tju.elm.po.Business;

import java.util.List;

public interface BusinessService {
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId);

    public Business getBusinessBuId(Integer businessId);
}
