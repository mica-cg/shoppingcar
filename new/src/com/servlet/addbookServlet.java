package com.servlet;

import com.dao.BookDao;
import com.dao.BookDaolmpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import javax.swing.*;
import java.io.IOException;


public class addbookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String x=request.getParameter("x");
        int num=Integer.parseInt(x);
        BookDao bd=new BookDaolmpl();
        String y=request.getParameter("bid");
        int bid=Integer.parseInt(y);
        if(bd.add(bid,num)){
            request.getRequestDispatcher("/searchall_b").forward(request, response);
        }else{
            response.sendRedirect("index.jsp");
        }
    }
}
