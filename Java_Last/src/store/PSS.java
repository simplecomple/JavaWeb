package store;

import Bean.Products;
import Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PSS implements PS{
    @Override
    public List<Products> listAll() throws SQLException, ClassNotFoundException {
        Connection connection = JDBCUtils.getConnection();
        String sql="select * from product";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Products> products=new ArrayList<>();
        try {
            preparedStatement=connection.prepareStatement(sql);
            resultSet= preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Double price = resultSet.getDouble(3);
                Integer number=resultSet.getInt(4);
                String category=resultSet.getString(5);
                products.add(new Products(id,name,price,number,category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection,preparedStatement,resultSet);
        }
        return products;
    }

    @Override
    public void addProduct(Products product) throws SQLException, ClassNotFoundException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql="insert into product(id,p_name,price,p_number,category) values(?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,product.getId());
            preparedStatement.setString(2,product.getP_name());
            preparedStatement.setDouble(3,product.getPrice());
            preparedStatement.setInt(4,product.getP_number());
            preparedStatement.setString(5,product.getCategory());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection,preparedStatement,resultSet);
        }
    }

    @Override
    public void editProduct(Products product) throws SQLException, ClassNotFoundException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql="update product set p_name=?,price=?, p_number=?,category=? where id =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,product.getP_name());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getP_number());
            preparedStatement.setString(4,product.getCategory());
            preparedStatement.setInt(5,product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection,preparedStatement,resultSet);
        }
    }

    @Override
    public void deleteProductById(Integer id) throws SQLException, ClassNotFoundException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql="delete from product where id =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection,preparedStatement,resultSet);
        }
    }

    @Override
    public Products findProductById(Integer id) throws SQLException, ClassNotFoundException {
        Connection connection = JDBCUtils.getConnection();
        String sql="select * from product where id = ?";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        Products product=null;
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet= preparedStatement.executeQuery();
            while(resultSet.next())
            {
                id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Double price = resultSet.getDouble(3);
                Integer number=resultSet.getInt(4);
                String category=resultSet.getString(5);
                product=new Products(id,name,price,number,category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection,preparedStatement,resultSet);
        }
        return product;
    }
}
