package Servlet;

import Bean.Products;
import Service.ProductService;
import Service.ProductsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/listProductServlet")
public class ListProductServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1.创建service层的对象
        ProductService service = new ProductsService();
        // 2.调用service层用于查询所有商品的方法
        List<Products> products = null;
        try {
            products = service.listAll();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 3.将查询出的所有商品放进request域中
        request.setAttribute("products", products);
        System.out.println("转发到列表页");
        // 4.转发到list.jsp页面
        request.getRequestDispatcher("/Admin/list.jsp").forward(request, response);
    }
}