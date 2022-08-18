package com.tju.elm.dao;

import com.tju.elm.po.Admin;

public interface AdminDao {

    public Admin getAdminByNameByPassword(String adminName, String password);
}
