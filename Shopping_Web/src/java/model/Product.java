/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lewis
 */
public class Product {
    private int productID;
    private String productName;
    private float productPrice;
    private String productImage;
    private int productStock;
    private String productDescrible;
    private boolean productStatus;
    private Category category;
    private int productDetail;

    public Product() {
    }

    public Product(int productID, String productName, float productPrice, String productImage, int productStock, String productDescrible, boolean productStatus, Category category, int productDetail) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.productStock = productStock;
        this.productDescrible = productDescrible;
        this.productStatus = productStatus;
        this.category = category;
        this.productDetail = productDetail;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public String getProductDescrible() {
        return productDescrible;
    }

    public void setProductDescrible(String productDescrible) {
        this.productDescrible = productDescrible;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(int productDetail) {
        this.productDetail = productDetail;
    }
    
}
