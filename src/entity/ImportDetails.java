/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author DESKTOP-EQP0G7D
 */
public class ImportDetails {
    private String importID;
    private String productID;
    private int quantityUpdate;
    private String dateImport;
    private String expireDate;

    public ImportDetails() {
    }

    public ImportDetails(String importID, String productID, int quantityUpdate, String dateImport, String expireDate) {
        this.importID = importID;
        this.productID = productID;
        this.quantityUpdate = quantityUpdate;
        this.dateImport = dateImport;
        this.expireDate = expireDate;
    }

    public String getImportID() {
        return importID;
    }

    public void setImportID(String importID) {
        this.importID = importID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getQuantityUpdate() {
        return quantityUpdate;
    }

    public void setQuantityUpdate(int quantityUpdate) {
        this.quantityUpdate = quantityUpdate;
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
    
}
