package com.tju.elm.controller;

import com.tju.elm.po.User;
import com.tju.elm.service.Impl.UserServiceImpl;
import com.tju.elm.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class UserController {

    public Object getUserByIdByPass(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        UserService service = new UserServiceImpl();
        User user = service.getUserByIdByPass(userId, password);
        return user;
    }

    public Object getUserById(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        UserService service = new UserServiceImpl();
        return service.getUserById(userId);
    }

    public Object saveUser(HttpServletRequest request) {
        User user = new User();
        user.setUserId(request.getParameter("userId"));
        user.setPassword(request.getParameter("password"));
        user.setUserName(request.getParameter("userName"));
        user.setUserSex(Integer.parseInt(request.getParameter("userSex")));
        UserService service = new UserServiceImpl();
        return service.saveUser(user);
    }
}
