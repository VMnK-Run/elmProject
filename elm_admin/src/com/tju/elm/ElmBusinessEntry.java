package com.tju.elm;

import com.tju.elm.po.Business;
import com.tju.elm.view.BusinessView;
import com.tju.elm.view.FoodView;
import com.tju.elm.view.impl.BusinessViewImpl;
import com.tju.elm.view.impl.FoodViewImpl;

import java.util.Scanner;

public class ElmBusinessEntry {

    Scanner input = new Scanner(System.in);

    public void work() {
        System.out.println("---------------------------------------------------------");
        System.out.println("|\t\t\t 饿了么后台管理系统-商家界面 \t\t\t|");
        System.out.println("---------------------------------------------------------");

        BusinessView businessView = new BusinessViewImpl();
        Business business = businessView.logIn(); // 这个只在登录的时候用到，其余均用它的id，因为ID是永恒不变的，其他的都有可能变

        // 商家登录
        if(business != null) {
            int menuNum = 0;
            while(menuNum != 5) {
                // 输出一级菜单
                System.out.println("\n======= 一级菜单（商家管理）1.查看商家信息=2.修改商家信息=3.更新密码=4.所属商品管理=5.退出系统=======");
                System.out.println("请输入您的选择");
                menuNum = input.nextInt();
                switch (menuNum) {
                    case 1 -> businessView.showBusiness(business.getBusinessId()); // 即时性，准确性，正确性
                    case 2 -> businessView.editBusiness(business.getBusinessId());
                    case 3 -> businessView.updateBusinessByPassword(business.getBusinessId());
                    case 4 -> foodManager(business.getBusinessId());
                    case 5 -> System.out.println("--------------欢迎下次光临饿了么系统---------------");
                    default -> System.out.println("没有这个选项");
                }
            }
        } else {
            System.out.println("商家编号或密码输入错误");
        }
    }

    private void foodManager(int businessId) {
        FoodView foodView = new FoodViewImpl();
        int menuNum = 0;
        while(menuNum != 5) {
            // 输出一级菜单
            System.out.println("\n======= 二级菜单（食品管理）1.查看食品列表=2.新增食品=3.修改食品=4.删除食品=5.返回一级菜单 =======");
            System.out.println("请输入您的选择");
            menuNum = input.nextInt();
            switch (menuNum) {
                case 1 -> foodView.showFoodList(businessId);
                case 2 -> foodView.saveFood(businessId);
                case 3 -> foodView.updateFood(businessId);
                case 4 -> foodView.removeFood(businessId);
                case 5 -> {
                }
                default -> System.out.println("没有这个选项");
            }
        }
    }

    public static void main(String[] args) {
        new ElmBusinessEntry().work();
    }
}
