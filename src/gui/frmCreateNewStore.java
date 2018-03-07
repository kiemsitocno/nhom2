/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.Store;
import interact.GUIInteraction;
import interact.CheckForm;
import interact.DataInteraction;
import java.awt.Color;
import javax.swing.*;

/**
 * GIAO DIỆN QUẢN LÝ STORE
 * @author NHÓM 2
 */
public class frmCreateNewStore extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmCreateNewStore
     */
    public frmCreateNewStore() {
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

        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        btnCreate = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtRent = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStores = new javax.swing.JTable();

        jPanel9.setBackground(new java.awt.Color(0, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(765, 66));

        jLabel11.setBackground(new java.awt.Color(0, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Management Store");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Management", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Store ID :");

        txtID.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Store Name :");

        txtName.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Store Phone :");

        txtPhone.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Store Address :");

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        txtAddress.setEnabled(false);
        jScrollPane2.setViewportView(txtAddress);

        btnCreate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconAdd.png"))); // NOI18N
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconEdit.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconCancel.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconDelete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconBrower.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Search Name Store :");

        txtRent.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Store Rent:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtRent)
                    .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel4)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancel)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancel)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))))
        );

        tablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Table Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        tablePanel.setPreferredSize(new java.awt.Dimension(765, 259));

        tableStores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableStores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableStoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableStores);

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tablePanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tablePanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
                    .addComponent(tablePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel9, 51, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TẠO MỚI 1 CỬA HÀNG
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
        enableTXT();
        if (btnCreate.getText().equals("Create")) {
            resetTXT();
            btnCreate.setText("Save");
        } else if (btnCreate.getText().equals("Save")) {
            if (!validateStore()) {
                return;
            }
            int countStore = GUIInteraction.indentityID("select top 1 * from Stores order by StoreID Desc", "StoreID") + 1;
            String storeID = "ST" + countStore;
            
            String storeName = CheckForm.strFormat(txtName.getText());
            Store store = new Store(
                    storeID,
                    storeName,
                    txtPhone.getText(),
                    txtAddress.getText(),
                    Integer.parseInt(txtRent.getText()));
            interact.Store.insertStore(store);
            refresh();
            btnCreate.setText("Create");
            resetTXT();
            disableTXT();
            btnEdit.setEnabled(true);
            btnDelete.setEnabled(true);
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // CHỈNH SỬA THÔNG TIN 1 CỬA HÀNG
        btnCreate.setEnabled(false);
        btnDelete.setEnabled(false);
        if(txtName.getText().trim().length()==0){
            JOptionPane.showMessageDialog(this, "Please chose one row from table");
            return;
        }
        enableTXT();
        if (btnEdit.getText().equals("Edit")) {
            btnEdit.setText("Save");
        } else if (btnEdit.getText().equals("Save")) {
            if (!validateStore()) {
                return;
            }
            
            String storeName = CheckForm.strFormat(txtName.getText());
            Store store = new Store(txtID.getText(), storeName, txtPhone.getText(), txtAddress.getText(), Integer.parseInt(txtRent.getText()));
            interact.Store.editStore(store);
            refresh();
            btnEdit.setText("Edit");
            disableTXT();
            btnCreate.setEnabled(true);
            btnDelete.setEnabled(true);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // DELETE 1 CỬA HÀNG NẾU CỬA HÀNG ĐÓ KHÔNG CHỨA BẤT KỲ MANAGER NÀO
        if(txtName.getText().trim().length()==0){
            JOptionPane.showMessageDialog(this, "Please chose one row from table");
            return;
        }
        int i = JOptionPane.showConfirmDialog(this, "Do you want to delete this Store.?");
        if (i == JOptionPane.YES_OPTION) {
            try {
                // TODO add your handling code here:
                int countUser = GUIInteraction.countRecord("select * from Users where StoreID='" + txtID.getText() + "'");
                if (countUser > 0) {
                    JOptionPane.showMessageDialog(this, "This store have users, can't delete it");
                } else if(txtID.getText().equals("ST1")){
                    JOptionPane.showMessageDialog(this, "This is head office, can't delete it");
                } else {
                    interact.Store.deleteStore(txtID.getText());
                    refresh();
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmCreateNewStore.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tableStoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableStoresMouseClicked
        // LOAD DỮ LIỆU TỪ BẢNG STORE VÀO CÁC Ô TEXTFIELD
        int i = tableStores.getSelectedRow();
        txtID.setText(String.valueOf(tableStores.getValueAt(i, 0)));
        txtName.setText(String.valueOf(tableStores.getValueAt(i, 1)));
        txtPhone.setText(String.valueOf(tableStores.getValueAt(i, 2)));
        txtAddress.setText(String.valueOf(tableStores.getValueAt(i, 3)));
        txtRent.setText(String.valueOf(tableStores.getValueAt(i, 4)));
    }//GEN-LAST:event_tableStoresMouseClicked

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // RESET TẤT CẢ BUTTON VÀ TEXTFIELD VỀ TRẠNG THÁI MẶC ĐỊNH
        disableTXT();
        resetTXT();
        btnCreate.setText("Create");
        btnCreate.setEnabled(true);
        btnEdit.setText("Edit");
        btnEdit.setEnabled(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TÌM KIẾM 1 CỬA HÀNG
        String searchName = txtSearch.getText().trim();
        try {
            GUIInteraction.readToTable("select * from Stores where StoreName like N'%" + searchName + "%'", tableStores);
        } catch (SQLException ex) {
            Logger.getLogger(frmCreateNewStore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void refresh() {
        // LOAD DỮ LIỆU STORE VÀO BẢNG
        try {
            interact.GUIInteraction.readToTable("select * from Stores", tableStores);
        } catch (SQLException ex) {
            Logger.getLogger(frmCreateNewStore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean validateStore() {
        // VALIDATE THÔNG TIN NHẬP VÀO KHI INSERT VÀ UPDATE STORE
        boolean flag = true;
        String name = DataInteraction.getCode("Stores", "StoreID", txtID.getText(), "StoreName");
        String phone = DataInteraction.getCode("Stores", "StoreID", txtID.getText(), "StorePhone");
        String address = DataInteraction.getCode("Stores", "StoreID", txtID.getText(), "StoreAddress");
        if (!CheckForm.isEmpty(txtName.getText())) {
            JOptionPane.showMessageDialog(this, "Name is not blank", "Error", JOptionPane.ERROR_MESSAGE);
            txtName.requestFocus();
            txtName.setBackground(Color.red);
            flag = false;
        } else if (!GUIInteraction.checkDuplicateName(txtName.getText().trim(), "select * from Stores", "StoreName")&&!txtName.getText().trim().equals(name)) {
            JOptionPane.showMessageDialog(this, "Name is not duplicatated", "Error", JOptionPane.ERROR_MESSAGE);
            txtName.requestFocus();
            txtName.setBackground(Color.red);
            flag = false;
        } else if (!CheckForm.overLength(txtName.getText())) {
            JOptionPane.showMessageDialog(this, "Name is not than 50", "Error", JOptionPane.ERROR_MESSAGE);
            txtName.requestFocus();
            txtName.setBackground(Color.red);
            flag = false;
        } else if (!CheckForm.checkPhoneNumber(txtPhone.getText())||!GUIInteraction.checkDuplicateName(txtPhone.getText().trim(), "select * from Stores", "StorePhone")&&!txtPhone.getText().trim().equals(phone)) {
            JOptionPane.showMessageDialog(this, "Phone is not phone format and not duplicate", "Error", JOptionPane.ERROR_MESSAGE);
            txtPhone.requestFocus();
            txtPhone.setBackground(Color.red);
            txtName.setBackground(Color.white);
            flag = false;
        } else if (!CheckForm.overLength(txtAddress.getText())) {
            JOptionPane.showMessageDialog(this, "Address not than 50 ", "Error", JOptionPane.ERROR_MESSAGE);
            txtAddress.requestFocus();
            txtAddress.setBackground(Color.red);
            txtPhone.setBackground(Color.white);
            txtName.setBackground(Color.white);
            flag = false;
        } else if (!CheckForm.isNumberic(txtRent.getText())) {
            JOptionPane.showMessageDialog(this, "Rent is not numberic", "Error", JOptionPane.ERROR_MESSAGE);
            txtRent.requestFocus();
            txtRent.setBackground(Color.red);
            txtAddress.setBackground(Color.white);
            txtPhone.setBackground(Color.white);
            txtName.setBackground(Color.white);
            flag = false;
        } else {
            txtName.setBackground(Color.white);
            txtPhone.setBackground(Color.white);
            txtAddress.setBackground(Color.white);
            txtRent.setBackground(Color.white);
            flag = true;
        }
        return flag;
    }

    private void enableTXT() {
        // ENABLE TẤT CẢ TEXTFIELD
        try {
            String storeID = txtID.getText();
            int countUser = GUIInteraction.countRecord("select * from Users where StoreID='"+storeID+"'");
            System.out.println(countUser);
            if(countUser>0){
                txtName.setEnabled(false);
            }else{
                txtName.setEnabled(true);
            }
        } catch (SQLException ex) {

        }
        
        txtPhone.setEnabled(true);
        txtAddress.setEnabled(true);
        txtRent.setEnabled(true);
    }

    private void disableTXT() {
        // DISABLE TẤT CẢ TEXTFIELD
        txtName.setEnabled(false);
        txtPhone.setEnabled(false);
        txtAddress.setEnabled(false);
        txtRent.setEnabled(false);
    }

    private void resetTXT() {
        // RESET TẤT CẢ TEXTFIELD VỀ MẶC ĐỊNH.
        txtName.setText(null);
        txtPhone.setText(null);
        txtAddress.setText(null);
        txtRent.setText(null);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JTable tableStores;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtRent;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
