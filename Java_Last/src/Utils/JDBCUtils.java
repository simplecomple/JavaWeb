package Utils;

import java.sql.*;

public class JDBCUtils {
    public static Connection getConnection() throws SQLException,ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/shopping";
        String username="shopping";
        String password="3S3K76YG6jAMEPhK";

        Connection con = DriverManager.getConnection(url,username,password);
        return con;
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if(connection != null){
                connection.close();
            }
            if(statement != null){
                statement.close();
            }
            if(resultSet != null){
                resultSet.close();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
