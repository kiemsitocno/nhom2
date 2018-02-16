/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interact;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kiems
 */
public class Store {
    public static boolean insertStore(entity.Store store) {
        String sql = "insert into Stores values(?,?,?,?,?)";
        try {
            PreparedStatement pst = DataInteraction.getConnect().prepareStatement(sql);
            pst.setString(1, store.getStoreID());
            pst.setString(2, store.getStoreName());
            pst.setString(3, store.getStorePhone());
            pst.setString(4, store.getStoreAddress());
            pst.setInt(5, store.getStoreRent());
            return (pst.executeUpdate() == 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Insert to stores Fail" + ex.getMessage());
            return false;
        }
    }
    
    public static boolean editStore(entity.Store store){
        String sql = "update Stores set StoreName=?, StorePhone=?, StoreAddress=?, StoreRent=? where StoreID=?";
        try {
            PreparedStatement ps = interact.DataInteraction.getConnect().prepareCall(sql);
            ps.setString(1,store.getStoreName());
            ps.setString(2,store.getStorePhone());
            ps.setString(3,store.getStoreAddress());
            ps.setInt(4,store.getStoreRent());
            ps.setString(5,store.getStoreID());
            JOptionPane.showMessageDialog(null, "Update Category successfully","Successfully",JOptionPane.INFORMATION_MESSAGE);
            return (ps.executeUpdate()==1);
        } catch (SQLException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static void deleteStore(String ID){
        String sql = "delete from Stores where StoreID='" + ID + "'";
        java.sql.Statement st;
        try {
            st = interact.DataInteraction.getConnect().createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Delete Store successfully","Successfully",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
