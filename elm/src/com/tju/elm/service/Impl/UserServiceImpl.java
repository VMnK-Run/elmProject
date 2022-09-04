package com.tju.elm.service.Impl;

import com.tju.elm.dao.Impl.UserDaoImpl;
import com.tju.elm.dao.UserDao;
import com.tju.elm.po.User;
import com.tju.elm.service.UserService;
import com.tju.elm.util.DBUtil;

public class UserServiceImpl implements UserService {
    @Override
    public User getUserByIdByPass(String userId, String password) {
        User user = null;
        UserDao dao = new UserDaoImpl();
        try {
            DBUtil.getConnection();
            user = dao.getUserByIdByPass(userId, password);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return user;
    }

    @Override
    public int getUserById(String userId) {
        int result = 0;
        UserDao dao = new UserDaoImpl();
        try {
            DBUtil.getConnection();
            result = dao.getUserById(userId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return result;
    }

    @Override
    public int saveUser(User user) {
        int result = 0;
        UserDao dao = new UserDaoImpl();
        try {
            DBUtil.getConnection();
            result = dao.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return result;
    }
}
