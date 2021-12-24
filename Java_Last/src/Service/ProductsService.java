package Service;


import Bean.Products;
import Bean.Sales;
import store.PS;
import store.PSS;

import java.sql.SQLException;
import java.util.List;

public class ProductsService implements ProductService{
    //注入ProductRespository对象
    PS ps = new PSS();

    //返回所有商品的信息
    @Override
    public List<Products> listAll() throws SQLException, ClassNotFoundException {
        return ps.listAll();
    }

    //添加一条新的商品记录
    @Override
    public void addProduct(Products product) throws SQLException, ClassNotFoundException {
        ps.addProduct(product);
    }

    //修改商品记录
    @Override
    public void editProduct(Products product) throws SQLException, ClassNotFoundException {
        ps.editProduct(product);
    }

    //删除一条商品记录
    @Override
    public void deleteProductById(Integer id) throws SQLException, ClassNotFoundException {
        ps.deleteProductById(id);
    }
    //通过商品id找到该商品
    @Override
    public Products findProductById(Integer id) throws SQLException, ClassNotFoundException {
        return ps.findProductById(id);
    }

    //找到售卖物的信息
    @Override
    public Sales findSaleById(Integer id) throws SQLException, ClassNotFoundException {
        Products product = findProductById(id);
        Sales sale= new Sales(product.getId(),product.getP_name(),product.getPrice());
        return sale;
    }
}
