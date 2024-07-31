/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import connection.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import model.Account;
import model.Category;
import model.Role;

/**
 *
 * @author Lewis
 */
public class AccountDAO extends DBContext {

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public List<Account> getAll() {
        List<Account> list = new ArrayList<>();
        String sql = "select * from Account";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                a.setAccountID(rs.getInt(1));
                a.setAccountUser(rs.getString(2));
                a.setAccountPassword(rs.getString(3));
                a.setAccountName(rs.getString(4));
                a.setAccountEmail(rs.getString(5));
                a.setAccountDob(rs.getString(6));
                a.setAccountMobile(rs.getString(7));
                a.setAccountAddress(rs.getString(8));
                Role r = new Role(rs.getInt(1),
                        rs.getString(2));
                a.setRole(r);
                list.add(a);
            }

        } catch (SQLException e) {
            System.out.println(e);

        }
        return list;
    }

    public Account getAccountByID(int id) {
        String sql = "select * from Account where accountID = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account a = new Account();
                a.setAccountID(rs.getInt(1));
                a.setAccountUser(rs.getString(2));
                a.setAccountPassword(rs.getString(3));
                a.setAccountName(rs.getString(4));
                a.setAccountEmail(rs.getString(5));
                a.setAccountDob(rs.getString(6));
                a.setAccountMobile(rs.getString(7));
                a.setAccountAddress(rs.getString(8));
                Role r = new Role(rs.getInt(1),
                        rs.getString(2));
                a.setRole(r);
                return a;
            }

        } catch (SQLException e) {
            System.out.println(e);

        }
        return null;
    }

    public Account login(String user, String pass) {
        String sql = "select * from account where AccountUser = ? and AccountPassword = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account a = new Account();
                a.setAccountID(rs.getInt(1));
                a.setAccountUser(rs.getString(2));
                a.setAccountPassword(rs.getString(3));
                a.setAccountName(rs.getString(4));
                a.setAccountEmail(rs.getString(5));
                a.setAccountDob(rs.getString(6));
                a.setAccountMobile(rs.getString(7));
                a.setAccountAddress(rs.getString(8));
                Role r = new Role(rs.getInt(1),
                        rs.getString(2));
                a.setRole(r);
                return a;
            }

        } catch (SQLException e) {
            System.out.println(e);

        }
        return null;
    }

    public boolean registerAccount(String user, String pass, String name, String email,
            String dob, String mobile, String address) {
        String sql = "INSERT INTO [dbo].[Account]\n"
                + "           ([AccountUser]\n"
                + "           ,[AccountPassword]\n"
                + "           ,[AccountName]\n"
                + "           ,[AccountEmail]\n"
                + "           ,[AccountDob]\n"
                + "           ,[AccountMobile]\n"
                + "           ,[AccountAddress]\n"
                + "           ,[RoleID])\n"
                + "     VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            st.setString(3, name);
            st.setString(4, email);
            st.setString(5, dob);
            st.setString(6, mobile);
            st.setString(7, address);
            st.setInt(8, 2);
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);

        }
        return false;
    }

    public boolean updateAccount(int id, String name, String email,
            String dob, String mobile, String address) {
        String sql = "UPDATE [dbo].[Account]\n"
                + "      SET [AccountName] = ?\n"
                + "      ,[AccountEmail] = ?\n"
                + "      ,[AccountDob] = ?\n"
                + "      ,[AccountMobile] = ?\n"
                + "      ,[AccountAddress] = ?\n"
                + "      ,[RoleID] = ?\n"
                + " WHERE AccountID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, email);
            st.setString(3, dob);
            st.setString(4, mobile);
            st.setString(5, address);
            st.setInt(6, 2);
            st.setInt(7, id);
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);

        }
        return false;
    }
    
    
    public boolean accountExists(String username) {
        String query = "select count(*) from account where AccountUser = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

//    public boolean registerAccount(String user, String pass, String name, String email, String dob, String mobile, String address) {
//        String query = "INSERT INTO Accounts (username, password, name, email, dob, mobile, address) VALUES (?, ?, ?, ?, ?, ?, ?)";
//        try (PreparedStatement ps = connection.prepareStatement(query)) {
//            ps.setString(1, user);
//            ps.setString(2, pass);
//            ps.setString(3, name);
//            ps.setString(4, email);
//            ps.setString(5, dob);
//            ps.setString(6, mobile);
//            ps.setString(7, address);
//            int rowsAffected = ps.executeUpdate();
//            return rowsAffected > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
    

//    public static String generateRandomString(int length) {
//        Random random = new Random();
//        StringBuilder sb = new StringBuilder(length);
//
//        for (int i = 0; i < length; i++) {
//            int randomIndex = random.nextInt(CHARACTERS.length());
//            char randomChar = CHARACTERS.charAt(randomIndex);
//            sb.append(randomChar);
//        }
//
//        return sb.toString();
//    }
//    public void updateAccount()
    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
        List<Account> list = dao.getAll();
        Account a1 = dao.getAccountByID(1);
        System.out.println(list.size());
    }

}
