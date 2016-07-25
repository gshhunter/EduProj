package com.malihong.bean;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.concurrent.Callable;

import javax.mail.*;
import javax.mail.internet.*;


public class MailServer implements Callable<String>{
	private String to;
	private String title;
	private String content;
	 public  MailServer(String to, String title,String content){
		this.to=to;
		this.title=title;
		this.content=content;
	}

	@Override
	public String call() throws Exception {
		// Recipient's email ID

		// Sender's email ID
		String from = "AgentService@malimalihong.com.au";
		String senderName="EDU Service";
		// Get the Session object
		final String username = "AgentService@malimalihong.com.au";
		final String password = "poipoi098098";
		String host = "mail.malimalihong.com.au";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		
	try {		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

			// Create a default MimeMessage object.
		MimeMessage message = new MimeMessage(session);
			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from, senderName));
			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			// Set Subject: header field
			message.setSubject(title,"UTF-8");
			// Now set the actual message
			//message.setText(content);
			message.setContent(content, "text/html;charset=utf-8");
			// Send message
			Transport.send(message);
			return "true";
		} catch (MessagingException e) {
			//throw new RuntimeException(e);
			return "false";
		}

	}
}
