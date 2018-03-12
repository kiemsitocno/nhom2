/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author KhanhLong
 */
public class ForgotPassword {

    public int reset(String password, String Email) {
        try {
            Connection cn = DataInteraction.getConnect();
            String sql = "Update Users set Password = ? where Email = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, password);
            pst.setString(2, Email);
            return pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Changed", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

}
