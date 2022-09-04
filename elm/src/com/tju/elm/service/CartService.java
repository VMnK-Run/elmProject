package com.tju.elm.service;

import com.tju.elm.po.Cart;

import java.util.List;

public interface CartService {
    public int saveCart(Cart cart);
    public int updateCart(Cart cart);
    public int removeCart(Cart cart);
    public List<Cart> listCart(Cart cart);
}
