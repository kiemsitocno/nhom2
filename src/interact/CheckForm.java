/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interact;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Bach Ngoc Toan
 */
public class CheckForm {
    //Method check a field empty.

    public static boolean isEmpty(String value) {
        if (value.trim().length() == 0) {
            return false;
        } else {
            return true;
        }
    }
//Method check a field is username or not

    public static boolean isPwdUsername(String Value) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(Value);
        if (!matcher.find()) {
            return false;
        } else {
            return true;
        }
    }

    //Check a string must have a whitespace
    public static boolean isWhiteSpace(String Value) {
        Pattern pattern = Pattern.compile("[\\w\\s]+");
        Matcher matcher = pattern.matcher(Value);
        if (!matcher.find() || Value.indexOf(" ")!=-1) {
            return false;
        } else {
            return true;
        }
    }

    //Check a string is numberic
    public static boolean isNumberic(String value) {
        Pattern pattern = Pattern.compile("\\d+$");
        Matcher matcher = pattern.matcher(value);
        if (!matcher.find()) {
            return false;
        } else {
            return true;
        }
    }

    //Check lenght of sting
    public static boolean overLength(String value) {
        if (value.trim().length() >= 50) {
            return false;
        } else {
            return true;
        }
    }
    //check leng of primary key

    public static boolean overLengthID(String value) {
        if (value.trim().length() >= 5) {
            return false;
        } else {
            return true;
        }
    }

    //Validate email input
    public static boolean checkEmail(String value) {
        Pattern pattern = Pattern.compile("[a-zA-Z][_]*\\d*@[a-z]{2,5}[.][a-z]{2,3}");
        Matcher matcher = pattern.matcher(value);
        if (!matcher.find()) {
            return false;
        } else {
            return true;
        }
    }

    //Validate phone number
    public static boolean checkPhoneNumber(String value) {
        Pattern pattern = Pattern.compile("[0]{1}[1,9]{1}[0-9]{8,9}$");
        Matcher matcher = pattern.matcher(value);
        if (!matcher.find()) {
            return false;
        } else {
            return true;
        }
    }

    //Check date fomat by MM/dd/yyyy
    public static boolean validateDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(false);
        java.sql.Date sqlDate;
        try {
            sqlDate = new java.sql.Date(sdf.parse(date).getTime());
        } catch (ParseException p) {
            return false;
        }
        return true;
    }
}
