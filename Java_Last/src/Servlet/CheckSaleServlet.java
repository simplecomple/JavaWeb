package Servlet;

import Bean.Cart;
import Bean.O;
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

@WebServlet("/checkSaleServlet")
public class CheckSaleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        Users user = (Users) session.getAttribute("user");
        CartService cartService= new CartsService();
        List<O> purchases= null;
        try {
            purchases = cartService.listAllSale();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("销售页面");
        System.out.println(purchases.get(0).getId());
        purchases.get(0).getCount();
        req.setAttribute("purchases",purchases);
        req.getRequestDispatcher("/Admin/checkSale.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

