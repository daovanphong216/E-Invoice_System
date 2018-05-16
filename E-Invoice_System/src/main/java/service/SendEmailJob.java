package service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import model.Account;
import model.User;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDAO;

@Repository
@Transactional
public class SendEmailJob implements Runnable {
	@Autowired
	@Qualifier("userService")
	UserService userService;
	
	
	/*private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/
	
	

	
    @Override
    public void run() {
    	List<User> users = userService.getAll();
    	String subject = "E-Invoice System monthly notification";
    	/*Date dateObj = new Date();
    	int month = dateObj.getMonth() + 1; //months from 1-12
    	int year = dateObj.getYear();*/
    	
    	Calendar c = Calendar.getInstance();
    	int year = c.get(Calendar.YEAR);
    	int month = c.get(Calendar.MONTH)+1;
    	if (!users.isEmpty()){
			for (int i=0; i< users.size(); i++){
				double limitedMoney = users.get(i).getLimitedMoney();
				double sumMoney= users.get(i).getTotalMoney(year, month);
				String content = "In month " + month + "/" + year + ", you have spent " + sumMoney + "$";
				if (limitedMoney<sumMoney) {
					content +="You have exceed the limit. Your limit is " + limitedMoney + "$";
				}
				boolean isSend;
				try {
					isSend = sendMail(users.get(i).getEmail(), subject, content);
					System.out.println(isSend);
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
    	}
	}
    }
    
   @Async
    public boolean sendMail(String to, String subject, String content) throws UnknownHostException {
	   	String  host=InetAddress.getLocalHost().getHostName();
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        //props.put("mail.smtp.host", "pop.gmail.com");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "25");
        
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication("einvoicesystem@gmail.com", "teamnhau");
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setHeader("Content-Type", "text/plain; charset=UTF-8");
            message.setFrom(new InternetAddress("einvoicesystem@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(content);
            Transport.send(message);
        } catch (MessagingException e) {
            return false;
        }
        return true;
}

    
   

}
