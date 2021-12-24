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

@WebServlet("/makeOrderServlet")
public class MakeOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        Users user = (Users) session.getAttribute("user");
        CartService cartService= new CartsService();
        List<Cart> purchases= null;
        try {
            purchases = cartService.listAllByUser(user);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
//        for (int i = 0;i < purchases.size();i++){
//            try {
//                System.out.println(purchases.get(i).getUser().getId());
//                System.out.println(purchases.get(i).getSale().getName());
//                System.out.println(purchases.get(i));
//                cartService.addPurchase(purchases.get(i));
//            } catch (SQLException | ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
        req.setAttribute("purchases",purchases);
        req.getRequestDispatcher("/Client/order.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
