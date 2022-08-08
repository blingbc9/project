package util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	
	//매개변수 : 발신자, 수신자, 제목, 내용
	public static void sendMail(String from, String to, String subject, String content) {
		// 1. 메일서버 정보 설정(property)
		Properties prop = System.getProperties();
		prop.put("mail.smtp.host", "smtp.naver.com");//정해진대록 작성해야함
		prop.put("mail.smtp.port", "465");//정해진대록 작성해야함
		prop.put("mail.smtp.auth", "true");//정해진대록 작성해야함
		prop.put("mail.smtp.ssl.enable", "true");//정해진대록 작성해야함
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");//정해진대록 작성해야함
		
		//2. 인증을 위해 session객체 생성
		
		Session session = Session.getDefaultInstance(prop, new Authenticator() {//2번째 매개변수
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("qlc9", "blingbrave90!!");
			}
		});
		session.setDebug(true);
		//2. MimeMessage 객체 생성(발신자, 수진자, 제목, 내용 설정)
		try {
			
		MimeMessage mm = new MimeMessage(session);
		mm.setFrom(new InternetAddress(from));//발신자
		mm.setRecipient(Message.RecipientType.TO, new InternetAddress(to));//수신자
		mm.setSubject(subject);// 제목
		//mm.setText(content);//내용
		//html로 보내고 싶을 경우
		mm.setContent(content, "text/html; charset=utf-8");
		
		//4.메일 발송
		Transport.send(mm);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
		
	}
	
	//테스트 삼아 만들어본 main method
	public static void main(String[] args) {
		sendMail("qlc9@naver.com", "blingbc@gmail.com", "test", "<b>한글</b>testest");
	}

}
