/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package interact;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

/**
 * CONFIG KẾT NỐI VỚI SQL
 * @author NHÓM 2
 */
public class Configs {
    
    public static final String CONFIG_FILENAME = "configs.properties";
    public static final String CONFIG_SERVERNAME = "serverName";
    public static final String CONFIG_PORTNUMBER = "port";
    public static final String CONFIG_DATABASENAME = "databaseName";
    public static final String CONFIG_SERVERUSERNAME = "userName";
    public static final String CONFIG_SERVERPASSWORD = "password";

    private static final String PASSKEY = "2601176";
    private static final int count = 20;
    private static final byte[] salt = {
            (byte)0xc7, (byte)0x73, (byte)0x21, (byte)0x8c,
            (byte)0x7e, (byte)0xc8, (byte)0xee, (byte)0x99};

    private static boolean logged = false;
    private static Properties p;
    
    public static boolean isLogged() {
        return logged;
    }

    public static void setLogged(boolean b) {
        logged = b;
    }

    public static String encrypt(String input) throws Exception {
        String output;
        byte[] plain = input.getBytes();
        PBEParameterSpec pbeParamSpec = new PBEParameterSpec(salt, count);
        PBEKeySpec pbeKeySpec = new PBEKeySpec(PASSKEY.toCharArray());
        SecretKeyFactory skFact = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey key = skFact.generateSecret(pbeKeySpec);
        Cipher c = Cipher.getInstance("PBEWithMD5AndDES");
        c.init(Cipher.ENCRYPT_MODE, key, pbeParamSpec);
        byte[] encryted =  c.doFinal(plain);
        output = new String(encryted);
        return output;
    }

    public static String decrypt(String input) throws Exception {
        String output;
        byte[] plain = input.getBytes();
        PBEParameterSpec pbeParamSpec = new PBEParameterSpec(salt, count);
        PBEKeySpec pbeKeySpec = new PBEKeySpec(PASSKEY.toCharArray());
        SecretKeyFactory skFact = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey key = skFact.generateSecret(pbeKeySpec);
        Cipher c = Cipher.getInstance("PBEWithMD5AndDES");
        c.init(Cipher.DECRYPT_MODE, key, pbeParamSpec );
        byte[] encryted =  c.doFinal(plain);
        output = new String(encryted);
        return output;
    }



    public static String getProperty(String prop) {
        if(p == null) {
            return "";
        }
        return p.getProperty(prop);
    }

    public static void setProperty(String prop, String value) {
        if(p == null) {
            p = new Properties();
        }
        p.setProperty(prop, value);
    }

    public static boolean loadConfigurations() {
        p = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(CONFIG_FILENAME);
            p.load(fis);
            p.setProperty(CONFIG_SERVERPASSWORD, decrypt(p.getProperty(CONFIG_SERVERPASSWORD)));
            fis.close();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public static void saveConfiguration() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(CONFIG_FILENAME);
            String serverPass = p.getProperty(CONFIG_SERVERPASSWORD);
            p.setProperty(Configs.CONFIG_SERVERPASSWORD, encrypt(serverPass));
            p.store(fos, "-----Perfume Store Managerment System File------");
            p.setProperty(Configs.CONFIG_SERVERPASSWORD, serverPass);
            fos.close();
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
    }
}
