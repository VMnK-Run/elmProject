package com.tju.elm.view.impl;

import com.tju.elm.dao.FoodDao;
import com.tju.elm.dao.impl.FoodDaoImpl;
import com.tju.elm.po.Food;
import com.tju.elm.view.FoodView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoodViewImpl implements FoodView {
    Scanner input = new Scanner(System.in);

    @Override
    public List<Integer> showFoodList(Integer businessId) {
        List<Integer> foodIdList = new ArrayList<>();
        FoodDao foodDao = new FoodDaoImpl();
        List<Food> list = foodDao.listFoodByBusinessId(businessId);
        System.out.println("食品编号\t食品名称\t食品介绍\t食品价格");
        for(Food food : list) {
            int foodId = food.getFoodId();
            foodIdList.add(foodId);
            System.out.println(food.getFoodId() + "\t" + food.getFoodName() + "\t" + food.getFoodExplain() + "\t" + food.getFoodPrice());
        }
        return foodIdList;
    }

    @Override
    public void saveFood(Integer businessId) {
        System.out.println("请输入食品名称：");
        String foodName = input.next();
        System.out.println("请输入食品介绍：");
        String foodExplain = input.next();
        System.out.println("请输入食品价格");
        Double foodPrice = input.nextDouble();
        Food food = new Food();
        food.setFoodName(foodName);
        food.setFoodExplain(foodExplain);
        food.setFoodPrice(foodPrice);
        food.setBusinessId(businessId);

        FoodDao foodDao = new FoodDaoImpl();
        int result = foodDao.saveFood(food);
        if(result > 0) {
            System.out.println("\n新增食品成功！");
        } else {
            System.out.println("\n新增食品失败！");
        }
    }

    @Override
    public void updateFood(Integer businessId) {
        FoodDao foodDao = new FoodDaoImpl();
        List<Integer> list = showFoodList(businessId);
        if(list.size() > 0) { // 可能一个食品都没有
            System.out.println("请选择要更新的食品编号：");
            int foodId = input.nextInt();
            if(list.contains(foodId)) {
                Food food = foodDao.getFoodByFoodId(foodId);
                System.out.println(food.toString());

                String inputStr = "";
                System.out.println("是否更新食品名称(y/n)?");
                inputStr = input.next();
                if(inputStr.equals("y")) {
                    System.out.println("请输入新的食品名称：");
                    food.setFoodName(input.next());
                }

                System.out.println("是否更新食品介绍(y/n)?");
                inputStr = input.next();
                if(inputStr.equals("y")) {
                    System.out.println("请输入新的食品介绍：");
                    food.setFoodExplain(input.next());
                }

                System.out.println("是否更新食品价格(y/n)?");
                inputStr = input.next();
                if(inputStr.equals("y")) {
                    System.out.println("请输入新的食品价格：");
                    food.setFoodPrice(input.nextDouble());
                }

                int result = foodDao.updateFood(food);
                if(result > 0) {
                    System.out.println("\n修改食品成功！");
                } else {
                    System.out.println("\n修改食品失败！");
                }
            } else {
                System.out.println("您的店铺中没有该食品！");
            }
        } else {
            System.out.println("没有任何食品！");
        }


    }

    @Override
    public void removeFood(Integer businessId) {
        // TODO 这里有一个bug，有可能输入的foodId是其他商家的，缺少一个认证？
        FoodDao foodDao = new FoodDaoImpl();
        List<Integer> list = showFoodList(businessId);
        if(list.size() > 0) {
            System.out.println("请输入要删除的食品编号：");
            int foodId = input.nextInt();
            if(list.contains(foodId)) {
                System.out.println("确认要删除吗(y/n)?");
                String inputStr = input.next();
                if(inputStr.equals("y")) {
                    int result = foodDao.removeFood(foodId);
                    if(result > 0) {
                        System.out.println("删除食品成功！");
                    } else {
                        System.out.println("删除食品失败！");
                    }
                }
            } else {
                System.out.println("您的店铺中没有该食品！");
            }

        } else {
            System.out.println("没有任何食品！");
        }
    }
}
