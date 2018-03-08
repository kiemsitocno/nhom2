/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interact.GUIInteraction;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * GIAO DIỆN SELECT CUSTOMER
 *
 * @author NHÓM 2
 */
public class frmCustomerBrower_search extends javax.swing.JFrame {

    static frmCreateBill code;

    /**
     * Creates new form frmCustomerBrower
     */
    public frmCustomerBrower_search() {
        initComponents();
        refresh();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblCustomer = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        tblCustomer.getTableHeader().setReorderingAllowed(false);
        jLabel2 = new javax.swing.JLabel();
        txtSearchName = new javax.swing.JTextField();
        btnSearchRefresh = new javax.swing.JButton();
        btnSelect = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblCustomer);

        jLabel2.setText("Customer Name:");

        txtSearchName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchNameKeyReleased(evt);
            }
        });

        btnSearchRefresh.setText("SEARCH");
        btnSearchRefresh.setPreferredSize(new java.awt.Dimension(100, 23));
        btnSearchRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchRefreshActionPerformed(evt);
            }
        });

        btnSelect.setText("Select");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(30, 30, 30)
                        .add(jLabel2)
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtSearchName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 253, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, btnSearchRefresh, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(btnSelect))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel2)
                    .add(txtSearchName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(btnSearchRefresh, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 194, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnSelect))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchNameKeyReleased
        String str = txtSearchName.getText();
        String sql = "";
        if (str.equals("")) {
            sql = "select * from Customers";
        } else {
            sql = ("select * from Customers where CustomerName like '%" + str + "%'");
        }
        try {
            interact.GUIInteraction.readToTable(sql, tblCustomer);
        } catch (SQLException ex) {
            Logger.getLogger(frmCustomerBrower_search.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_txtSearchNameKeyReleased

    private void btnSearchRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchRefreshActionPerformed
        refresh();
}//GEN-LAST:event_btnSearchRefreshActionPerformed

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        int cusID = tblCustomer.getSelectedRow();
        if (cusID == -1) {
            JOptionPane.showMessageDialog(this, "You must choose a item");
            return;
        } else {
            int row = tblCustomer.getSelectedRow();
            code.txtCustomerIDSearch.setText(tblCustomer.getValueAt(row, 0).toString());
            this.dispose();
        }
    }//GEN-LAST:event_btnSelectActionPerformed
    private void refresh() {
        try {
            GUIInteraction.readToTable("select * from Customers order by CustomerName asc", tblCustomer);
        } catch (SQLException ex) {
            Logger.getLogger(frmCustomerBrower_search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearchRefresh;
    private javax.swing.JButton btnSelect;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCustomer;
    private javax.swing.JTextField txtSearchName;
    // End of variables declaration//GEN-END:variables

}
