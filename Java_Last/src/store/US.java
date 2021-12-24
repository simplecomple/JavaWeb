package store;

import Bean.Users;

import java.sql.SQLException;

public interface US {
    //用户注册
    public void register(Users user) throws SQLException, ClassNotFoundException;
    //用户登录
    public Users login(String username, String password) throws SQLException, ClassNotFoundException;
}