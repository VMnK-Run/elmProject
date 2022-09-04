package com.tju.elm.controller;

import com.tju.elm.po.Food;
import com.tju.elm.service.FoodService;
import com.tju.elm.service.Impl.FoodServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FoodController {

    public Object listFoodByBusinessId(HttpServletRequest request) throws Exception {
        Integer businessId = Integer.valueOf(request.getParameter("businessId"));
        FoodService service = new FoodServiceImpl();
        List<Food> list = service.listFoodByBusinessId(businessId);
        return list;
    }
}
