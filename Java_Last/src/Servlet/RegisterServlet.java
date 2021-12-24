package Servlet;

import Bean.Users;
import Service.UserService;
import Service.UsersService;
import Utils.IdUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UsersService();
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) {
    }
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email=request.getParameter("email");
        String genderStr=request.getParameter("gender");
        Integer gender=Integer.parseInt(genderStr);
        Integer id= IdUtils.getUserId();
        //注册普通用户
        Users user= new Users(id,username,password,gender,email,"common");
        System.out.println("进入了");
        try {
            userService.register(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //request.getRequestDispatcher("/Servlet/loginServlet");
        request.getRequestDispatcher("/loginServlet?username="+username+"&password="+password).forward(request,response);
    }
}
