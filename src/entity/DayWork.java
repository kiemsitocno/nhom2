/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author kiems
 */
public class DayWork {
    private String workID;
    private String userID;
    private Boolean dayWork;

    public DayWork() {
    }

    public DayWork(String workID, String userID, Boolean dayWork) {
        this.workID = workID;
        this.userID = userID;
        this.dayWork = dayWork;
    }

    

    public String getWorkID() {
        return workID;
    }

    public void setWorkID(String workID) {
        this.workID = workID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Boolean getDayWork() {
        return dayWork;
    }

    public void setDayWork(Boolean dayWork) {
        this.dayWork = dayWork;
    }

    
    
}
