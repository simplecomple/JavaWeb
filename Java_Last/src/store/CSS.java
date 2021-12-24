package store;

import Bean.Cart;
import Bean.O;
import Bean.Sales;
import Bean.Users;
import Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CSS implements CS {
    @Override
    public List<Cart> listAllByUser(Users user) throws SQLException, ClassNotFoundException {
        Connection connection = JDBCUtils.getConnection();
        String sql="select product.id ,product.p_name,product.price,count from product,(select saleId,sum(count) from carts where carts.userId=? group by carts.saleId) cart_new(saleId,count) where cart_new.saleId=product.id";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Cart> carts =new ArrayList<>();
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,user.getId());
            resultSet= preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Integer saleId=resultSet.getInt(1);
                String name=resultSet.getString(2);
                Double price = resultSet.getDouble(3);
                Integer count = resultSet.getInt(4);
                Sales sale=new Sales(saleId,name,price);
                carts.add(new Cart(user,sale,count));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection,preparedStatement,resultSet);
        }
        return carts;
    }
    @Override
    public List<O> listAllSale() throws SQLException, ClassNotFoundException {
        Connection connection = JDBCUtils.getConnection();
        String sql="select userId,username,saleId,salename,count from checks";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<O> carts =new ArrayList<>();
        try {
            preparedStatement=connection.prepareStatement(sql);
            resultSet= preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Integer userId=resultSet.getInt(1);
                String username=resultSet.getString(2);
                Integer saleId=resultSet.getInt(3);
                String salename=resultSet.getString(4);
                Integer count = resultSet.getInt(5);
                carts.add(new O(userId,username,saleId,salename,count));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection,preparedStatement,resultSet);
        }
        return carts;
    }

    @Override
    public void addPurchase(Cart cart) throws SQLException, ClassNotFoundException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql="insert into carts(userId,saleId,count) values(?,?,?)";
            //System.out.println(cart);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,cart.getUser().getId());
            preparedStatement.setInt(2,cart.getSale().getId());
            preparedStatement.setInt(3,cart.getCount());
            preparedStatement.executeUpdate();

//            String sql1="insert into checks(userId,username,saleId,salename,count) values(?,?,?,?,?)";
//            preparedStatement = connection.prepareStatement(sql1);
//            preparedStatement.setInt(1,cart.getUser().getId());
//            preparedStatement.setString(2,cart.getUser().getUsername());
//            preparedStatement.setInt(3,cart.getSale().getId());
//            preparedStatement.setString(4,cart.getSale().getName());
//            preparedStatement.setInt(5,cart.getCount());
//            preparedStatement.executeUpdate();
            //System.out.println("已添加");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection,preparedStatement,resultSet);
        }
    }
    @Override
    public void AddCheck(O cart) throws SQLException, ClassNotFoundException{
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql1="insert into checks(userId,username,saleId,salename,count) values(?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setInt(1,cart.getId());
            preparedStatement.setString(2,cart.getU_name());
            preparedStatement.setInt(3,cart.getS_id());
            preparedStatement.setString(4,cart.getName());
            preparedStatement.setInt(5,cart.getCount());
            preparedStatement.executeUpdate();
            //System.out.println("已添加");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection,preparedStatement,resultSet);
        }
    }

    @Override
    public void ChangePurchase(Cart cart) throws SQLException, ClassNotFoundException {
        if (cart.getCount() !=0) {
            //修改就是先删除后追加
            deletePurchase(cart);
            addPurchase(cart);
        }
        else{
            deletePurchase(cart);
        }
    }
    @Override
    public void ChangeCheck(O cart) throws SQLException, ClassNotFoundException{
        if (cart.getCount() != 0){
            DeleteCheck(cart);
            AddCheck(cart);
        }
        else{
            DeleteCheck(cart);
        }
    }
    @Override
    public void DeleteCheck(O cart) throws SQLException, ClassNotFoundException{
        Connection connection = JDBCUtils.getConnection();
        String sql="delete from checks where userId=? and saleId=?";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,cart.getId());
            preparedStatement.setInt(2,cart.getS_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection,preparedStatement,resultSet);
        }
    }
    @Override
    public void deletePurchase(Cart cart) throws SQLException, ClassNotFoundException {
        Connection connection = JDBCUtils.getConnection();
        String sql="delete from carts where userId=? and saleId=?";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,cart.getUser().getId());
            preparedStatement.setInt(2,cart.getSale().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection,preparedStatement,resultSet);
        }
    }

    @Override
    public void deleteAllByUser(Users user) throws SQLException, ClassNotFoundException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql="delete from carts where userId=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection,preparedStatement,resultSet);
        }
    }
}
