package com.tju.elm.util;

import java.sql.*;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/elm?characterEncoding=utf-8";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static final ThreadLocal<Connection> TL = new ThreadLocal<>(); // 线程局部对象

    // 获取connection,从线程局部对象中
    public static Connection getConnection() {
        Connection con = null;
        con = TL.get();
        if(con == null) {
            con = createConnection();
            TL.set(con);
        }
        return con;
    }

    // 开启一个事务
    public static void beginTransaction() throws Exception{
        Connection con = null;
        con = TL.get();
        if(con == null) {
            con = createConnection();
            TL.set(con);
        }
        // 开启一个事务
        con.setAutoCommit(false);
    }

    // 提交一个事务
    public static void commitTransaction() throws Exception {
        Connection con = TL.get();
        con.commit();
    }

    // 回滚一个事务
    public static void rollbackTransaction() throws Exception {
        Connection con = TL.get();
        con.rollback();
    }

    // 关闭资源
    public static void close(ResultSet rs, PreparedStatement pst) {
        try {
            if(rs != null) {
                rs.close();
            }
            if(pst != null) {
                pst.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement pst) {
        try {
            if(pst != null) {
                pst.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close() {
        Connection con = TL.get();
        try {
            if(con != null) {
                con.close();
            }
            TL.remove(); // 必须remove，否则内存泄漏
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection createConnection() {
        Connection con = null;
        if(con == null) {
            try {
                Class.forName(DRIVER);
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return con;
    }
}
