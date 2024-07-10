/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Lewis
 */
public class ProductDetail {
    private int productDetailID;
    private int productID;
    private String productDetailSize;
    private String productDetailColor;

    public ProductDetail() {
    }

    public ProductDetail(int productDetailID, int productID) {
        this.productDetailID = productDetailID;
        this.productID = productID;
    }

    
    
    public ProductDetail(int productDetailID, int productID, String productDetailSize, String productDetailColor) {
        this.productDetailID = productDetailID;
        this.productID = productID;
        this.productDetailSize = productDetailSize;
        this.productDetailColor = productDetailColor;
    }

    public int getProductDetailID() {
        return productDetailID;
    }

    public void setProductDetailID(int productDetailID) {
        this.productDetailID = productDetailID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductDetailSize() {
        return productDetailSize;
    }

    public void setProductDetailSize(String productDetailSize) {
        this.productDetailSize = productDetailSize;
    }

    public String getProductDetailColor() {
        return productDetailColor;
    }

    public void setProductDetailColor(String productDetailColor) {
        this.productDetailColor = productDetailColor;
    }
    
    public ArrayList<String> listSize(String productDetailSize){
        String[] list = productDetailSize.split(" ");
        ArrayList<String> listSize = new ArrayList<>(Arrays.asList(list));
        return listSize;
    }
}
