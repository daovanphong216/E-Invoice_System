package service;

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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDAO;

@Component
@Transactional
public class SendEmailJob implements Runnable {
	@Autowired
	@Qualifier("userService")
	UserService userService;
	
	@Autowired
	 @Qualifier("sessionFactory")
	 SessionFactory sessionFactory;
	

	
    @Override
    public void run() {
    	System.out.println("hihi");
    	org.hibernate.Session session = sessionFactory.openSession();
        List<User> users = session.createQuery("select us from users us").list();
        session.close();
    	String subject = "E-Invoice System monthly notification";
    	System.out.print(users.size());
    	if (!users.isEmpty()){
			for (int i=0; i< users.size(); i++){
    		String content = "Hihi";
    		boolean isSend=sendMail(users.get(i).getEmail(), subject, content);
    		System.out.print(isSend);
    	}
	}
    }
    
    @Async
    public boolean sendMail(String to, String subject, String content) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "pop.gmail.com");
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

    
    @Async
    private void sendMails()  {
    	
    	/*org.hibernate.Session session = sessionFactory.openSession();
        List<User> users = session.createQuery("select us from users us").list();
        session.close();
       // return list;
    	
    	//List<User> users = userService.getAll();
    	System.out.print(users.size());
    	String subject = "E-Invoice System monthly notification";
    	if (!users.isEmpty()){
    			for (int i=0; i< users.size(); i++){
        		String content = "Hihi";
        		boolean isSend=sendMail(users.get(i).getEmail(), subject, content);
        	}
    	}*/
    	
    }

}
