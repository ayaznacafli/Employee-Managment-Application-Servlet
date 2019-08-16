/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mail;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class EmailConfing {
	                                                                    
	private Properties getProperties(){
		String host="smtp.mail.ru";
		
		Properties properties = new Properties();
		
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.port", "587");
		
		
		return properties;
		
	}
	
	public void sendMail(String toEmail,String subject,String text) throws MessagingException{
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
		String user="employe@inbox.ru";
		String password="ayaz10111997";
		
		Properties properties = getProperties();
		Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
			
};
		
		Session session = Session.getDefaultInstance(properties,authenticator);
		MimeMessage message = new MimeMessage(session);
		try {
			
			message.setFrom(new InternetAddress(user));
			message.addRecipients(Message.RecipientType.TO, toEmail);
			message.setSubject(subject);
			message.setText(text);
			
			Transport.send(message);
			
			
		} catch (MessagingException e) {
			System.out.println("Email sand error...");
			e.printStackTrace();
		}
		
				
			}
		});
		thread.start();
		
		  
		
	}


}
