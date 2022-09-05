package com.tju.elmboot.mapper;

import com.tju.elmboot.po.DeliveryAddress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeliveryAddressMapper {

    @Select("select * from deliveryAddress where userId=#{userId} order by daId")
    public List<DeliveryAddress> listDeliveryAddressByUserId(String userId);
}
