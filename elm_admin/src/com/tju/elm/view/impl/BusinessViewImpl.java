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

    @Override
    public Business logIn() {
        System.out.println("请输入商家编号：");
        int businessId = input.nextInt();
        System.out.println("请输入密码：");
        String password = input.next();
        BusinessDao businessDao = new BusinessDaoImpl();
        return businessDao.getBusinessByIdByPassword(businessId, password);
    }

    @Override
    public void showBusiness(Integer businessId) {
        BusinessDao businessDao = new BusinessDaoImpl();
        Business business = businessDao.getBusinessById(businessId);
        System.out.println(business.toString());
    }

    @Override
    public void editBusiness(Integer businessId) {
        // 先显示原信息，再更新
        BusinessDao businessDao = new BusinessDaoImpl();
        Business business = businessDao.getBusinessById(businessId);
        System.out.println(business.toString());

        boolean changed = false;
        String inputStr = "";
        System.out.println("是否修改商家名称(y/n)?");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            changed = true;
            System.out.println("请输入新的商家名称：");
            inputStr = input.next();
            business.setBusinessName(inputStr);
        }

        System.out.println("是否修改商家地址(y/n)?");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            changed = true;
            System.out.println("请输入新的商家地址：");
            business.setBusinessAddress(input.next());
        }

        System.out.println("是否修改商家介绍(y/n)?");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            changed = true;
            System.out.println("请输入新的商家介绍：");
            business.setBusinessExplain(input.next());
        }

        System.out.println("是否修改起送费(y/n)?");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            changed = true;
            System.out.println("请输入新的起送费：");
            business.setStartPrice(input.nextDouble());
        }

        System.out.println("是否修改配送费(y/n)?");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            changed = true;
            System.out.println("请输入新的配送费：");
            business.setDeliveryPrice(input.nextDouble());
        }

        int result = businessDao.updateBusiness(business);
        if(result > 0) {
            if(changed) {
                System.out.println("修改商家信息成功！");
            } else {
                System.out.println("未进行修改！");
            }

        } else {
            System.out.println("修改商家信息失败！");
        }
    }

    @Override
    public void updateBusinessByPassword(Integer businessId) {
        BusinessDao businessDao = new BusinessDaoImpl();
        Business business = businessDao.getBusinessById(businessId);

        System.out.println("\n请输入原始密码：");
        String oldPassword = input.next();
        System.out.println("\n请输入新密码：");
        String newPassword = input.next();
        System.out.println("\n请再次输入密码：");
        String beginPassword = input.next();

        if(!oldPassword.equals(business.getPassword())) {
            System.out.println("\n旧密码输入错误！");
        } else if(!newPassword.equals(beginPassword)){
            System.out.println("\n两次密码输入不一致！");
        } else {
            int result = businessDao.updatePassword(businessId, newPassword);
            if(result > 0) {
                System.out.println("\n密码修改成功！");
            } else {
                System.out.println("\n密码修改失败！");
            }
        }
    }
}
