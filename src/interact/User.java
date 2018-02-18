/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interact;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kiems
 */
public class User {
    public static boolean insertUser(entity.User user) {
        String sql = "insert into Users values(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = DataInteraction.getConnect().prepareStatement(sql);
            pst.setString(1, user.getUserID());
            pst.setString(2, user.getUsername());
            pst.setString(3, user.getPassword());
            pst.setString(4, user.getName());
            pst.setString(5, user.getPhone());
            pst.setString(6, user.getEmail());
            pst.setString(7, user.getRoleID());
            pst.setString(8, user.getStoreID());
            pst.setInt(9, user.getSalary());
            JOptionPane.showMessageDialog(null, "Insert User success", "Successfully", JOptionPane.INFORMATION_MESSAGE);
            return (pst.executeUpdate() == 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Từ chối thêm mới! Mỗi cửa hàng chỉ có 1 Manager");
            return false;
        }
    }

    public static boolean editUser(entity.User user) {
        String sql = "update Users set Name=?, Phone=?, Email=?, Salary=? where UserID=?";
        try {
            PreparedStatement ps = interact.DataInteraction.getConnect().prepareCall(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPhone());
            ps.setString(3, user.getEmail());
            ps.setInt(4, user.getSalary());
            ps.setString(5, user.getUserID());
            JOptionPane.showMessageDialog(null, "Update User successfully", "Successfully", JOptionPane.INFORMATION_MESSAGE);
            return (ps.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void deleteUser(String ID) {
        String sql = "delete from Users where UserID='" + ID + "'";
        java.sql.Statement st;
        try {
            st = interact.DataInteraction.getConnect().createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Delete User successfully", "Successfully", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
