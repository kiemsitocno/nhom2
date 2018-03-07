/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * GET DATE TIME HIỆN TẠI 
 * @author NHÓM 2
 */
public class DateUtils {
    public static String now(String dateFormat) {
        Calendar cal = Calendar.getInstance();
         SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
           return sdf.format(cal.getTime());
    }
}
