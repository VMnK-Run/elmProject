package com.tju.elmboot.controller;

import com.tju.elmboot.po.DeliveryAddress;
import com.tju.elmboot.service.DeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/DeliveryAddressController")
public class DeliveryAddressController {

    @Autowired
    private DeliveryAddressService deliveryAddressService;

    @RequestMapping("/listDeliveryAddressByUserId")
    public List<DeliveryAddress> listDeliveryAddressByUserId(DeliveryAddress deliveryAddress){
        return deliveryAddressService.listDeliveryAddressByUserId(deliveryAddress.getUserId());
    }
}
