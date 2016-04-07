package com.jundat95.woorestaurant.ListOrders;

import com.jundat95.woorestaurant.Orders.ItemOrders;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by jundat95 on 18/03/2016.
 */
public class ListOrdersOBJ implements Serializable {

    private int orderID;
    private String orderName;
    private String orderAddress;
    private String orderAddress1;
    private String orderCity;
    private String orderNote;
    private String orderPhone;
    private String orderEmail;
    private String orderTime;
    private boolean orderPaid;
    private ArrayList<ItemOrders> itemOrders = new ArrayList<ItemOrders>();


    public ListOrdersOBJ(){}

    public ListOrdersOBJ(int orderID, String orderName, String orderAddress, String orderPhone, String orderEmail, String orderTime, boolean orderPaid, ArrayList<ItemOrders> itemOrders) {
        this.orderID = orderID;
        this.orderName = orderName;
        this.orderAddress = orderAddress;

        this.orderPhone = orderPhone;
        this.orderEmail = orderEmail;
        this.orderTime = orderTime;
        this.orderPaid = orderPaid;
        this.itemOrders = itemOrders;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getOrderAddress1() {
        return orderAddress1;
    }

    public void setOrderAddress1(String orderAddress1) {
        this.orderAddress1 = orderAddress1;
    }

    public String getOrderCity() {
        return orderCity;
    }

    public void setOrderCity(String orderCity) {
        this.orderCity = orderCity;
    }

    public String getOrderNote() {
        return orderNote;
    }

    public void setOrderNote(String orderNote) {
        this.orderNote = orderNote;
    }

    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }

    public String getOrderEmail() {
        return orderEmail;
    }

    public void setOrderEmail(String orderEmail) {
        this.orderEmail = orderEmail;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public boolean isOrderPaid() {
        return orderPaid;
    }

    public void setOrderPaid(boolean orderPaid) {
        this.orderPaid = orderPaid;
    }

    public ArrayList<ItemOrders> getItemOrders() {
        return itemOrders;
    }

    public void setItemOrders(ItemOrders itemOrders) {
        this.itemOrders.add(itemOrders);
    }

}
