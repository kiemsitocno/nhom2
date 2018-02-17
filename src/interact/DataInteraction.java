/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interact;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bach Ngoc Toan
 */
public class DataInteraction {

    public static String url;
    private static String servername;
    public static String port;
    private static String driverName;
    private static String username;
    private static String password;
    private static String databaseName;
    private static Connection conn;

    public static boolean connect(String _serverName, String _port, String _username, String _password, String _database) {
        servername = _serverName;
        port = _port;
        username = _username;
        password = _password;
        databaseName = _database;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(getConnectionString());
        } catch (Exception ex) {
            return false;
        }

        return true;
    }

    public static String getConnectionString() throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("jdbc:sqlserver://");
        sb.append(servername);
        sb.append(":");
        sb.append(port);

        sb.append(";databaseName=");
        sb.append(databaseName);

        sb.append(";user=");
        sb.append(username);

        sb.append(";password=");
        sb.append(password);

        return sb.toString();
    }

    public static String getDatabaseName() {
        return databaseName;
    }

    public static String getDriverName() {
        return driverName;
    }

    public static String getPassword() {
        return password;
    }

    public static String getPort() {
        return port;
    }

    public static String getServername() {
        return servername;
    }

    public static String getUrl() {
        return url;
    }

    public static String getUsername() {
        return username;
    }

    public static Connection getCon() {
        return conn;
    }

    //set get
    public String getConnectionUrl() {
        return getUrl() + getServername() + ":" + getPort() + ";databaseName=" + getDatabaseName();
    }

    //method get connection
    public static Connection getConnect() {
        /*Connection con = null;
        try {

        Class.forName(driverName);
        con = DriverManager.getConnection(url +servername+":"+port+ ";databaseName=" + databaseName, username, password);
        } catch (ClassNotFoundException ex) {
        Logger.getLogger(DataInteraction.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
        Logger.getLogger(DataInteraction.class.getName()).log(Level.SEVERE, null, ex);
        }finally
        {
        return con;
        }*/
        return conn;
    }

    //method
    public static CachedRowSetImpl queryCachedRowSet(String sql) {
        CachedRowSetImpl crs = null;
        try {
            crs = new CachedRowSetImpl();
            crs.setUsername(getUsername());
            crs.setPassword(getPassword());
            crs.setUrl(getUrl());
            crs.setCommand(sql);
            int[] keys = {1};
            crs.setKeyColumns(keys);
            crs.execute(getCon());
            return crs;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        }
    }

    public static ResultSet queryResultSet(String sql) {
        ResultSet rs = null;
        try {
            Statement st = getConnect().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DataInteraction.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return rs;
        }
    }

    //method security
    public static void exec(String sql) {
        try {
            Statement query = getConnect().createStatement();
            query.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static int topid() {
        int id = 1;
        try {
            Connection cn = getConnect();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select top(1) BillID from Bills order by BillID Desc");
            while (rs.next()) {
                id = Integer.valueOf(rs.getString("BillID"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataInteraction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;

    }

    public static String getCode(String Table, String Column, String Condition, String code) {
        String id = null;
        try {

            Connection cn = getConnect();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from  " + Table + " where " + Column + "=" + "N'" + Condition + "'" + "");
            while (rs.next()) {
                id = rs.getString(code);

            }

            //System.out.println(rs.getString("TenTPho"));
            // JOptionPane.showMessageDialog(null,"B?n H�y Nh?p T�n Ph�ng: "+id);
        } catch (SQLException ex) {
            Logger.getLogger(DataInteraction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public String getLines(String Table, String Coulnm, String dk, String line) {
        String column = null;
        try {
            Connection cn = getConnect();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from  " + Table + " where " + Coulnm + " ='" + dk + "'");
            while (rs.next()) {
                column = rs.getString(line);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return column;
    }

}
