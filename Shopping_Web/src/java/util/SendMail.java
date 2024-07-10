/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;


/**
 *
 * @author Lewis
 */
public class SendMail {

    public static void send(String toEmail, String subject, String body) {
        
            String user = "thanhcvhe171649@fpt.edu.vn";
            String pass = "mctqedevccbxfapq";
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
            props.put("mail.smtp.port", "587"); //TLS Port
            props.put("mail.smtp.auth", "true"); //enable authentication
            props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
            props.put("mail.smtp.ssl.protocols", "TLSv1.2"); //enable STARTTLS
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, pass);
                }
            });
            try {
            MimeMessage message = new MimeMessage(session);
//            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
//            msg.addHeader("format", "flowed");
//            msg.addHeader("Content-Transfer-Encoding", "8bit");

            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            //msg.setReplyTo(InternetAddress.parse(user, false));
            message.setSubject(subject);
//            , "UTF-8"
            message.setContent(body, "text/html");
//            msg.setText(body, "UTF-8");
//            msg.setSentDate(new Date());
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        send("thanhchu5203@gmail.com", "test mail",
                "<h2>tieu de la gi</h2><p>content</p>");
    }

}
