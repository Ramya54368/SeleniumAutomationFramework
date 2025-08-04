package demo;

import java.io.File;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class EmailSender {
	public static void main(String[] args) {
		// running this class separetly without using testng

		final String senderEmail = "ramyauppu543@gmail.com";
		final String appPassword = "tirboxztoigyyeqb";
		final String receiverEmail = "ramyauppu543@gmail.com";

		// CREATING SMTP SERVER PROPERTIES

		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.port", "587");

		// create a seesion with authentication
		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, appPassword);
			}
		});
		session.setDebug(true);

		try {
			// create email msg
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiverEmail));
			message.setSubject("Test Email from QA Automation");
			// message.setText("Hello \n This is a test email from java \n Regards, \n QA
			// Team");

			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setText("Hello \n\n This is a test email from java \n Regards, \n QA Team");

			// Attachment Part
			MimeBodyPart attachmentPart = new MimeBodyPart();
			String filePath = System.getProperty("user.dir") +"/reports/ExtentReports.html";
			
			System.out.println("attachment path is: " + filePath);
			attachmentPart.attachFile(new File(filePath));

			// combine body and attachment part********

			MimeMultipart multiPart = new MimeMultipart();
			multiPart.addBodyPart(textPart);
			multiPart.addBodyPart(attachmentPart);
			message.setContent(multiPart);

			// send Email
			Transport.send(message);
			System.out.println("Email send successfully*************");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
