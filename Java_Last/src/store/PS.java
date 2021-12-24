package store;


import Bean.Products;

import java.sql.SQLException;
import java.util.List;

public interface PS{
    public List<Products> listAll() throws SQLException, ClassNotFoundException;
    public void addProduct(Products product) throws SQLException, ClassNotFoundException;
    public void editProduct(Products product) throws SQLException, ClassNotFoundException;
    public void deleteProductById(Integer id) throws SQLException, ClassNotFoundException;
    public Products findProductById(Integer id) throws SQLException, ClassNotFoundException;
}
