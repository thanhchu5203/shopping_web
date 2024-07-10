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
import model.Product;
import model.ProductDetail;

/**
 *
 * @author Lewis
 */
public class ProductDAO extends DBContext {

    public List<Product> getAll() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from "
                + "Product p inner join category c on p.categoryID = c.categoryID ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt(1));
                p.setProductName(rs.getString(2));
                p.setProductPrice(rs.getFloat(3));
                p.setProductImage(rs.getString(4));
                p.setProductStock(rs.getInt(5));
                p.setProductDescrible(rs.getString(6));
                p.setProductStatus(rs.getBoolean(7));
                Category c = new Category(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
                p.setCategory(c);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ResultSet getAllTest() {
        String sql = "select * from "
                + "Product p inner join ProductDetail pd on p.productDetail = pd.productDetailID ";
        ResultSet rs = getData(sql);
        return rs;

    }

    public List<Product> getAllByDetail(String search, String fromPrice, String toPrice, String sortType) {
        if (search == null) {
            search = "";
        }
        if (fromPrice == null || fromPrice.isEmpty()) {
            fromPrice = "0";
        }
        if (toPrice == null || toPrice.isEmpty()) {
            toPrice = "9999";
        }
        if (sortType == null || sortType.isEmpty()) {
            sortType = "order by p.productName asc";
        }

        List<Product> list = new ArrayList<>();
        String sql = "select * from "
                + "Product p inner join category c on p.categoryID = c.categoryID "
                + "where p.productPrice between ? AND ? and p.productName like ? "
                + sortType;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setDouble(1, Double.parseDouble(fromPrice));
            st.setDouble(2, Double.parseDouble(toPrice));
            st.setString(3, "%" + search + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt(1));
                p.setProductName(rs.getString(2));
                p.setProductPrice(rs.getFloat(3));
                p.setProductImage(rs.getString(4));
                p.setProductStock(rs.getInt(5));
                p.setProductDescrible(rs.getString(6));
                p.setProductStatus(rs.getBoolean(7));
                Category c = new Category(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
                p.setCategory(c);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Product getProductById(int id) {
        String sql = "select * from Product where productID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt(1));
                p.setProductName(rs.getString(2));
                p.setProductPrice(rs.getFloat(3));
                p.setProductImage(rs.getString(4));
                p.setProductStock(rs.getInt(5));
                p.setProductDescrible(rs.getString(6));
                p.setProductStatus(rs.getBoolean(7));
                Category c = new Category(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
                p.setCategory(c);

                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Product> getProductByCategoryID(int id) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from "
                + "Product p inner join category c on p.categoryID = c.categoryID "
                + "where c.categoryID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt(1));
                p.setProductName(rs.getString(2));
                p.setProductPrice(rs.getFloat(3));
                p.setProductImage(rs.getString(4));
                p.setProductStock(rs.getInt(5));
                p.setProductDescrible(rs.getString(6));
                p.setProductStatus(rs.getBoolean(7));
                Category c = new Category(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
                p.setCategory(c);

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getListByPage(List<Product> list, int start, int end) {
        ArrayList<Product> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public List<Product> getProductBySearch(String categoryID, String search, String fromPrice, String toPrice, String sortType) {
        List<Product> list = new ArrayList<>();
        if (search == null) {
            search = "";
        }
        if (categoryID == null) {
            categoryID = "0";
        }
        if (fromPrice == null || fromPrice.isEmpty()) {
            fromPrice = "0";
        }
        if (toPrice == null || toPrice.isEmpty()) {
            toPrice = "9999";
        }
        if (sortType == null || sortType.isEmpty()) {
            sortType = "order by p.productName asc";
        }

        String sql = "select * from "
                + "Product p inner join category c on p.categoryID = c.categoryID "
                + "where p.productPrice between ? AND ? and p.productName like ? "
                + "and p.categoryID like ? "
                + sortType;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setDouble(1, Double.parseDouble(fromPrice));
            st.setDouble(2, Double.parseDouble(toPrice));
            st.setString(3, "%" + search + "%");
            st.setString(4, "%" + categoryID + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt(1));
                p.setProductName(rs.getString(2));
                p.setProductPrice(rs.getFloat(3));
                p.setProductImage(rs.getString(4));
                p.setProductStock(rs.getInt(5));
                p.setProductDescrible(rs.getString(6));
                p.setProductStatus(rs.getBoolean(7));
                Category c = new Category(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
                p.setCategory(c);
//                ProductDetail pd = new ProductDetail(rs.getInt(1),
//                        rs.getInt(2),
//                        rs.getString(3),
//                        rs.getString(4));
//                p.setProductDetail(pd);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void updateProduct(String name, int price, String image, int stock, String describle,
                               int status, int productdetail, int id) {
        String sql = "UPDATE [dbo].[Product]\n"
                + "   SET [ProductName] = ?\n"
                + "      ,[ProductPrice] = ?\n"
                + "      ,[ProductImage] = ?\n"
                + "      ,[ProductStock] = ?\n"
                + "      ,[ProductDescrible] = ?\n"
                + "      ,[ProductStatus] = ?\n"
                + "      ,[ProductDetail] = ?\n"
                + " WHERE ProductID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setFloat(2, price);
            st.setString(3, image);
            st.setInt(4, stock);
            st.setString(5, describle);
            st.setInt(6, status);
            st.setInt(7, productdetail);
            st.setInt(8, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void insertProduct(String name, int price, String image, int stock, String describle,
                               int status, int categoryID, int productdetail) {
        String sql = "insert into Product values(?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setFloat(2, price);
            st.setString(3, image);
            st.setInt(4, stock);
            st.setString(5, describle);
            st.setInt(6, status);
            st.setInt(7, categoryID);
            st.setInt(8, productdetail);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void deleteProduct(int id) {
        String sql = "DELETE FROM [dbo].[Product]\n"
                + "      WHERE ProductID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws SQLException {
        ProductDAO dao = new ProductDAO();
//        List<Product> list = dao.getProductByCategoryID(3);
//        Product p = dao.getProductById(2);
//        ResultSet rs = dao.getData("select * from Product p inner join category c on p.categoryID = c.categoryID");
//        ResultSet rs1 = dao.getAllTest();
//        System.out.println(p.getProductImage());
//        System.out.println(list.size());
//        while (rs1.next()) {
//            System.out.println(rs1.getInt(1));
//        }
    dao.insertProduct("fd", 1, "image", 1, "fd", 1, 1, 1);
    
    }

}
