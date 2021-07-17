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
	
	// param : 발신자 , 수신자 , 제목 , 내용
	public static void sendMail(String from , String to , String subject , String content) {
		try {
			//1.발신자(메일서버) 정보 설정 (Property)
			Properties prop = System.getProperties();
			prop.put("mail.smtp.host", "smtp.naver.com");
			prop.put("mail.smtp.port", "465"); 
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.ssl.enable", "true");
			prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
			

			
			//2. Session 객체 생성
			Session session = Session.getDefaultInstance(prop, new Authenticator() { 
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("cksgh901", "qwe1004");
				}
			});
			session.setDebug(true);
			//3. MimeMessage 객체 생성 (발신자 , 수신자 , 제목 , 내용 설정)
			MimeMessage mimeMessage = new MimeMessage(session);
			mimeMessage.setFrom(new InternetAddress(from)); // 발신자
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to)); // 수신자
			mimeMessage.setSubject(subject);
			mimeMessage.setText(content);
			//4.메일전송
			Transport.send(mimeMessage);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
			
		}
	public static void main(String[] args) {
		sendMail("cksgh901@naver.com", "cksgh901@gmail.com", "riririri", "vbvbvbvbvb");
	}
}
