/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 * ĐỐI TƯỢNG BILL
 * @author NHÓM 2
 */
public class Bill {
    private String billID;      //1
    private String salesID;     //2
    private String date;        //3
    private int discount;       //4
    private int VAT;            //5
    private String payment;     //6
    private int total;          //7    
    private String customerID;  //8
    private boolean Status;     //9
    private String descript;    // 10

    public Bill() {
    }

    public Bill(String billID, String salesID, String date, int discount, int VAT, String payment, int total, String customerID, boolean Status, String descript) {
        this.billID = billID;
        this.salesID = salesID;
        this.date = date;
        this.discount = discount;
        this.VAT = VAT;
        this.payment = payment;
        this.total = total;
        this.customerID = customerID;
        this.Status = Status;
        this.descript = descript;
    }
    
    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public String getSalesID() {
        return salesID;
    }

    public void setSalesID(String salesID) {
        this.salesID = salesID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getVAT() {
        return VAT;
    }

    public void setVAT(int VAT) {
        this.VAT = VAT;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }
    
    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }
}
