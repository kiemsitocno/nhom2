/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package interact;

/**
 * LOGIN
 * @author NHÓM 2
 */
public class Login {
    private static String Username=null;
    private static String Password=null;
    private static String AdminID=null;
    private static String permit=null;

    public static String getAdminID() {
        return AdminID;
    }

    public static void setAdminID(String AdminID) {
        Login.AdminID = AdminID;
    }

    public static String getPassword() {
        return Password;
    }

    public static void setPassword(String Password) {
        Login.Password = Password;
    }

    public static String getUsername() {
        return Username;
    }

    public static void setUsername(String Username) {
        Login.Username = Username;
    }

    public static String getPermit() {
        return permit;
    }

    public static void setPermit(String permit) {
        Login.permit = permit;
    }

    
    
}
