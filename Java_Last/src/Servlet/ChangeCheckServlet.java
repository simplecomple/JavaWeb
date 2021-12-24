package Servlet;

import Bean.Cart;
import Bean.O;
import Bean.Sales;
import Bean.Users;
import Service.CartService;
import Service.CartsService;
import Service.ProductService;
import Service.ProductsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/changeCheckServlet")
public class ChangeCheckServlet extends HttpServlet {
    //改变购车中的一条购物信息
    //这里将删除购物记录，和修改购买数量，统一到ChangeCartServlet中

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String userId_str = req.getParameter("userId");
        String username = req.getParameter("username");
        String saleId_str=req.getParameter("saleId");
        String salename = req.getParameter("salename");
        String count_str=req.getParameter("count");
        HttpSession session=req.getSession();
        //Users user=(Users) session.getAttribute("user");
        Integer saleId=Integer.parseInt(saleId_str);
        //Integer userId=Integer.parseInt(userId_str);
        ProductService productService = new ProductsService();
        Sales sale= null;
        try {
            sale = productService.findSaleById(saleId);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        Integer count=Integer.parseInt(count_str);
//        Cart cart = new Cart(user,sale,count);
        O cart = new O(000,username,saleId,salename,count);
        CartService cartService=new CartsService();
        try {
            cartService.ChangeCheck(cart);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //resp.sendRedirect("/listCartServlet");
        req.getRequestDispatcher("/listCartServlet").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
