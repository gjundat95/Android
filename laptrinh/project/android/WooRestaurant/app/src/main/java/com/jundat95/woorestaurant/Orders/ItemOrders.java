package com.jundat95.woorestaurant.Orders;

import java.io.Serializable;

/**
 * Created by jundat95 on 20/03/2016.
 */
public class ItemOrders implements Serializable{

    private String Name;
    private String Price;
    private int Quantity;

    public ItemOrders() {}

    public ItemOrders(String name, String price, int quantity) {
        Name = name;
        Price = price;
        Quantity = quantity;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
