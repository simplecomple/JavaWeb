package Service;

import Bean.Users;

import java.sql.SQLException;

public interface UserService {
    public void register(Users user) throws SQLException, ClassNotFoundException;
    public Users login(String username, String password) throws SQLException, ClassNotFoundException;
}
