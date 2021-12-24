package Service;

import Bean.*;
import store.CS;
import store.CSS;

import java.sql.SQLException;
import java.util.List;

public class CartsService implements CartService {
    private CS cs= new CSS();
    @Override
    public List<Cart> listAllByUser(Users user) throws SQLException, ClassNotFoundException {
        return cs.listAllByUser(user);
    }
    @Override
    public List<O> listAllSale() throws SQLException, ClassNotFoundException {
        return cs.listAllSale();
    }
    @Override
    public void addPurchase(Cart cart) throws SQLException, ClassNotFoundException {
        cs.addPurchase(cart);
    }

    @Override
    public void ChangePurchase(Cart cart) throws SQLException, ClassNotFoundException {
        cs.ChangePurchase(cart);
    }
    @Override
    public void deletePurchase(Cart cart) throws SQLException, ClassNotFoundException{
        cs.deletePurchase(cart);
    }
    @Override
    public void AddCheck(O cart) throws SQLException, ClassNotFoundException{
        cs.AddCheck(cart);
    }
    @Override
    public void ChangeCheck(O cart) throws SQLException, ClassNotFoundException{
        cs.ChangeCheck(cart);
    }
    @Override
    public void DeleteCheck(O cart) throws SQLException, ClassNotFoundException{
        cs.DeleteCheck(cart);
    }


    @Override
    public void deleteAllByUser(Users user) throws SQLException, ClassNotFoundException {
        cs.deleteAllByUser(user);
    }
}