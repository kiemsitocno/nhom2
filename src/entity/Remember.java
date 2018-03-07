/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;

/**
 * ĐỐI TƯỢNG REMEMBER 
 * @author NHÓM 2
 */
public class Remember implements Serializable {
    String username;
    String password;
    String permit;
    boolean check;

    public Remember() {
    }

    public Remember(String username, String password, String permit,boolean check) {
        this.username = username;
        this.password = password;
        this.permit = permit;
        this.check=check;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermit() {
        return permit;
    }

    public void setPermit(String permit) {
        this.permit = permit;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
    
   
}
