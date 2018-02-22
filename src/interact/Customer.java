/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interact;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kiems
 */
public class Customer {
    public static ArrayList<entity.Customer> getAll() {
        ArrayList<entity.Customer> list = new ArrayList<entity.Customer>();
        ResultSet rs = DataInteraction.queryResultSet("select * from Customers");
        try {
            while (rs.next()) {
                entity.Customer c = new entity.Customer();
                c.setCustomerID(rs.getString("CustomerID"));
                c.setCustomerName(rs.getString("CustomerName"));
                c.setAddress(rs.getString("Address"));
                c.setPhone(rs.getString("Phone"));
                c.setEmail(rs.getString("Email"));
                c.setGender(rs.getString("Gender"));
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
