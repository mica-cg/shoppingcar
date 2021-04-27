package com.servlet;

import com.dao.BookDao;
import com.dao.BookDaolmpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "DeletebookServlet", value = "/DeletebookServlet")
public class DeletebookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String a=request.getParameter("bid");
        int i=Integer.parseInt(a);
        BookDao bd=new BookDaolmpl();
        if(bd.delete(i)){
            JOptionPane.showMessageDialog(null, "删除成功");
            request.getRequestDispatcher("/searchall_b").forward(request, response);
        }else{
            response.sendRedirect("index.jsp");
        }
    }
}
