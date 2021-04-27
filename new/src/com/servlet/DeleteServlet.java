package com.servlet;
import java.io.IOException;
import com.dao.UserDao;
import com.dao.UserDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        int userId = Integer.parseInt(id);

        UserDao ud = new UserDaoImpl();

        if(ud.delete(userId)){
            request.setAttribute("xiaoxi", "删除成功");
            request.getRequestDispatcher("/Searchall").forward(request, response);
        }else{
            response.sendRedirect("index.jsp");
        }
    }

}
