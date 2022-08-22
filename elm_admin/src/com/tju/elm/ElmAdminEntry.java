//
// created by wys
//
package com.tju.elm;

import com.tju.elm.po.Admin;
import com.tju.elm.view.AdminView;
import com.tju.elm.view.BusinessView;
import com.tju.elm.view.impl.AdminViewImpl;
import com.tju.elm.view.impl.BusinessViewImpl;

import java.util.Scanner;

/**
 * <p>管理员登录入口</p>
 * @author wys
 */
public class ElmAdminEntry {

    public void work() {
        Scanner input = new Scanner(System.in);

        System.out.println("---------------------------------------------------------");
        System.out.println("|\t\t\t 饿了么后台管理系统-管理员界面 \t\t\t|");
        System.out.println("---------------------------------------------------------");

        AdminView adminView = new AdminViewImpl();
        BusinessView businessView = new BusinessViewImpl();
        Admin admin = adminView.login();

        // 登录
        if(admin != null) {
            int menuNum = 0;
            while(menuNum != 5) {
                String adminHeadString = "\n============= 1.所有商家列表=2.搜索商家=3.新建商家=4.删除商家=5.退出系统==============";
                System.out.println(adminHeadString);
                System.out.println("请输入您的选择：");
                menuNum = input.nextInt();
                switch (menuNum) {
                    case 1 -> businessView.listBusinessAll();
                    case 2 -> businessView.listBusiness();
                    case 3 -> businessView.saveBusiness();
                    case 4 -> businessView.removeBusiness();
                    case 5 -> System.out.println("--------------欢迎下次光临饿了么系统---------------");
                    default -> System.out.println("您的输入有误");
                }
            }

        } else {
            System.out.println("管理员名称或密码输入错误！\n");
        }
    }

    public static void main(String[] args) {
        new ElmAdminEntry().work();
    }
}
