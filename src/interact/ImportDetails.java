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
 *
 * @author DESKTOP-EQP0G7D
 */
public class ImportDetails {
    public static boolean insertImport(entity.ImportDetails imports) {
        String sql = "insert into ImportDetails values(?,?,?,?,?)";
        try {
            PreparedStatement pst = DataInteraction.getConnect().prepareStatement(sql);
            pst.setString(1, imports.getImportID());
            pst.setString(2, imports.getProductID());
            pst.setInt(3, imports.getQuantityUpdate());
            pst.setString(4, imports.getDateImport());
            pst.setString(5, imports.getExpireDate());
            JOptionPane.showMessageDialog(null, "Update quantity success", "Successfully", JOptionPane.INFORMATION_MESSAGE);
            return (pst.executeUpdate() == 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }
    
    public static boolean editImport(entity.ImportDetails imports) {
        // PHƯƠNG THỨC EDIT CỦA ĐỐI TƯỢNG 
        String sql = "update ImportDetails set QuantityUpdate=?, DateImport=?, ExpireDate=?  where ImportID=?";
        try {
            PreparedStatement pst = interact.DataInteraction.getConnect().prepareCall(sql);
            pst.setString(1, imports.getProductID());
            pst.setInt(2, imports.getQuantityUpdate());
            pst.setString(3, imports.getDateImport());
            pst.setString(4, imports.getExpireDate());
            pst.setString(1, imports.getImportID());
            JOptionPane.showMessageDialog(null, "Update Products successfully", "Successfully", JOptionPane.INFORMATION_MESSAGE);
            return (pst.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static void deleteImports(String ID) {
        // PHƯƠNG THỨC DELETE CỦA ĐỐI TƯỢNG 
        String sql = "delete from ImportDetails where ProductID='" + ID + "'";
        java.sql.Statement st;
        try {
            st = interact.DataInteraction.getConnect().createStatement();
            st.executeUpdate(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static ArrayList<entity.ImportDetails> getAllByID(String imports) {
        ArrayList<entity.ImportDetails> details = new ArrayList<entity.ImportDetails>();
        Connection con = DataInteraction.getConnect();
        try {
            PreparedStatement pst = con.prepareStatement("select * from ImportDetails where ProductID=?");
            pst.setString(1, imports);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                entity.ImportDetails impor = new entity.ImportDetails();
                impor.setImportID(rs.getString("ImportID"));
                impor.setProductID(rs.getString("ProductID"));
                impor.setQuantityUpdate(rs.getInt("QuantityUpdate"));
                impor.setDateImport(rs.getString("DateImport"));
                impor.setExpireDate(rs.getString("ExpireDate"));
                details.add(impor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
        return details;
    }
}
