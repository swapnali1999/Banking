package com.banking.auth.serviceimpl;

import java.util.Properties;



import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl {
     
	static final String FROM="sanketwin9@gmail.com";
	static final String FROMNAME="Sanket Rasal";
	static final String SMTP_USERNAME="sanketwin9@gmail.com";
	static final String SMTP_PASSWORD="00071342247";
	static final String HOST ="smtp.gmail.com";
	static final String PORT ="587";
	static final String SUBJECT="Banking OTP";
	
	
	
	
	public boolean sendMail(String email, long transactionPin) {
		// TODO Auto-generated method stub
		try {
			Properties props=System.getProperties();
			props.put("mail.transport.protocol","smtp");
			props.put("mail.smtp.host", HOST);
			props.put("mail.smtp.port", PORT);
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", "true");
			
			Session session=Session.getDefaultInstance(props);
			MimeMessage msg=new MimeMessage(session);
			msg.setFrom(new InternetAddress(FROM,FROMNAME));
			msg.setRecipient(Message.RecipientType.TO,new InternetAddress(email));
			msg.setSubject(SUBJECT);
			msg.setContent("please enter otp to verify email: "+transactionPin,"text/html");
			Transport transport=session.getTransport();
			transport.connect(HOST,SMTP_USERNAME,SMTP_PASSWORD);
			transport.sendMessage(msg,msg.getAllRecipients());
			return true;
		}catch(Exception ex) {
			return false;
					
		}
			
	}

}
