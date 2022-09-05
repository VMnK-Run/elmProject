package com.tju.elmboot.service.impl;

import com.tju.elmboot.mapper.UserMapper;
import com.tju.elmboot.po.User;
import com.tju.elmboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByIdByPass(User user) {
        return userMapper.getUserByIdByPass(user);
    }
}
