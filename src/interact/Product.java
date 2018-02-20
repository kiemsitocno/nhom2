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
}
