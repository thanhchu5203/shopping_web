/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lewis
 */
public class Category {
    private int categoryID;
    private String categoryName;
    private String categoryDescrible;

    public Category() {
    }

    public Category(int categoryID, String categoryName, String categoryDescrible) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.categoryDescrible = categoryDescrible;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescrible() {
        return categoryDescrible;
    }

    public void setCategoryDescrible(String categoryDescrible) {
        this.categoryDescrible = categoryDescrible;
    }
    
    
}
