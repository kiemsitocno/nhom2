/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 * ĐỐI TƯỢNG ORDER
 * @author NHÓM 2
 */
public class Order {
    private String orderID;
    private String billID;
    private String productID;
    private int quantity;
    private int price;

    public Order() {
    }

    public Order(String orderID, String billID, String productID, int quantity, int price) {
        this.orderID = orderID;
        this.billID = billID;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
