package com.servlet;

import com.dao.BookDao;
import com.dao.BookDaolmpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;


public class clearServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bd=new BookDaolmpl();
        if(bd.clear()){

            request.getRequestDispatcher("/searchall_b").forward(request,response);
        }
        else{
            response.sendRedirect("index.jsp");
        }
}}
