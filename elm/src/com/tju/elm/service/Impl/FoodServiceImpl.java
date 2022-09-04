package com.tju.elm.service.Impl;

import com.tju.elm.dao.FoodDao;
import com.tju.elm.dao.Impl.FoodDaoImpl;
import com.tju.elm.po.Food;
import com.tju.elm.service.FoodService;
import com.tju.elm.util.DBUtil;

import java.util.ArrayList;
import java.util.List;

public class FoodServiceImpl implements FoodService {
    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        List<Food> list = new ArrayList<>();
        FoodDao dao = new FoodDaoImpl();
        try {
            DBUtil.getConnection();
            list = dao.listFoodByBusinessId(businessId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return list;
    }
}
