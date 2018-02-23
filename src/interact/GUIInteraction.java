/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interact;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * CÁC PHƯƠNG THƯỚC CHUNG SQL
 * @author NHÓM 2
 */
public class GUIInteraction {

    public static void readToTable(String sql, JTable tableName) throws SQLException {
        // LOAD DỮ LIỆU VÀO BẢNG
        DefaultTableModel dm = (DefaultTableModel) tableName.getModel();
        for (int i = dm.getRowCount() - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
        Vector cols = new Vector();
        try {
            ResultSet rs = DataInteraction.queryResultSet(sql);
            ResultSetMetaData rm = rs.getMetaData();
            for (int i = 1; i <= rm.getColumnCount(); i++) {
                cols.add(rm.getColumnName(i));
            }
            dm.setColumnIdentifiers(cols);
            while (rs.next()) {
                Vector row = new Vector();
                for (int i = 1; i <= rm.getColumnCount(); i++) {
                    row.add(rs.getString(i));
                }
                dm.addRow(row);
            }
            tableName.setModel(dm);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void readToCombo(String sql, JComboBox cboType, String fieldName) {
        // LOAD DỮ LIỆU VÀO COMBOBOX
        try {
            ResultSet rs = DataInteraction.queryResultSet(sql);
            while (rs.next()) {
                String str = rs.getString(fieldName);
                cboType.addItem(str);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static boolean checkDuplicateName(String name, String sql, String field) {
        // CHECK TÊN NHẬP VÀO ĐÃ CÓ TRONG SQL HAY CHƯA 
        boolean flag = true;
        Vector vt = new Vector();
        try {
            ResultSet rs = DataInteraction.getConnect().createStatement().executeQuery(sql);
            while (rs.next()) {
                vt.add(rs.getString(field));
            }
            for (int i = 0; i < vt.size(); i++) {
                String str = (String) vt.get(i);
                if (str.equalsIgnoreCase(name)) {
                    flag = false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUIInteraction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static boolean checkDuplicateID(String _id, String sql, String field) {
        boolean flag = true;
        Vector vt = new Vector();
        try {
            ResultSet rs = DataInteraction.getConnect().createStatement().executeQuery(sql);
            while (rs.next()) {
                vt.add(rs.getString(field));
            }
            for (int i = 0; i < vt.size(); i++) {
                String str = (String) vt.get(i);
                if (str.equalsIgnoreCase(_id)) {
                    flag = false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUIInteraction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public static int indentityID(String sql, String field) {
        // PHƯƠNG THỨC TỰ ĐỘNG TĂNG ID
        int count = 0;
        Vector vt = new Vector();
        try {
            ResultSet rs = DataInteraction.getConnect().createStatement().executeQuery(sql);
            while (rs.next()) {
                vt.add(rs.getString(field));
            }
            for (int i = 0; i < vt.size(); i++) {
                String str = (String) vt.get(i);
                count = Integer.parseInt(str.substring(str.length() - 1));
            }
            return count;
        } catch (SQLException ex) {
            Logger.getLogger(GUIInteraction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public static int countRecord(String sql) throws SQLException {
        // ĐẾM SỐ LƯỢNG RECORD CỦA 1 BẢNG
        ResultSet rs = DataInteraction.queryResultSet(sql);
        int count = 0;
        while (rs.next()) {
            count++;
        }
        return count;
    }

    public static int countQuantity(String sql) {
        // ĐẾM SỐ LƯỢNG QUANTITY CỦA 1 THUỘC TÍNH
        int count = 0;
        try {
            ResultSet rs = DataInteraction.getConnect().createStatement().executeQuery(sql);
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUIInteraction.class.getName()).log(Level.SEVERE, null, ex);

        }
        return count;
    }

    public static double[] getArray() {
        int sold = 0;
        double[] arr = null;
        try {
            for (int i = 1; i <= 30; i++) {

                String sql = "select * from V_Gen where datediff(dd,DateImport,getdate())=" + i;
                ResultSet rs = DataInteraction.queryResultSet(sql);
                while (rs.next()) {
                    sold = rs.getInt("Sold");
                }
                arr[i] = sold;
            }
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
        return arr;

    }
}
