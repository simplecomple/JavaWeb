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

@WebServlet("/findProductByIdServlet")
public class FindProductByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 得到商品的id
        String id_str = req.getParameter("id");
        Integer id=Integer.parseInt(id_str);
        // 获取type参数值，此处的type用于区别普通用户和超级用户
        String type = req.getParameter("type");
        ProductService productService = new ProductsService();
        // 调用service层方法，通过id查找商品
        Products product = null;
        try {
            product = productService.findProductById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        req.setAttribute("product", product);
        // 普通用户默认不传递type值，会跳转到info.jsp页面
//        if (type == null) {
//            req.getRequestDispatcher("/client/info.jsp").forward(req,resp);
//        }
        req.getRequestDispatcher("/Admin/edit.jsp").forward(req, resp);

    }
}
