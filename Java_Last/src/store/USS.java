package store;

import Bean.Users;
import store.US;
import Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class USS implements US {
    @Override
    public void register(Users user) throws SQLException, ClassNotFoundException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql="insert into user(id,u_name,password,gender,email,role) values(?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setInt(4,user.getGender());
            preparedStatement.setString(5,user.getEmail());
            preparedStatement.setString(6,user.getRole());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection,preparedStatement,resultSet);
        }
    }

    @Override
    public Users login(String username, String password) throws SQLException, ClassNotFoundException {
        Connection connection = JDBCUtils.getConnection();
        String sql="select * from user where u_name=? and password=?";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        Users user=null;
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                //若存在相应的用户，则返回该用户信息
                Integer id_r=resultSet.getInt(1);
                String username_r=resultSet.getString(2);
                String password_r=resultSet.getString(3);
                Integer gender_r=resultSet.getInt(4);
                String email_r=resultSet.getString(5);
                String role_r=resultSet.getString(6);
                user=new Users(id_r,username_r,password_r,gender_r,email_r,role_r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放连接
            JDBCUtils.close(connection,preparedStatement,resultSet);
        }
        return user;
    }

}
