package com.dao;

import java.sql.*;

public class DBconn {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/test" +
            "?useUnicode=true&characterEncoding=utf-8&"+
            "useSSL=false&serverTimezone=GMT%2B8";
    public static final String username = "root";
    public static final String password = "root";
    public static Connection conn = null;
    static ResultSet rs = null;
    static PreparedStatement ps =null;


    public static void init(){
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(url,username,password);
            if(!conn.isClosed())
                System.out.println("成功连接至数据库!");
        } catch (Exception e) {
            System.out.println("init [SQL驱动程序初始化失败！]");
            e.printStackTrace();
        }
    }

    public static int addUpdDel(String sql){
        int i = 0;
        try {
            ps =  conn.prepareStatement(sql);
            i =  ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sql数据库增删改异常");
            e.printStackTrace();
        }

        return i;
    }
    public static ResultSet selectSql(String sql){
        try {
            ps =  conn.prepareStatement(sql);
            rs =  ps.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("sql数据库查询异常");
            e.printStackTrace();
        }
        return rs;
    }
    public static void closeConn(){
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("sql数据库关闭异常");
            e.printStackTrace();
        }
    }
}
