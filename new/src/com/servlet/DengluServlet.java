package com.servlet;

import java.io.IOException;


import com.dao.UserDao;
import com.dao.UserDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DengluServlet extends HttpServlet {  //需要继承HttpServlet  并重写doGet  doPost方法
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name"); //得到jsp页面传过来的参数
        String pwd = request.getParameter("pwd");

        UserDao ud = new UserDaoImpl();

        if(ud.login(name, pwd)){
            request.setAttribute("xiaoxi", "欢迎用户"+name); //向request域中放置信息
            request.getRequestDispatcher("/success.jsp").forward(request, response);//转发到成功页面
        }else{
            response.sendRedirect("index.jsp"); //重定向到首页
        }
    }

}
