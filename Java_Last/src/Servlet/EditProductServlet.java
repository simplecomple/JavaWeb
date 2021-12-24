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

@WebServlet("/editProductServlet")
public class EditProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id_str = req.getParameter("id");
        Integer id = Integer.parseInt(id_str);
        String name = req.getParameter("name");
        String price_str = req.getParameter("price");
        Double price = Double.parseDouble(price_str);
        String number_str = req.getParameter("number");
        Integer number = Integer.parseInt(number_str);
        String category = req.getParameter("category");
        Products product = new Products(id, name, price, number, category);
//        System.out.println("产生修改后的对象为:\n");
//        System.out.println(product);
        ProductService productService = new ProductsService();
        try {
            productService.editProduct(product);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/listProductServlet").forward(req,resp);
        //resp.sendRedirect("/listProductServlet");
    }
}
