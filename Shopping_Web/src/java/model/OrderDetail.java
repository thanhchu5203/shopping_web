/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lewis
 */
public class OrderDetail {
    
    private int orderDetailID;
    private int orderID;
    private int orderDetailQuantity;
    private int productID;

    public OrderDetail() {
    }

    public OrderDetail(int orderDetailID, int orderID, int orderDetailQuantity, int productID) {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;
        this.orderDetailQuantity = orderDetailQuantity;
        this.productID = productID;
    }

    public int getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(int orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getOrderDetailQuantity() {
        return orderDetailQuantity;
    }

    public void setOrderDetailQuantity(int orderDetailQuantity) {
        this.orderDetailQuantity = orderDetailQuantity;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
    
    
}
