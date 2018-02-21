/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interact;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author kiems
 */
public class Product {
    public static boolean insertProduct(entity.Product product) {
        String sql = "insert into Products values(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = DataInteraction.getConnect().prepareStatement(sql);
            pst.setString(1, product.getProductID());
            pst.setString(2, product.getProductName());
            pst.setInt(3, product.getQuantityAvailable());
            pst.setInt(4, product.getPrice());
            pst.setString(5, product.getDateImport());
            pst.setString(6, product.getExpireDate());
            pst.setString(7, product.getDescript());
            pst.setString(8, product.getCategoryID());
            pst.setInt(9, product.getVolume());
            JOptionPane.showMessageDialog(null, "Insert product success", "Successfully", JOptionPane.INFORMATION_MESSAGE);
            return (pst.executeUpdate() == 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }
    
    public static boolean editProducts(entity.Product product) {
        String sql = "update Products set ProductName=?, QuantityAvailable=?, Price=?, DateImport=?, ExpireDate=?, Descript=?, CategoryID=?, Volume=? where ProductID=?";
        try {
            PreparedStatement ps = interact.DataInteraction.getConnect().prepareCall(sql);
            ps.setString(1, product.getProductName());
            ps.setInt(2, product.getQuantityAvailable());
            ps.setInt(3, product.getPrice());
            ps.setString(4, product.getDateImport());
            ps.setString(5, product.getExpireDate());
            ps.setString(6, product.getDescript());
            ps.setString(7, product.getCategoryID());
            ps.setInt(8, product.getVolume());
            ps.setString(9, product.getProductID());
            JOptionPane.showMessageDialog(null, "Update Products successfully", "Successfully", JOptionPane.INFORMATION_MESSAGE);
            return (ps.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static void deleteProduct(String ID) {
        String sql = "delete from Products where ProductID='" + ID + "'";
        java.sql.Statement st;
        try {
            st = interact.DataInteraction.getConnect().createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Delete Product successfully", "Successfully", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
