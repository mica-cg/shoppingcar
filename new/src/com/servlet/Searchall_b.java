package com.servlet;

import com.dao.BookDao;
import com.dao.BookDaolmpl;
import com.entity.Book;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
public class Searchall_b extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bd =new BookDaolmpl();
        List<Book> bookAll=bd.getBookAll();
        request.setAttribute("bookAll",bookAll);
        int i= bd.select_T();
        HttpSession session= request.getSession();
        session.setAttribute("a",i);
        int j=bd.select_TP();
        session.setAttribute("b",j);
        request.getRequestDispatcher("/shoppingcar.jsp").forward(request,response);
    }


}
