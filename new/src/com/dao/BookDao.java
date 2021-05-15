package com.dao;

import com.bean.Book;

import java.util.List;

public interface BookDao {
    boolean clear() ;//清空购物车
    List<Book> getBookAll();//查询图书信息
    boolean add(int bid,int num);//增添图书信息
    Integer select_T();//查找总的本书
    Integer select_TP();//查找总价格
    boolean delete(int bid);
    List<Book> getBookAll(String bname);//根据名字查询图书信息
}
