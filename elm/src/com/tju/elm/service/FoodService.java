package com.tju.elm.service;

import com.tju.elm.po.Food;

import java.util.List;

public interface FoodService {

    public List<Food> listFoodByBusinessId(Integer businessId);
}
