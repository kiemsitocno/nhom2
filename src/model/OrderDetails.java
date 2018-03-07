/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import entity.Order;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
<<<<<<< HEAD

/**
 * MODEL TABLE ORDERDETAILS
 * @author NHÓM 2
 */
public class OrderDetails extends AbstractTableModel {
    private ArrayList<entity.Order> details;
=======
/**
 *
 * @author Bach Ngoc  Toan
 */
public class OrderDetails extends AbstractTableModel {
private ArrayList<entity.Order> details;
>>>>>>> origin/Sales
    private final String columnsName[] = {"ItemID", "Price", "Quantity","Total"};
    private final Class columnsClass[] = {String.class, Integer.class, Integer.class, Integer.class};

    public OrderDetails(ArrayList<Order> details) {
        this.details = details;
    }

    public int getRowCount() {
        return details.toArray().length;
    }

    public int getColumnCount() {
        return columnsName.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
         switch (columnIndex) {
            case 0:
                return details.get(rowIndex).getProductID();

            case 1:
               return details.get(rowIndex).getPrice();

            case 2:
                return details.get(rowIndex).getQuantity();
             case 3:
                 return details.get(rowIndex).getPrice()*details.get(rowIndex).getQuantity();
            default:
                return null;

        }
    }
    @Override
    public String getColumnName(int iCol) {
        return columnsName[iCol];
    }

    @Override
    public Class getColumnClass(int iCol) {
        return columnsClass[iCol];
    }

}
