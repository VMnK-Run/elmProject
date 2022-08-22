package com.tju.elm.view;

import com.tju.elm.po.Food;

import java.util.List;

public interface FoodView {
    public List<Integer> showFoodList(Integer businessId);
    public void saveFood(Integer businessId);
    public void updateFood(Integer businessId);
    public void removeFood(Integer businessId);
}
