package com.tju.elm.controller;

import com.tju.elm.po.DeliveryAddress;
import com.tju.elm.service.DeliveryAddressService;
import com.tju.elm.service.Impl.DeliveryAddressServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DeliveryAddressController {
    public Object listDeliveryAddressesByUserId(HttpServletRequest request) throws Exception{
        String userId = request.getParameter("userId");
        DeliveryAddressService service = new DeliveryAddressServiceImpl();
        List<DeliveryAddress> list = service.listDeliveryAddressesByUserId(userId);
        return list;
    }

    public Object saveDeliveryAddresses(HttpServletRequest request) throws Exception {
        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setContactName(request.getParameter("contactName"));
        deliveryAddress.setContactSex(Integer.valueOf(request.getParameter("contactSex")));
        deliveryAddress.setContactTel(request.getParameter("contactTel"));
        deliveryAddress.setAddress(request.getParameter("address"));
        deliveryAddress.setUserId(request.getParameter("userId"));
        DeliveryAddressService service = new DeliveryAddressServiceImpl();
        return service.saveDeliveryAddresses(deliveryAddress);
    }

    public Object getDeliveryAddressById(HttpServletRequest request) throws Exception {
        Integer daId = Integer.valueOf(request.getParameter("daId"));
        DeliveryAddressService service = new DeliveryAddressServiceImpl();
        DeliveryAddress deliveryAddress = service.getDeliveryAddressById(daId);
        return deliveryAddress;
    }

    public Object updateDeliveryAddress(HttpServletRequest request) throws Exception {
        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setContactName(request.getParameter("contactName"));
        deliveryAddress.setContactSex(Integer.valueOf(request.getParameter("contactSex")));
        deliveryAddress.setContactTel(request.getParameter("contactTel"));
        deliveryAddress.setAddress(request.getParameter("address"));
        deliveryAddress.setDaId(Integer.valueOf(request.getParameter("daId")));
        DeliveryAddressService service = new DeliveryAddressServiceImpl();
        return service.updateDeliveryAddress(deliveryAddress);
    }

    public Object removeDeliveryAddress(HttpServletRequest request) throws Exception {
        DeliveryAddressService service = new DeliveryAddressServiceImpl();
        Integer daId = Integer.valueOf(request.getParameter("daId"));
        return service.removeDeliveryAddress(daId);
    }
}
