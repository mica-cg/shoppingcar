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
        if(x == null || x.length() <= 0)
        {
            JOptionPane.showMessageDialog(null, "添加失败");
            request.getRequestDispatcher("/searchall_b").forward(request, response);
        }
        int num=Integer.parseInt(x);
        BookDao bd=new BookDaolmpl();
        String y=request.getParameter("bid");
        int bid=Integer.parseInt(y);
        if(bd.add(bid,num)){
            JOptionPane.showMessageDialog(null, "添加成功");
            request.getRequestDispatcher("/searchall_b").forward(request, response);
        }else{
            response.sendRedirect("index.jsp");
        }
    }
}
