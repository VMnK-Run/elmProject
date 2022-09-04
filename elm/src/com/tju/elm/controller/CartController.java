package com.tju.elm.controller;

import com.tju.elm.po.Cart;
import com.tju.elm.service.CartService;
import com.tju.elm.service.Impl.CartServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class CartController {

    public Object saveCart(HttpServletRequest request) {
        Cart cart = new Cart();
        cart.setFoodId(Integer.valueOf(request.getParameter("foodId")));
        cart.setBusinessId(Integer.valueOf(request.getParameter("businessId")));
        cart.setUserId(request.getParameter("userId"));
        CartService service = new CartServiceImpl();
        int result = service.saveCart(cart);
        return result;
    }

    public Object updateCart(HttpServletRequest request) {
        Cart cart = new Cart();
        cart.setFoodId(Integer.valueOf(request.getParameter("foodId")));
        cart.setBusinessId(Integer.valueOf(request.getParameter("businessId")));
        cart.setUserId(request.getParameter("userId"));
        cart.setQuantity(Integer.valueOf(request.getParameter("quantity")));
        CartService service = new CartServiceImpl();
        return service.updateCart(cart);
    }

    public Object removeCart(HttpServletRequest request) {
        Cart cart = new Cart();
        if(request.getParameter("foodId") != null) {
            cart.setFoodId(Integer.valueOf(request.getParameter("foodId")));
        }
        cart.setBusinessId(Integer.valueOf(request.getParameter("businessId")));
        cart.setUserId(request.getParameter("userId"));
        CartService service = new CartServiceImpl();
        return service.removeCart(cart);
    }

    public Object listCart(HttpServletRequest request) {
        Cart cart = new Cart();
        cart.setUserId(request.getParameter("userId"));
        if(request.getParameter("businessId") != null){
            cart.setBusinessId(Integer.valueOf(request.getParameter("businessId")));
        }
        CartService service = new CartServiceImpl();
        return service.listCart(cart);
    }
}
