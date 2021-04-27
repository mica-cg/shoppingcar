package com.servlet;
import java.io.IOException;
import com.dao.UserDao;
import com.dao.UserDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        int userId = Integer.parseInt(id);

        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String sex = request.getParameter("sex");
        System.out.println("------------------------------------"+userId);

        UserDao ud = new UserDaoImpl();

        if(ud.update(userId, name, pwd, sex)){
            request.setAttribute("xiaoxi", "更新成功");
            request.getRequestDispatcher("/Searchall").forward(request, response);
        }else{
            response.sendRedirect("index.jsp");
        }
    }
}