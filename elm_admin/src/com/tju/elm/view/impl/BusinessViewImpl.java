package com.tju.elm.view.impl;

import com.tju.elm.dao.BusinessDao;
import com.tju.elm.dao.impl.BusinessDaoImpl;
import com.tju.elm.po.Business;
import com.tju.elm.view.BusinessView;

import java.util.List;
import java.util.Scanner;

public class BusinessViewImpl implements BusinessView {

    private Scanner input = new Scanner(System.in);

    @Override
    public void listBusinessAll() {
        BusinessDao businessDao = new BusinessDaoImpl();
        List<Business> list = businessDao.listBusiness(null, null);
        System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
        for (Business business : list) {
            System.out.println(business.getBusinessId() + "\t" + business.getBusinessName() + "\t" +
                                business.getBusinessAddress() + "\t" + business.getBusinessExplain() + "\t" +
                                business.getStartPrice() + "\t" + business.getDeliveryPrice());
        }
    }

    @Override
    public void listBusiness() {
        String inputStr = "";
        String businessName = "";
        String businessAddress = "";
        System.out.println("是否需要输入商家名称关键词(y/n)");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入商家名称关键词");
            businessName = input.next();
        }
        System.out.println("是否需要输入商家地址关键词(y/n)");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入商家地址关键词");
            businessAddress = input.next();
        }
        BusinessDao businessDao = new BusinessDaoImpl();
        List<Business> list = businessDao.listBusiness(businessName, businessAddress);
        System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
        for (Business business : list) {
            System.out.println(business.getBusinessId() + "\t" + business.getBusinessName() + "\t" +
                    business.getBusinessAddress() + "\t" + business.getBusinessExplain() + "\t" +
                    business.getStartPrice() + "\t" + business.getDeliveryPrice());
        }
    }

    @Override
    public void saveBusiness() {
        System.out.println("请输入商家名称");
        String businessName = input.next();
        BusinessDao businessDao = new BusinessDaoImpl();
        int businessId = businessDao.saveBusiness(businessName);
        if (businessId > 0) {
            System.out.println("新建商家成功！商家编号为：" + businessId);
        } else {
            System.out.println("新建商家失败！");
        }
    }

    @Override
    public void removeBusiness() {
        System.out.println("请输入商家编号");
        int businessId = input.nextInt();
        BusinessDao businessDao = new BusinessDaoImpl();
        System.out.println("确认要删除吗?(y/n)");
        if(input.next().equals("y")) {
            int result = businessDao.removeBusiness(businessId);
            if(result == 1) {
                System.out.println("删除商家成功！");
            } else {
                System.out.println("删除商家失败！");
            }
        }
    }
}
