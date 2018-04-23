package utill;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import reservation.view.ReservationInfoToRest;

public class NaverMail  {
	ReservationInfoToRest reser;



	public NaverMail(ReservationInfoToRest reser2) throws AddressException, MessagingException {
		super();
		this.reser = reser2;
		sendMail();
	}
	public void sendMail() throws AddressException, MessagingException{
		
        String host = "smtp.gmail.com";
        final String username = "eatdanoreplay@gmail.com";
        final String password = "eatdanoreplay!";

        // 메일 내용
        String recipient = reser.reser.getReserEmail();
        String subject = reser.reser.getReserName()+"님 예약이완료 되었습니다.";
        String body = reser.strRestaurant+"\n"+
        		"날짜 : "+reser.strDate+"\n"+
        		"시간 : "+reser.strHour+"\n"+
        		"\n" + 
        		"eatda를 이용해주셔서 감사합니다.";
        
        //properties 설정
        Properties props = new Properties();

        props.put("mail.smtps.auth", "true");
        // 메일 세션

        Session session = Session.getDefaultInstance(props);
        MimeMessage msg = new MimeMessage(session);

        // 메일 관련

        msg.setSubject(subject);

        msg.setText(body);

        msg.setFrom(new InternetAddress(username));

        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

 

        // 발송 처리

        Transport transport = session.getTransport("smtps");

        transport.connect(host, username, password);

        transport.sendMessage(msg, msg.getAllRecipients());

        transport.close();       


	}
}
