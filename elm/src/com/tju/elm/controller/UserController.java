package com.tju.elm.controller;

import com.tju.elm.po.User;

import javax.servlet.http.HttpServletRequest;

public class UserController {

    public Object login(HttpServletRequest request) {
        String userName = request.getParameter("username");
        System.out.println(userName);
        System.out.println("do login!");
        User user = new User();
        user.setUserId("123");
        user.setUserName("zhang");
        return user;
    }
}
