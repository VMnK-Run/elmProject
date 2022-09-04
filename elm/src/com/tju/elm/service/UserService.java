package com.tju.elm.service;

import com.tju.elm.po.User;

public interface UserService {
    public User getUserByIdByPass(String userId, String password);
    public int getUserById(String userId);
    public int saveUser(User user);
}
