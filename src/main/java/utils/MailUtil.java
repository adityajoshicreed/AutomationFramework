package utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import constants.Constants;

public class MailUtil {

	public void sendMail(String message_body) {
	      String recipient = Constants.recipientEmail; 
	      String sender = Constants.senderEmail; 
	      String host = Constants.smtpHost; 
	      Properties properties = System.getProperties(); 
	      properties.setProperty("mail.smtp.host", host); 
	      properties.setProperty("mail.smtp.auth", "true");
	      properties.setProperty("mail.smtp.starttls.enable", "true");
	      properties.setProperty("mail.smtp.port", "587");
	      Session session = Session.getDefaultInstance(properties,
	    		  new javax.mail.Authenticator() {
	          protected PasswordAuthentication getPasswordAuthentication() {
	              return new PasswordAuthentication(Constants.senderEmail, Constants.senderPass);
	           }
	      });   
	      try 
	      {
	         MimeMessage message = new MimeMessage(session); 
	         message.setFrom(new InternetAddress(sender)); 
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); 
	         message.setSubject("Automation Report"); 
	         message.setText(message_body); 
	         Transport.send(message); 
	         System.out.println("Mail successfully sent"); 
	      } 
	      catch (MessagingException mex)  
	      { 
	         mex.printStackTrace(); 
	      } 
	}
	
}
