/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interact;

/**
 * CÁC PHƯƠNG THỨC CỦA ĐỐI TƯỢNG PRODUCT
 * @author NHÓM 2
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author kiems
 */
public class Product {
    // PHƯƠNG THỨC INSERT CỦA ĐỐI TƯỢNG PRODUCT
    public static boolean insertProduct(entity.Product product) {
        String sql = "insert into Products values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = DataInteraction.getConnect().prepareStatement(sql);
            pst.setString(1, product.getProductID());
            pst.setString(2, product.getProductName());
            pst.setInt(3, product.getQuantityAvailable());
            pst.setInt(4, product.getPrice());
            pst.setString(5, product.getDescript());
            pst.setString(6, product.getCategoryID());
            pst.setInt(7, product.getVolume());
            JOptionPane.showMessageDialog(null, "Insert product success", "Successfully", JOptionPane.INFORMATION_MESSAGE);
            return (pst.executeUpdate() == 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }
    
    public static boolean editProducts(entity.Product product) {
        // PHƯƠNG THỨC EDIT CỦA ĐỐI TƯỢNG PRODUCT
        String sql = "update Products set ProductName=?, QuantityAvailable=?, Price=?, Descript=?, CategoryID=?, Volume=? where ProductID=?";
        try {
            PreparedStatement ps = interact.DataInteraction.getConnect().prepareCall(sql);
            ps.setString(1, product.getProductName());
            ps.setInt(2, product.getQuantityAvailable());
            ps.setInt(3, product.getPrice());
            ps.setString(4, product.getDescript());
            ps.setString(5, product.getCategoryID());
            ps.setInt(6, product.getVolume());
            ps.setString(7, product.getProductID());
            JOptionPane.showMessageDialog(null, "Update Products successfully", "Successfully", JOptionPane.INFORMATION_MESSAGE);
            return (ps.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static void deleteProduct(String ID) {
        // PHƯƠNG THỨC DELETE CỦA ĐỐI TƯỢNG PRODUCT
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
    
    public static entity.Product getByCode(String code) {
        String sql = "select * from Products where ProductID=?";
        entity.Product product = null;
        try {
            PreparedStatement pst = DataInteraction.getConnect().prepareStatement(sql);
            pst.setString(1, code);
            ResultSet rsProduct = pst.executeQuery();
            if (!rsProduct.next()) {
                return null;
            }
            product = new entity.Product();
            product.setProductID(rsProduct.getString("ProductID"));
            product.setProductName(rsProduct.getString("ProductName"));
            product.setQuantityAvailable(rsProduct.getInt("QuantityAvailable"));
            product.setPrice(rsProduct.getInt("Price"));
            product.setDescript(String.valueOf(rsProduct.getString("Descript")));
            product.setCategoryID(String.valueOf(rsProduct.getString("CategoryID")));
            product.setVolume(rsProduct.getInt("Volume"));
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }
}
