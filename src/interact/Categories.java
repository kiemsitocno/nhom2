/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package interact;

import entity.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Categories {
    public static boolean insertCategory(entity.Category category){
        try {
            String sql = "insert into Categories values(?,?)";
            
            PreparedStatement pst = DataInteraction.getConnect().prepareStatement(sql);
            pst.setString(1, category.getCategoryID());
            pst.setString(2, category.getCategoryName());
            JOptionPane.showMessageDialog(null, "Insert to categories success", "Successfully", JOptionPane.INFORMATION_MESSAGE);
            return (pst.executeUpdate() == 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Insert to categories Fail" + ex.getMessage());
            return false;
        }
       
           
        
    }
    public static boolean editCategory(entity.Category EC){
        String sql = "update Categories set CategoryName=? where CategoryID=?";
        try {
            PreparedStatement ps = interact.DataInteraction.getConnect().prepareCall(sql);
            ps.setString(1,EC.getCategoryName() );
            ps.setString(2,EC.getCategoryID());
            JOptionPane.showMessageDialog(null, "Update Category successfully","Successfully",JOptionPane.INFORMATION_MESSAGE);
            return (ps.executeUpdate()==1);
        } catch (SQLException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
   public static void deleteCategory(String ID){
        String sql = "delete from Categories where CategoryID ='"+ ID +"'";
        
        java.sql.Statement st;

        try {
            st = interact.DataInteraction.getConnect().createStatement();
            st.executeUpdate(sql);
             JOptionPane.showMessageDialog(null, "Detele Category successfully","Successfully",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
