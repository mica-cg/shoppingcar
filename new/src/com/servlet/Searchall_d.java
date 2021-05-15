package com.servlet;

import com.bean.Book;
import com.dao.BookDao;
import com.dao.BookDaolmpl;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Searchall_d", value = "/Searchall_d")
public class Searchall_d extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bname=request.getParameter("bname");
        BookDao ud = new BookDaolmpl();
        List<Book> bookAll = ud.getBookAll(bname);
        request.setAttribute("bookAll", bookAll);
        request.getRequestDispatcher("/shop.jsp").forward(request, response);
    }
}
