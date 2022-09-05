package com.tju.elmboot.service;

import com.tju.elmboot.po.DeliveryAddress;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DeliveryAddressService {

    public List<DeliveryAddress> listDeliveryAddressByUserId(String userId);
}
