package com.dao;

import com.bean.Book;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaolmpl implements BookDao {

    public boolean clear() {
        boolean flag = false;
        DBconn.init();
        String sql = "update book set num=0 ";
        int i = DBconn.addUpdDel(sql);
        if (i > 0) {
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    public List<Book> getBookAll() {
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from book");
            while (rs.next()) {
                Book book = new Book();
                book.setBid(rs.getInt("bid"));
                book.setBname(rs.getString("bname"));
                book.setNum(rs.getInt("num"));
                book.setPrice(rs.getDouble("price"));
                book.setImg(rs.getString("img"));
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(int bid, String bname, int num, double price) {
        boolean flag = false;
        DBconn.init();
        String sql = "update book set bname ='" + bname
                + "' , num ='" + num
                + "' , price ='" + price
                + "' where bid = " + bid;
        int i = DBconn.addUpdDel(sql);
        if (i > 0) {
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    public boolean add(int bid, int num) {
        boolean flag = false;
        DBconn.init();
        String sql = "update book set num =num+'" + num
                + "'where bid=" + bid;
        int i = DBconn.addUpdDel(sql);
        if (i > 0) {
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    public Integer select_T() {
        try {
            int i = 0;
            DBconn.init();
            String sql = "select sum(num) as total from book ";
            ResultSet rs = DBconn.selectSql(sql);
            while (rs.next()) {
                i = rs.getInt("total");
            }
            DBconn.closeConn();
            return i;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Integer select_TP() {
        try {
            int i = 0;
            DBconn.init();
            String sql = "select SUM(num*price) as totalprice from book";
            ResultSet rs = DBconn.selectSql(sql);
            while (rs.next()) {
                i = rs.getInt("totalprice");
            }
            DBconn.closeConn();
            return i;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public boolean delete(int bid) {
        boolean flag = false;
        DBconn.init();
        String sql = "update book set num=0 where bid =" + bid;
        int i = DBconn.addUpdDel(sql);
        if (i > 0) {
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    public List<Book> getBookAll(String bname) {
        List<Book> list = new ArrayList<Book>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from book where bname like '%" + bname+"%'");
            while (rs.next()) {
                Book book = new Book();
                book.setBid(rs.getInt("bid"));
                book.setBname(rs.getString("bname"));
                book.setNum(rs.getInt("num"));
                book.setPrice(rs.getDouble("price"));
                book.setImg(rs.getString("img"));
                list.add(book);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}