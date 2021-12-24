package Servlet;

import Service.UserService;
import Service.UsersService;
import store.*;
import Bean.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    //注入loginService对象
    UserService userService = new UsersService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户名
        String username = req.getParameter("username");
        //获取用户密码
        String password = req.getParameter("password");
        Object object = null;
        System.out.println("进入loginServlet");
        try {
            object = userService.login(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(object == null){
            //若数据库中对应User表中不存在该用户，则返回概览页面
            resp.sendRedirect("/listSaleServlet");
            System.out.println("无用户，回首页");
        }else{
            //否则进入欢迎界面
            HttpSession session=req.getSession();
            Users user=(Users) object;
            session.setAttribute("user",user);
            if (user.getRole().equals("special"))
            {//管理员用户界面
                req.getRequestDispatcher("/listProductServlet").forward(req,resp);
                System.out.println("进入管理员Servlet");
            }
            else {//普通用户界面
                req.getRequestDispatcher("/listSaleServlet").forward(req,resp);
                //resp.sendRedirect("/listSaleServlet");
                System.out.println("进入普通用户Servlet");
            }
        }
    }
}
