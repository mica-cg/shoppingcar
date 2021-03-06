package com.servlet;
import java.io.IOException;
import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.bean.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ZhuceServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name"); //获取jsp页面传过来的参数
        String pwd = request.getParameter("pwd");
        String sex = request.getParameter("sex");
        User user = new User(); //实例化一个对象，组装属性
        user.setName(name);
        user.setPwd(pwd);
        user.setSex(sex);
        UserDao ud = new UserDaoImpl();
        if(ud.register(user)){
            request.setAttribute("username", name);  //向request域中放置参数
            request.setAttribute("xiaoxi", "注册成功");
            request.getRequestDispatcher("/denglu.jsp").forward(request, response);  //转发到登录页面
        }else{

            response.sendRedirect("index.jsp");//重定向到首页
        }
    }
}
