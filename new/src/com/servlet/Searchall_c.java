package com.servlet;

import com.bean.Book;
import com.dao.BookDao;
import com.dao.BookDaolmpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;


public class Searchall_c extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao ud = new BookDaolmpl();
        List<Book> bookAll = ud.getBookAll();
        request.setAttribute("bookAll", bookAll);
        request.getRequestDispatcher("/shop.jsp").forward(request, response);
    }
}
