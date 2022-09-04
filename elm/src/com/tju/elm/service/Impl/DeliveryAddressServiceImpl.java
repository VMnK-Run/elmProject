package com.tju.elm.service.Impl;

import com.tju.elm.dao.DeliveryAddressDao;
import com.tju.elm.dao.Impl.DeliveryAddressDaoImpl;
import com.tju.elm.po.DeliveryAddress;
import com.tju.elm.service.DeliveryAddressService;
import com.tju.elm.util.DBUtil;

import java.util.ArrayList;
import java.util.List;

public class DeliveryAddressServiceImpl implements DeliveryAddressService {
    @Override
    public List<DeliveryAddress> listDeliveryAddressesByUserId(String userId) {
        List<DeliveryAddress> list = new ArrayList<DeliveryAddress>();
        DeliveryAddressDao dao = new DeliveryAddressDaoImpl();
        try{
            DBUtil.getConnection();
            list = dao.listDeliveryAddressesByUserId(userId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return list;
    }

    @Override
    public int saveDeliveryAddresses(DeliveryAddress deliveryAddress) {
        int result = 0;
        DeliveryAddressDao dao = new DeliveryAddressDaoImpl();
        try {
            DBUtil.getConnection();
            result = dao.saveDeliveryAddresses(deliveryAddress);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return result;
    }

    @Override
    public DeliveryAddress getDeliveryAddressById(Integer daId) {
        DeliveryAddress deliveryAddress = null;
        DeliveryAddressDao dao = new DeliveryAddressDaoImpl();
        try {
            DBUtil.getConnection();
            deliveryAddress = dao.getDeliveryAddressById(daId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return deliveryAddress;
    }

    @Override
    public int updateDeliveryAddress(DeliveryAddress deliveryAddress) {
        int result = 0;
        DeliveryAddressDao dao = new DeliveryAddressDaoImpl();
        try {
            DBUtil.getConnection();
            result = dao.updateDeliveryAddress(deliveryAddress);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return result;
    }

    @Override
    public int removeDeliveryAddress(Integer daId) {
        int result = 0;
        DeliveryAddressDao dao = new DeliveryAddressDaoImpl();
        try {
            DBUtil.getConnection();
            result = dao.removeDeliveryAddress(daId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return result;
    }
}
