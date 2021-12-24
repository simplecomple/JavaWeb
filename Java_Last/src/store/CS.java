package store;

import Bean.*;

import java.sql.SQLException;
import java.util.List;

public interface CS {
    public List<Cart> listAllByUser(Users user) throws SQLException, ClassNotFoundException;
    public List<O> listAllSale() throws SQLException, ClassNotFoundException;
    public void addPurchase(Cart cart) throws SQLException, ClassNotFoundException;
    public void AddCheck(O cart) throws SQLException, ClassNotFoundException;
    public void ChangePurchase(Cart cart) throws SQLException, ClassNotFoundException;
    public void ChangeCheck(O cart) throws SQLException, ClassNotFoundException;
    public void deletePurchase(Cart cart) throws SQLException, ClassNotFoundException;
    public void DeleteCheck(O cart) throws SQLException, ClassNotFoundException;
    public void deleteAllByUser(Users user) throws SQLException, ClassNotFoundException;
}
