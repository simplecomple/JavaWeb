package Servlet;

import Bean.Cart;
import Bean.Users;
import Service.CartService;
import Service.CartsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/listCartServlet")
public class ListCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        Users user = (Users) session.getAttribute("user");
        CartService cartService= new CartsService();
        List<Cart> carts= null;
        try {
            carts = cartService.listAllByUser(user);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        req.setAttribute("carts",carts);
        System.out.println("进入我的购物车");
        req.getRequestDispatcher("/Client/list.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
