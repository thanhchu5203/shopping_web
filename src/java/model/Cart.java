/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lewis
 */
public class Cart {
    private List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public Cart(List<Item> items) {
        this.items = items;
    }
    
    public List<Item> getItems(){
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    public Item getItemById(int id){
        for (Item item : items) {
            if(item.getProduct().getProductID()==id){
                return item;
            }
        }
        return null;
    }
    
    public int getQuantityById(int id){
        return getItemById(id).getQuantity();
    }
    
    public void addItem(Item t){
        if(checkExist(t.getProduct().getProductID())){
            Item m = getItemById(t.getProduct().getProductID());
            m.setQuantity(m.getQuantity()+t.getQuantity());
        }
        else{
            items.add(t);
        }
    }
    
    public void changeQuantity(int pid, int quantity){
        Item item = getItemById(pid);
        item.setQuantity(quantity);
        if(quantity == 0){
            removeItem(pid);
        }
    }
    
    public void removeItem(int id){
        if(getItemById(id) != null){
            items.remove(getItemById(id));
        }
    }
    
    public float getTotalMoney(){
        float total = 0;
        for (Item item : items) {
            total += item.getPrice()*item.getQuantity();
        }
        return total;
    }
    
    public boolean checkExist(int id){
        for (Item item : items) {
            if(item.getProduct().getProductID() == id){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cart{");
        sb.append("items=").append(items);
        sb.append('}');
        return sb.toString();
    }

    
    
    
}
