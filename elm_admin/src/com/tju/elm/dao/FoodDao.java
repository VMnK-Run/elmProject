package com.tju.elm.dao;

import com.tju.elm.po.Food;

import java.util.List;

public interface FoodDao {

    public List<Food> listFoodByBusinessId(Integer businessId);
    public int saveFood(Food food);
    public Food getFoodByFoodId(Integer foodId);
    public int updateFood(Food food);
    public int removeFood(Integer foodId);
}
