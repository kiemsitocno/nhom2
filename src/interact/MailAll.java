/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interact;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.swing.JOptionPane;

/**
 *
 * @author KhanhLong
 */
interface configMail {
    Session CheckMail(String username,String password);
    Properties checknameMail(String name);
    
}

public class MailAll implements configMail {
     @Override
    public Properties checknameMail(String name)
    {
        Properties pp = null;
        try
        {
            String[] tmp = name.split("@");
            if(tmp[1].contains("gmail.com"))
            {
                pp = System.getProperties();
                pp.put("mail.smtp.host", "pop.gmail.com");
                pp.put("mail.transport.protocol","smtp");
                pp.put("mail.smtp.starttls.enable","true");
                pp.put("mail.smtp.auth","true");
            }
            
            if(tmp[1].contains("yahoo.com"))
            {
                pp = System.getProperties();
                pp.put("mail.smtp.host", "smtp.mail.yahoo.com");
                pp.put("mail.transport.protocol","smtp");
                pp.put("mail.smtp.starttls.enable","true");
                pp.put("mail.smtp.auth","true");
            }
            
            if(tmp[1].contains("outlook.com") || tmp[1].contains("live.com"))
            {
                pp = System.getProperties();
                pp.put("mail.smtp.host", "smtp.live.com");
                pp.put("mail.transport.protocol","smtps");
                pp.put("mail.smtp.starttls.enable","true");
                pp.put("mail.smtp.auth","true");
            }
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Dang Nhap That Bai");
        }
        return pp;
    }
    
    @Override
    @SuppressWarnings("empty-statement")
    public Session CheckMail(final String username,final String password)
    {
        
        Session session = null;
        Authenticator au = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(username,password);
            }
        };
       Transport transport = null;
        try {
            if(checknameMail(username)!=null)
            {
                session = Session.getInstance(checknameMail(username),au);
                if(checknameMail(username).getProperty("mail.smtp.host").equalsIgnoreCase("pop.gmail.com"))
                {
                    transport = session.getTransport("smtps");
                    transport.connect("smtp.gmail.com", 465, username, password);
                    if(transport.isConnected())
                    return session;
                }
                else if(checknameMail(username).getProperty("mail.smtp.host").equalsIgnoreCase("smtp.mail.yahoo.com"))
                {
                    transport = session.getTransport("smtp");
                    transport.connect("smtp.mail.yahoo.com", 587, username, password);
                    if(transport.isConnected())
                    return session;
                }
                else
                {
                    transport = session.getTransport("smtp");
                    transport.connect("smtp.live.com", 587, username, password);
                    if(transport.isConnected())
                    return session;
                }
            }
        } catch (MessagingException ex) {
            JOptionPane.showMessageDialog(null, "Đăng nhập thất bại sai ID hoặc Password");
        }
        
        return null;
    }
    public static Session runCheck(String u,String p)
    {
        MailAll m = new MailAll();
         return m.CheckMail(u, p);
        
    }
}
