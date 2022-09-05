package com.tju.elmboot.service.impl;

import com.tju.elmboot.mapper.DeliveryAddressMapper;
import com.tju.elmboot.po.DeliveryAddress;
import com.tju.elmboot.service.DeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {

    @Autowired
    private DeliveryAddressMapper deliveryAddressMapper;

    @Override
    public List<DeliveryAddress> listDeliveryAddressByUserId(String userId) {
        return deliveryAddressMapper.listDeliveryAddressByUserId(userId);
    }
}
