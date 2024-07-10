/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import connection.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import model.Account;
import model.Cart;
import model.Item;

/**
 *
 * @author Lewis
 */
public class OrderDAO extends DBContext{
    
    public void addOrder(Account a, Cart c) {
        LocalDate curDate = java.time.LocalDate.now();
        String date = curDate.toString();
        String sql = "INSERT INTO [dbo].[Orders]\n"
                + "           ([AccountID]\n "
                + "           ,[OrderTotalMoney] \n"
                + "           ,[OrderStatusId]) \n"
                + "     VALUES(?,?,1)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, a.getAccountID());
            st.setFloat(2, c.getTotalMoney());
            st.executeUpdate();
            String sql1 = "select top 1 orderID from [Orders] order by orderID desc";
            PreparedStatement st1 = connection.prepareStatement(sql1);
            ResultSet rs = st1.executeQuery();
            while (rs.next()) {
                int oid = rs.getInt("orderID");
                for (Item item : c.getItems()) {
                    String sql2 = "INSERT INTO [dbo].[OrderDetail]\n"
                            + "           ([OrderID]\n"
                            + "           ,[OrderDetailQuantity]\n"
                            + "           ,[ProductID])\n"
                            + "     VALUES\n"
                            + "           (?,?,?)";
                    PreparedStatement st2 = connection.prepareStatement(sql2);
                    st2.setInt(1, oid);
                    st2.setInt(2, item.getQuantity());
                    st2.setInt(3, item.getProduct().getProductID());
                    st2.executeUpdate();
                    String sql4 = " update Orders set OrderDate = GETDATE() where OrderID = ?";
                    PreparedStatement st4 = connection.prepareStatement(sql4);
                    st4.setInt(1, oid);
                    st4.executeUpdate();
                }
            }
            String sql3 = "update Product set productStock = productStock - ? where productID = ?";
            PreparedStatement st3 = connection.prepareStatement(sql3);
            for (Item item : c.getItems()) {
                st3.setInt(1, item.getQuantity());
                st3.setInt(2, item.getProduct().getProductID());
                st3.executeUpdate();
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        OrderDAO dao = new OrderDAO();
        //Category ca = new Category(1, "", "");
        Account a = new Account();
        Cart c = new Cart();
//        a.setAccountID(2);
//        Product p = new Product(1, "", 2, "", 2, "", true, ca);
//        Item t = new Item(p, 1, 20);
//        c.addItem(t);
        dao.addOrder(a, c);
    }
    
}
