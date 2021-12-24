package Servlet;

import Bean.*;
import Service.CartService;
import Service.ProductService;
import Service.CartsService;
import Service.ProductsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addCartServlet")
public class AddCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String saleId_str = req.getParameter("saleId");
        Integer saleId = Integer.parseInt(saleId_str);
        ProductService productService = new ProductsService();
        Sales sale = null;
        try {
            sale = productService.findSaleById(saleId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Users user = (Users) session.getAttribute("user");
        //默认每次增加一个商品；
        Cart cart = new Cart(user, sale, 1);
        CartService cartService = new CartsService();
        try {
            cartService.addPurchase(cart);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //返回主界面
        req.getRequestDispatcher("/listSaleServlet").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}