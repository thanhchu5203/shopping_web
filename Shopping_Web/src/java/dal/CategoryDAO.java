/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import connection.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;

/**
 *
 * @author Lewis
 */
public class CategoryDAO extends DBContext {

    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();
        String sql = "select * from Category";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category p = new Category(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
                list.add(p);
            }
        } catch (SQLException e) {
        }

        return list;
    }
    
    public void insert(Category c) {
        String sql = "insert into Category values(?,?,?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getCategoryID());
            st.setString(2, c.getCategoryName());
            st.setString(3, c.getCategoryDescrible());
            //before execute add information for ???  
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

//    public Category getCategoryById(int id) {
//        String sql = "select * from Category where categoryID = ?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, id);
//            ResultSet rs = st.executeQuery();
//            if (rs.next()) {
//                Category c = new Category(rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3));
//                return c;
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return null;
//    }

    public void delete(int id) {
        String sql = "DELETE FROM [dbo].[Category]\n"
                + "      WHERE categoryID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // update
    public void update(Category c) {
        String sql = "UPDATE [dbo].[Category]\n"
                + "   SET [name] = ?,[describe] = ?\n"
                + " WHERE categoryID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getCategoryName());
            st.setString(2, c.getCategoryDescrible());
            st.setInt(3, c.getCategoryID());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    
}
