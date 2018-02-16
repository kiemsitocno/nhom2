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
public class Store {
    private String storeID;
    private String storeName;
    private String storePhone;
    private String storeAddress;
    private int storeRent;

    public Store() {
    }

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public int getStoreRent() {
        return storeRent;
    }

    public void setStoreRent(int storeRent) {
        this.storeRent = storeRent;
    }

    public Store(String storeID, String storeName, String storePhone, String storeAddress, int storeRent) {
        this.storeID = storeID;
        this.storeName = storeName;
        this.storePhone = storePhone;
        this.storeAddress = storeAddress;
        this.storeRent = storeRent;
    }
}
