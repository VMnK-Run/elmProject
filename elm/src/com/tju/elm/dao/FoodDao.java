package com.tju.elm.dao;

import com.tju.elm.po.Food;

import java.util.List;

public interface FoodDao {

    public List<Food> listFoodByBusinessId(Integer businessId) throws Exception;
}
