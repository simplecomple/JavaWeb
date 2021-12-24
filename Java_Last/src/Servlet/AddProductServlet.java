package Servlet;

import Bean.Products;
import Service.ProductService;
import Service.ProductsService;
import Utils.IdUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

//添加一条新的商品记录
@WebServlet("/addProductServlet")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String price_str=req.getParameter("price");
        Double price=Double.parseDouble(price_str);
        String number_str=req.getParameter("number");
        Integer number = Integer.parseInt(number_str);
        String category=req.getParameter("category");
        Integer id= IdUtils.getProductId();
        Products product= new Products(id,name,price,number,category);
        System.out.println(product);
        ProductService productService = new ProductsService();
        try {
            productService.addProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/listProductServlet").forward(req,resp);
        //resp.sendRedirect("/listProductServlet");
    }
}
