package com.elm.controller;

import com.elm.po.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class UserController {
    public Object login(HttpServletRequest request){
        String username = request.getParameter("username");
        User user = new User();
        user.setUserId("001");
        user.setUserName("aukira");

        return user;
    }
}
