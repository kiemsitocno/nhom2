/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author kiems
 */
public class Product {
    private String productID;       //1
    private String productName;     //2
    private int quantityAvailable;  //3
    private int price;              //4
    private String dateImport;      //5
    private String expireDate;      //6
    private String descript;        //7
    private String categoryID;      //8
    private int volume;             //9

    public Product() {
    }

    public Product(String productID, String productName, int quantityAvailable, int price, String dateImport, String expireDate, String descript, String categoryID, int volume) {
        this.productID = productID;
        this.productName = productName;
        this.quantityAvailable = quantityAvailable;
        this.price = price;
        this.dateImport = dateImport;
        this.expireDate = expireDate;
        this.descript = descript;
        this.categoryID = categoryID;
        this.volume = volume;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDateImport() {
        return dateImport;
    }

    public void setDateImport(String dateImport) {
        this.dateImport = dateImport;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    
}
