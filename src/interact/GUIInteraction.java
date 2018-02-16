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
 *
 * @author Bach Ngoc Toan
 */
public class GUIInteraction {
//read to table

    public static void readToTable(String sql, JTable tableName) throws SQLException {
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

    //read to combo
    public static void readToCombo(String sql, JComboBox cboType, String fieldName) {
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
    //check id duplicate

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

    public static int indentityID(String sql,String field){
        int count = 0;
        Vector vt = new Vector();
        try {
            ResultSet rs = DataInteraction.getConnect().createStatement().executeQuery(sql);
            while (rs.next()) {
                vt.add(rs.getString(field));
            }
            for (int i = 0; i < vt.size(); i++) {
                String str = (String) vt.get(i);
                count=Integer.parseInt(str.substring(2));
            }
            return count;
        } catch (SQLException ex) {
            Logger.getLogger(GUIInteraction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    
    public static int countRecord(String sql) throws SQLException {
        ResultSet rs = DataInteraction.queryResultSet(sql);
        int count = 0;
        while (rs.next()) {
            count++;
        }
        return count;
    }

    public static int countQuantity(String sql) {
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
