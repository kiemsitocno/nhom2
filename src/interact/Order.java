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
 * CÁC PHƯƠNG THÚC CỦA ĐỐI TƯỢNG ORDER
 * @author NHÓM 2
 */
public class Order {
    
    public static boolean insertOrder(entity.Bill bill,entity.Order order){
        String sql="insert into OrderDetails values(?,?,?,?,?)";
        try {
            PreparedStatement pst = DataInteraction.getConnect().prepareStatement(sql);
            pst.setString(1, order.getOrderID());
            pst.setString(2,bill.getBillID());
            pst.setString(3,order.getProductID());
            pst.setInt(4,order.getQuantity());
            pst.setFloat(5,order.getPrice());
            if(pst.executeUpdate()==0)
            {
                return false;
            }
            DataInteraction.exec("update Products set QuantityAvailable=QuantityAvailable-"+order.getQuantity()+" where ProductID='"+order.getProductID()+"'");
        
        } catch (SQLException ex) {
         System.out.println(ex.getMessage());
        }
        return true;
    }
    
    public static void deleteOrder(String ID) {
        // PHƯƠNG THỨC DELETE CỦA ĐỐI TƯỢNG ORDER
        String sql = "delete from OrderDetails where OrderID='" + ID + "'";
        java.sql.Statement st;
        try {
            st = interact.DataInteraction.getConnect().createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<entity.Order> getAllByID(String order) {
        ArrayList<entity.Order> details = new ArrayList<entity.Order>();
        Connection con = DataInteraction.getConnect();
        try {
            PreparedStatement pst = con.prepareStatement("select * from OrderDetails where BillID=?");
            pst.setString(1, order);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                entity.Order orde = new entity.Order();
                orde.setOrderID(rs.getString("OrderID"));
                orde.setBillID(rs.getString("BillID"));
                orde.setProductID(rs.getString("ProductID"));
                orde.setQuantity(rs.getInt("Quantity"));
                orde.setPrice(rs.getInt("Price"));
                details.add(orde);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
        return details;
    }
}
