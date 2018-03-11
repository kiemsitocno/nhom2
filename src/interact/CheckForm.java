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
 * CÁC PHƯƠNG THỨC CHECKFORM : VALIDATE THÔNG TIN NHẬP VÀO CÁC Ô TEXTFIELD
 *
 * @author NHÓM 2
 */
public class CheckForm {
    
    public static boolean isEmpty(String value) {
        //KIỂM TRA MỘT Ô TEXTFIELD CÓ ĐỂ TRỐNG HAY KHÔNG
        if (value.trim().length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isPwdUsername(String Value) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(Value);
        if (!matcher.find()) {
            return false;
        } else {
            return true;
        }
    }
    
    public static boolean isWhiteSpace(String Value) {
        // KIỂM TRA THÔNG TIN NHẬP VÀO CÓ KHOẢNG TRẮNG HAY KHÔNG
        Pattern pattern = Pattern.compile("[\\w\\s]+");
        Matcher matcher = pattern.matcher(Value);
        if (!matcher.find() || Value.indexOf(" ") != -1) {
            return false;
        } else {
            return true;
        }
    }
    
    public static boolean isFindSpace(String Value) {
        // KIỂM TRA THÔNG TIN NHẬP VÀO CÓ KHOẢNG TRẮNG HAY KHÔNG
        Pattern pattern = Pattern.compile("[\\w\\s]+");
        Matcher matcher = pattern.matcher(Value);
        if (!matcher.find() || Value.indexOf(" ") != -1) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isNumberic(String value) {
        // KIỂM TRA THÔNG TIN NHẬP VÀO CÓ PHẢI LÀ SỐ HAY KHÔNG 
        Pattern pattern = Pattern.compile("\\d+$");
        Matcher matcher = pattern.matcher(value);
        if (!matcher.find()||Integer.valueOf(value)<=0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean overLength(String value) {
        // KIỂM TRA ĐỘ DÀI CỦA THÔNG TIN NHẬP VÀO CÓ VƯỢT QUÁ QUY ĐINH HAY KHÔNG
        if (value.trim().length() >= 50) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean overLengthID(String value) {
        // KIỂM TRA ĐỘ DÀI CỦA THÔNG TIN NHẬP VÀO CÓ VƯỢT QUÁ QUY ĐINH HAY KHÔNG
        if (value.trim().length() >= 5) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkEmail(String value) {
        // KIỂM TRA THÔNG TIN NHẬP VÀO CÓ PHẢI LÀ EMAIL HAY KHÔNG
        Pattern pattern = Pattern.compile("[a-zA-Z][_]*\\d*@[a-z]{2,5}[.][a-z]{2,3}");
        Matcher matcher = pattern.matcher(value);
        if (!matcher.find()) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkPhoneNumber(String value) {
        // KIỂM TRA THÔNG TIN NHẬP VÀO CÓ PHẢI LÀ SỐ ĐIỆN THOẠI HAY KHÔNG
        Pattern pattern = Pattern.compile("[0]{1}[1,9]{1}[0-9]{8,9}$");
        Matcher matcher = pattern.matcher(value);
        if (!matcher.find()) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean validateDate(String date) {
        // KIỂM TRA THÔNG TIN NHẬP VÀO CÓ PHẢI LÀ NGÀY THÁNG HAY KHÔNG
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-DD");
        sdf.setLenient(false);
        java.sql.Date sqlDate;
        try {
            sqlDate = new java.sql.Date(sdf.parse(date).getTime());
        } catch (ParseException p) {
            return false;
        }
        return true;
    }
    
    public static String strFormat(String value){
        String name = value.replaceAll("\\s+"," ");
        if(name.indexOf(" ")==0){
            name = name.substring(1);
            System.out.println(name);
            return name;
        }else{
            return name;
        }
         
    }
}
