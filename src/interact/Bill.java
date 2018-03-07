/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * CÁC PHƯƠNG THÚC CỦA ĐỐI TƯỢNG BILL
 * @author NHÓM 2
 */
public class Bill {
    
    public static void insertBill(entity.Bill bill, ArrayList<entity.Order> details) {
        try {
            Connection con = null;
            con = DataInteraction.getConnect();
            String sql = "insert into Bills values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, bill.getBillID());
            pst.setString(2, bill.getSalesID());
            pst.setString(3, bill.getDate());
            pst.setInt(4, bill.getDiscount());
            pst.setInt(5, bill.getVAT());
            pst.setString(6, bill.getPayment());
            pst.setInt(7, bill.getTotal());
            pst.setString(8, bill.getCustomerID());
            pst.setBoolean(9, bill.isStatus());
            pst.setString(10, bill.getDescript());
            
            pst.executeUpdate();
            bill.setBillID(DataInteraction.topid());
            for (entity.Order order : details) {
                interact.Order.insertOrder(bill, order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static boolean editBill(entity.Bill bill) {
        // PHƯƠNG THỨC DESTROY CỦA ĐỐI TƯỢNG BILL (EDIT STATUS = FALSE)
        String sql = "update Bills set "
                + "BillID=?, "
                + "SalesID=?, "
                + "Date=?, "
                + "Discount=?, "
                + "VAT=?, "
                + "Payment=?, "
                + "Total=?, "
                + "CustomerID=?, "
                + "Status=? "
                + "where BillID=?";
        try {
            PreparedStatement pst = interact.DataInteraction.getConnect().prepareCall(sql);
            pst.setString(1, bill.getSalesID());
            pst.setString(2, bill.getDate());
            pst.setInt(3, bill.getDiscount());
            pst.setInt(4, bill.getVAT());
            pst.setString(5, bill.getPayment());
            pst.setInt(6, bill.getTotal());
            pst.setString(7, bill.getCustomerID());
            pst.setBoolean(8, bill.isStatus());
            pst.setString(9, bill.getBillID());
            JOptionPane.showMessageDialog(null, "Destroy Bill Successfully", "Successfully", JOptionPane.INFORMATION_MESSAGE);
            return (pst.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static void deleteBill(String ID) {
        // PHƯƠNG THỨC DESTROY CỦA ĐỐI TƯỢNG BILL
        String sqlo = "delete from OrderDetails where BillID='"+ID+"'";
        String sql = "delete from Bills where BillID='"+ID+"'";
        java.sql.Statement st;
        try {
            st = interact.DataInteraction.getConnect().createStatement();
            st.executeUpdate(sqlo);
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Destroy Bill Successfully", "Successfully", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<entity.Bill> getAll() {
        try {
            Connection conn = DataInteraction.getConnect();
            PreparedStatement pst = conn.prepareStatement("select * from Bills");
            ResultSet rs = pst.executeQuery();

            ArrayList<entity.Bill> bills = new ArrayList<entity.Bill>();
            while (rs.next()) {
                entity.Bill bill = new entity.Bill();
                bill.setBillID(rs.getString("BillID"));
                bill.setSalesID(rs.getString("SalesID"));
                bill.setDate(String.valueOf(rs.getDate("Date")));
                bill.setDiscount(rs.getInt("Discount"));
                bill.setVAT(rs.getInt("VAT"));
                bill.setPayment(rs.getString("Payment"));
                bill.setTotal(rs.getInt("Total"));
                bill.setCustomerID(rs.getString("CustomerID"));
                bill.setStatus(rs.getBoolean("Status"));
                bill.setDescript(rs.getString("Descript"));
                bills.add(bill);

            }
            return bills;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            return new ArrayList<entity.Bill>();
        }
    }
}
