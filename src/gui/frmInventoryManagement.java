/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import interact.GUIInteraction;
import interact.CheckForm;
import entity.Product;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * GIAO DIỆN TÌNH TRẠNG KHO
 * @author NHÓM 2
 */
public class frmInventoryManagement extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmInventoryManagement
     */
    public frmInventoryManagement() {
        initComponents();
        getStatus();
        valid();
        warning();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTotalCate = new javax.swing.JTextField();
        txtTotalProduct = new javax.swing.JTextField();
        txtProductAvailable = new javax.swing.JTextField();
        txtSoldQuantity = new javax.swing.JTextField();
        btnSoldQuantity = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtExpireDate = new javax.swing.JTextField();
        btnExpireDate = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtProductTranstract = new javax.swing.JTextField();
        labelValid = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableInventory = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtQuantityUpdate = new javax.swing.JTextField();
        btnQuantityUpdate = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtProductNAvailable = new javax.swing.JTextField();
        btnProductNAvailable = new javax.swing.JButton();

        jPanel6.setBackground(new java.awt.Color(0, 255, 255));

        jLabel8.setBackground(new java.awt.Color(0, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Inventory Management");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inventory Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Total categories :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Total products :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Products avaliale :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Quantity of Sold Products previous day :");

        txtTotalCate.setEditable(false);
        txtTotalCate.setBackground(new java.awt.Color(204, 204, 204));

        txtTotalProduct.setEditable(false);
        txtTotalProduct.setBackground(new java.awt.Color(204, 204, 204));

        txtProductAvailable.setEditable(false);
        txtProductAvailable.setBackground(new java.awt.Color(204, 204, 204));

        txtSoldQuantity.setEditable(false);
        txtSoldQuantity.setBackground(new java.awt.Color(204, 204, 204));

        btnSoldQuantity.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSoldQuantity.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconView.png"))); // NOI18N
        btnSoldQuantity.setText("View");
        btnSoldQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoldQuantityActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Expiry date of the product :");

        txtExpireDate.setEditable(false);
        txtExpireDate.setBackground(new java.awt.Color(204, 204, 204));

        btnExpireDate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnExpireDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconView.png"))); // NOI18N
        btnExpireDate.setText("View");
        btnExpireDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpireDateActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Product transtract previous day :");

        txtProductTranstract.setEditable(false);
        txtProductTranstract.setBackground(new java.awt.Color(204, 204, 204));

        labelValid.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelValid.setForeground(new java.awt.Color(255, 0, 0));
        labelValid.setText("Valid :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotalProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotalCate, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtProductAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(79, 79, 79)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtExpireDate, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExpireDate))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txtProductTranstract, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtSoldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSoldQuantity)
                            .addComponent(labelValid))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtProductTranstract, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(labelValid))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtTotalCate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTotalProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtSoldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSoldQuantity))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtExpireDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExpireDate))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtProductAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Name Table : ");

        tableInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableInventory);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input Items", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Quantity update :");

        txtQuantityUpdate.setEnabled(false);

        btnQuantityUpdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnQuantityUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconUpdate.png"))); // NOI18N
        btnQuantityUpdate.setText("Update");
        btnQuantityUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuantityUpdateActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Products not avaliable :");

        txtProductNAvailable.setEditable(false);
        txtProductNAvailable.setBackground(new java.awt.Color(204, 204, 204));

        btnProductNAvailable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnProductNAvailable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconView.png"))); // NOI18N
        btnProductNAvailable.setText("View");
        btnProductNAvailable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductNAvailableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtProductNAvailable, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(txtQuantityUpdate))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnQuantityUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProductNAvailable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuantityUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(btnQuantityUpdate))
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtProductNAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProductNAvailable))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel7)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSoldQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoldQuantityActionPerformed
        // ĐẾM SỐ LƯỢNG SẢN PHẨM ĐƯỢC BÁN
        try {
            GUIInteraction.readToTable("select * from View_ProductSold where datediff(dd,Date,getdate())=1", tableInventory);
        } catch (SQLException ex) {
            Logger.getLogger(frmInventoryManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSoldQuantityActionPerformed

    private void btnExpireDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpireDateActionPerformed
        // ĐẾM SỐ LƯỢNG SẢN PHẨM HẾT HẠN
        try {
            GUIInteraction.readToTable("select * from Products where datediff(dd,ExpireDate,getdate())<7", tableInventory);
        } catch (SQLException ex) {
            Logger.getLogger(frmInventoryManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExpireDateActionPerformed

    private void btnProductNAvailableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductNAvailableActionPerformed
        // ĐẾM SỐ LƯỢNG SẢN PHẨM HẾT HÀNG
        try {
            GUIInteraction.readToTable("select * from Products where QuantityAvailable=0", tableInventory);
        } catch (SQLException ex) {
            Logger.getLogger(frmInventoryManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnProductNAvailableActionPerformed

    private void btnQuantityUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuantityUpdateActionPerformed
        // UPDATE SỐ LƯỢNG CHO SẢN PHẨM
        txtQuantityUpdate.setEnabled(true);
        if(txtProductNAvailable.getText().trim().length()==0){
            JOptionPane.showMessageDialog(this, "Please chose one row from table");
            return;
        }
        if (btnQuantityUpdate.getText().equals("Update")) {
            btnQuantityUpdate.setText("Save");
        } else if (btnQuantityUpdate.getText().equals("Save")) {
            if (!validateProduct()) {
                return;
            }
            int i = tableInventory.getSelectedRow();
            Product product = new Product(
                String.valueOf(tableInventory.getValueAt(i, 0)),
                String.valueOf(tableInventory.getValueAt(i, 1)),
                Integer.parseInt(txtQuantityUpdate.getText()),
                Integer.valueOf((String) tableInventory.getValueAt(i, 3)),
                String.valueOf(tableInventory.getValueAt(i, 4)),
                String.valueOf(tableInventory.getValueAt(i, 5)),
                String.valueOf(tableInventory.getValueAt(i, 6)),
                String.valueOf(tableInventory.getValueAt(i, 7)),
                Integer.valueOf((String) tableInventory.getValueAt(i, 8)));
            interact.Product.editProducts(product);
            getStatus();
            btnQuantityUpdate.setText("Update");
            txtQuantityUpdate.setEnabled(false);
        }
    }//GEN-LAST:event_btnQuantityUpdateActionPerformed
    
    private void getStatus(){
        // BỘ ĐẾM
        int totalCate=GUIInteraction.countQuantity("select count(*) as c from Categories");
        txtTotalCate.setText(String.valueOf(totalCate));
        int totalProduct=GUIInteraction.countQuantity("select count(*) as c from Products");
        txtTotalProduct.setText(String.valueOf(totalProduct));
        int productAvaliable=GUIInteraction.countQuantity("select sum(QuantityAvailable) as Total from Products");
        txtProductAvailable.setText(String.valueOf(productAvaliable));
        int productNotAvaliable=GUIInteraction.countQuantity("select count(*) as Total from Products where QuantityAvailable=0");
        txtProductNAvailable.setText(String.valueOf(productNotAvaliable));
        int productTranstract=GUIInteraction.countQuantity("select sum(Quantity) as Total from View_Trantract where datediff(dd,Date,getdate())=1");
        txtProductTranstract.setText(String.valueOf(productTranstract));
        int productSold=GUIInteraction.countQuantity("select sum(Sold) as Total from View_ProductSold where datediff(dd,Date,getdate())=1");
        txtSoldQuantity.setText(String.valueOf(productSold));
        int productExpire=GUIInteraction.countQuantity("select count(*) from Products where datediff(dd,ExpireDate,getdate())<7");
        txtExpireDate.setText(String.valueOf(productExpire));
    }
    
    private boolean validateProduct(){
        // CHECK THÔNG TIN NHẬP VÀO CÓ PHẢI LÀ SỐ LƯỢNG HAY KHÔNG
        boolean flag = true;
        if (!CheckForm.isNumberic(txtQuantityUpdate.getText())) {
            JOptionPane.showMessageDialog(this, "Quantity is not numberic", "Error", JOptionPane.ERROR_MESSAGE);
            txtQuantityUpdate.requestFocus();
            txtQuantityUpdate.setBackground(Color.red);
            flag = false;
        }else{
            flag = true;
        }
        return true;
    }
    
    private void valid(){
        // SO SÁNH SỐ LƯỢNG BÁN RA VÀ SỐ LƯỢNG BỊ GIẢM TRONG KHO
        if(txtSoldQuantity.getText().equals(txtProductTranstract.getText())){
            labelValid.setText("Data valid");
        }else{
            labelValid.setText("Data invalid");
        }
    }
    
    private void warning(){
        // SHOW CẢNH BÁO NẾU CÓ SẢN PHẨM HẾT HÀNG HOẶC HẾT HẠN
        int productNotAvaliable=GUIInteraction.countQuantity("select count(*) as Total from Products where QuantityAvailable=0");
        if(productNotAvaliable!=0){
            JOptionPane.showMessageDialog(null, "CẢNH BÁO! CÓ " + productNotAvaliable + " SẢN PHẨM HẾT HÀNG, HÃY NHẬP VỀ NGAY");
        }
        int productExpire=GUIInteraction.countQuantity("select count(*) from Products where datediff(dd,ExpireDate,getdate())<7");
        if(productExpire!=0){
            JOptionPane.showMessageDialog(null, "CẢNH BÁO! CÓ " + productExpire + " SẢN PHẨM SẮP HẾT HẠN SỬ DỤNG");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExpireDate;
    private javax.swing.JButton btnProductNAvailable;
    private javax.swing.JButton btnQuantityUpdate;
    private javax.swing.JButton btnSoldQuantity;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelValid;
    private javax.swing.JTable tableInventory;
    private javax.swing.JTextField txtExpireDate;
    private javax.swing.JTextField txtProductAvailable;
    private javax.swing.JTextField txtProductNAvailable;
    private javax.swing.JTextField txtProductTranstract;
    private javax.swing.JTextField txtQuantityUpdate;
    private javax.swing.JTextField txtSoldQuantity;
    private javax.swing.JTextField txtTotalCate;
    private javax.swing.JTextField txtTotalProduct;
    // End of variables declaration//GEN-END:variables
}
