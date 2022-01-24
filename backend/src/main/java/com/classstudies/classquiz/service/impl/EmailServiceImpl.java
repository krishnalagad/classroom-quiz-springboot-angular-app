package com.classstudies.classquiz.service.impl;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.classstudies.classquiz.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
	
	public boolean sendEmail(String subject, String message, String to) {
		
		boolean f = false;
		
//		sender 
		String from = "YOUR EMAIL ID;
		
//		Variable for gmail
		String host = "smtp.gmail.com";
		
//		get the system properties
		Properties properties = System.getProperties();
		System.out.print("Properties: " + properties);
		
//		Setting important info to the propertiess object
		
//		host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
//		Step 1: to get the session object
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication("YOUR EMAIL ID", "YOUR ACCOUNTS PASSWORD");
			}
			
			
		});
		
		session.setDebug(true);
		
//		Step 2: Compose the message
		MimeMessage m = new MimeMessage(session);
		
		try {
			
//			from email
			m.setFrom(from);
			
//			Adding receipient to email
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
//			Adding subject to the message
			m.setSubject(subject);
			
//			Adding text to message
//			m.setText(message);
			m.setContent(message, "text/html");
			
//			send
			
//			Step 3: Send the message using transport class
			Transport.send(m);
			
			System.out.println("Sent Succesfully...");
			f = true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
}
