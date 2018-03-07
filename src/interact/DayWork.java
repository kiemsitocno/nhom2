/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interact;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
<<<<<<< HEAD
 * CÁC PHƯƠNG THỨC CỦA ĐỐI TƯỢNG DAYWORK
 * @author NHÓM 2
=======
 *
 * @author kiems
>>>>>>> origin/Sales
 */
public class DayWork {
    public static boolean insertDayWork(entity.DayWork dayWork) {
        String sql = "insert into DayWork values(?,?,?)";
        try {
            PreparedStatement pst = DataInteraction.getConnect().prepareStatement(sql);
            pst.setString(1, dayWork.getWorkID());
            pst.setString(2, dayWork.getUserID());
            pst.setBoolean(3, dayWork.getDayWork());
            return (pst.executeUpdate() == 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }
}
