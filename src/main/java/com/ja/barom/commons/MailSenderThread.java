package com.ja.barom.commons;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailSenderThread extends Thread{

	private JavaMailSender javaMailSender;
	private String to;
	private String message;
	private String subject;
	private String setFrom;
	
	public MailSenderThread(JavaMailSender javaMailSender , String to , String message , String subject, String setFrom) {
		this.javaMailSender = javaMailSender;
		this.to = to;
		this.message = message;
		this.subject = subject;
		this.setFrom = setFrom;
	}
	
	public void run() {
		 try {
		    	MimeMessage mail = javaMailSender.createMimeMessage();
		        MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");
		        
		        mailHelper.setFrom(setFrom, "Barom관리자");
		        mailHelper.setTo(to);
		        mailHelper.setSubject(subject);
		        mailHelper.setText(message, true);       
		        
		        javaMailSender.send(mail);
		 } catch(Exception e) {
	   
	 }
 }
}
