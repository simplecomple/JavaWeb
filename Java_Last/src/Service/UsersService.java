package Service;
import Bean.Users;
import store.US;
import store.*;

import java.sql.SQLException;

public class UsersService implements UserService{
    private US us = new USS();
    @Override
    public void register(Users user) throws SQLException, ClassNotFoundException {
        us.register(user);
    }

    @Override
    public Users login(String username, String password) throws SQLException, ClassNotFoundException {
        return us.login(username,password);
    }
}
