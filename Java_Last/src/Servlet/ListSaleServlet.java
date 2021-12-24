package Servlet;

import Bean.Products;
import Bean.Sales;
import Bean.Users;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/listSaleServlet")
public class ListSaleServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 1.创建service层的对象
        ProductService productService = new ProductsService();
        // 2.调用service层用于查询所有商品的方法
        List<Products> products = null;
        try {
            products = productService.listAll();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<Sales> sales = new ArrayList<>();
        for (Products product : products) {
            Sales sale = new Sales(product.getId(), product.getP_name(), product.getPrice());
            //System.out.println(product.getId());
            sales.add(sale);
        }
        HttpSession session = req.getSession();
        Users user = (Users) session.getAttribute("user");
        // 3.将查询出的所有商品放进request域中
        req.setAttribute("sales", sales);
        if (user == null) {
            //转发到概览界面
            System.out.println(sales);
            req.getRequestDispatcher("/Client/overview.jsp").forward(req, resp);
        } else {
            // 4.转发到欢迎界面
            System.out.println("登录成功！");
            System.out.println(sales);
            req.getRequestDispatcher("/Client/welcome.jsp").forward(req, resp);
        }
    }
}
