/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interact;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kiems
 */
public class Customer {
    public static boolean insertCustomer(entity.Customer customer) {
        String sql = "insert into Customers values(?,?,?,?,?,?)";
        try {
            PreparedStatement pst = DataInteraction.getConnect().prepareStatement(sql);
            pst.setString(1, customer.getCustomerID());
            pst.setString(2, customer.getCustomerName());
            pst.setString(3, customer.getAddress());
            pst.setString(4, customer.getPhone());
            pst.setString(5, customer.getEmail());
            pst.setString(6, customer.getGender());
            JOptionPane.showMessageDialog(null, "Insert Customer success", "Successfully", JOptionPane.INFORMATION_MESSAGE);
            return (pst.executeUpdate() == 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }
    
    public static boolean editCustomer(entity.Customer customer) {
        String sql = "update Customers set CustomerName=?, Address=?, Phone=?, Email=?, Gender=? where CustomerID=?";
        try {
            PreparedStatement pst = interact.DataInteraction.getConnect().prepareCall(sql);
            pst.setString(1, customer.getCustomerName());
            pst.setString(2, customer.getAddress());
            pst.setString(3, customer.getPhone());
            pst.setString(4, customer.getEmail());
            pst.setString(5, customer.getGender());
            pst.setString(6, customer.getCustomerID());
            JOptionPane.showMessageDialog(null, "Update Customer successfully", "Successfully", JOptionPane.INFORMATION_MESSAGE);
            return (pst.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static void deleteCustomer(String ID) {
        // PHƯƠNG THỨC DELETE CỦA ĐỐI TƯỢNG CUSTOMER
        String sql = "delete from Customers where CustomerID='" + ID + "'";
        java.sql.Statement st;
        try {
            st = interact.DataInteraction.getConnect().createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Delete Customers successfully", "Successfully", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<entity.Customer> getAll() {
        ArrayList<entity.Customer> list = new ArrayList<entity.Customer>();
        ResultSet rs = DataInteraction.queryResultSet("select * from Customers");
        try {
            while (rs.next()) {
                entity.Customer c = new entity.Customer();
                c.setCustomerID(rs.getString("CustomerID"));
                c.setCustomerName(rs.getString("CustomerName"));
                c.setAddress(rs.getString("Address"));
                c.setPhone(rs.getString("Phone"));
                c.setEmail(rs.getString("Email"));
                c.setGender(rs.getString("Gender"));
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
