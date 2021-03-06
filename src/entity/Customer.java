/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 * ĐỐI TƯỢNG CUSTOMER
 * @author NHÓM 2
 */
public class Customer {
    private String customerID;  //1
    private String customerName;//2
    private String address;     //3
    private String phone;       //4
    private String email;       //5
    private String gender;      //6

    public Customer() {
    }

    public Customer(String customerID, String customerName, String address, String phone, String email, String gender) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
}
