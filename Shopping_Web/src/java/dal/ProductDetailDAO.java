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
import model.Product;
import model.ProductDetail;

/**
 *
 * @author Lewis
 */
public class ProductDetailDAO extends DBContext {

    public List<ProductDetail> getAll() {
        List<ProductDetail> list = new ArrayList<>();
        String sql = "select * from "
                + "ProductDetail pd inner join Product p on p.productID = pd.productID";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductDetail pd = new ProductDetail(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4));
                list.add(pd);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ProductDetail getProductDetailByID(int id) {
        String sql = "select * from ProductDetail where productID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                ProductDetail pd = new ProductDetail(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4));
                return pd;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void updateProductDetail(int id, String size, String color) {
        String sql = "UPDATE [dbo].[ProductDetail]\n"
                + "   SET [ProductID] = ?\n"
                + "      ,[ProductDetailSize] = ?\n"
                + "      ,[ProductDetailColor] = ?\n"
                + " WHERE ProductID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.setString(2, size);
            st.setString(3, color);
            st.setInt(4, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insertProductDetail(int id, String size, String color) {
        String sql = "insert into ProductDetail values(?,?,?,?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.setString(2, size);
            st.setString(3, color);
            st.setInt(4, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteProductDetail(int id) {
        String sql = "DELETE FROM [dbo].[ProductDetail]\n"
                + "      WHERE ProductID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        ProductDetailDAO dao = new ProductDetailDAO();
        List<ProductDetail> list = dao.getAll();
        ProductDetail pd = dao.getProductDetailByID(2);
        System.out.println(pd.getProductDetailSize());
        System.out.println(list.size());
    }

}
