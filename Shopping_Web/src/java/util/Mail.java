package util;

/**
 *
 * @author nqtie
 */
//public class Mail {
//    
//}
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {

    public void sentMail(String Email, int userID, String join_date) {
        String emailFrom = "tiennqhe172599@fpt.edu.vn";
        String emailTo = Email;
//        String username = "909545f9ea1af1";
        String password = "vpjj ezty lpoh qwjn";
        //properties
        Properties pro = new Properties();
        pro.put("mail.smtp.host", "smtp.gmail.com");
        pro.put("mail.smtp.port", "587");
        pro.put("mail.smtp.auth", "true");
        pro.put("mail.smtp.starttls.enable", "true");
        pro.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        //create authenticator
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailFrom, password);
            }
        };
        //workplace
        Session session = Session.getInstance(pro, auth);
        //create message
        MimeMessage msg = new MimeMessage(session);
        try {
            msg.addHeader("Content-type", "charset=UTF-8");
            msg.setFrom(new InternetAddress(emailFrom));  //nguoi gui
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailTo, false));   //nguoi nhan

            //tieu de
            msg.setSubject("Xác nhận đăng ký" + System.currentTimeMillis());
            //quy dinh ngay gui
            msg.setSentDate(new Date());
            //quy dinh email nhan phan hoi
            //msg.setReplyTo(addresses);
            //noi dung
            msg.setContent("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <title>TODO supply a title</title>\n"
                    + "        <meta charset=\"UTF-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        <a href=\"http://localhost:9999/myshop/RegisterURL?service=updateUserstatus&userID="+userID+"&date="+join_date+"\" style=\"text-decoration:none; font-size:25px;\">Nhấn vào đây</a>"
                    + "<span style=\"font-size:25px;\"> để xác nhận đăng ký tài khoản của bạn</span>\n"
                    + "    </body>\n"
                    + "</html>\n", "text/html;charset=UTF-8");

            //gui email
            Transport.send(msg);
            System.out.println("Email sent successful");
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Mail mail = new Mail();
        mail.sentMail("thanhchu5203@gmail.com", 1, "cc");
    }

}