//package com.brainmentors.testengine.utils;
//
//import org.springframework.mail.MailSender;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.stereotype.Component;
//
//import com.brainmentors.testengine.models.user.UserInfo;
//
//@Component
//public class Mail {
//	private MailSender mailSender;
//	
//	
//	public MailSender getMailSender() {
//		return mailSender;
//	}
//	public void setMailSender(MailSender mailSender) {
//		this.mailSender = mailSender;
//	}
//	public boolean sendMail(String from , String to, String sub, String msg) {
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setTo(to);
//		message.setFrom(from);
//		message.setSubject(sub);
//		message.setText(msg);
//		mailSender.send(message);
//		return true;
//	}
//	static int power(int base, int p) {
//		if(p==0) {
//			return 1;
//		}
//		return base * power(base,p-1);
//	}
//	static void print(int n){
//		if(n<=0) {
//			return ;
//		}
//		if(n%2!=0) {
//		System.out.println(n);
//		}
//		print(n-1);
//		if(n%2==0) {
//		System.out.println(n);
//		}
//		
//	}
//	public static void main(String[] args) {
//		//print(5);
//		System.out.println(power(2,3));
//	}
//
//}
