package co.edu.unbosque.forestbet.datamodule.util;

import java.util.Properties;

import jakarta.activation.DataHandler;
import jakarta.activation.FileDataSource;
import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class MailSender {
	/**
	 * Correo electronico
	 */
	private static String emailFrom ="forestbetco@gmail.com";
	/**
	 * Contraseña de seguridad
	 */
	private static String passwordFrom="wmzh irtr pzfr hesd";
	/**
	 * Asunto
	 */
	private static String subject;
	/**
	 * Contenido
	 */
	private static String content;
	/**
	 * Propiedades
	 */
	private static Properties prop;
	/**
	 * Sesion
	 */
	private static Session session;
	/**
	 * Correo
	 */
	private static MimeMessage email;
	
	/**
	 * Metodo para enviar el correo
	 * @param addressee
	 * @param username
	 */
	public static boolean sendEmail(String addressee, String username) {
		prop= new Properties();
		subject= "BIENVENIDO A FORESTBET!";
		content = "<h1> ¡HOLA "+username+"!"+"</h1>"+"<br> Tu casa de apuestas <b> te espera! </b> Contamos con deportes como: <b>Fórmula 1</b>";
		prop.put("mail.smtp.host","smtp.gmail.com");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		prop.setProperty("mail.smtp.starttls.enable", "true");
		prop.setProperty("mail.smtp.port", "587");
		prop.setProperty("mail.smtp.user", emailFrom);
		prop.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		prop.setProperty("mail.smtp.auth", "true");
		
		session = Session.getDefaultInstance(prop);
		
		try {
	
			email= new MimeMessage(session);
			email.setFrom(new InternetAddress(emailFrom));
			email.setRecipient(Message.RecipientType.TO, new InternetAddress(addressee));
			BodyPart text= new MimeBodyPart();
			text.setContent(content,"text/html");
			MimeMultipart part = new MimeMultipart();
			part.addBodyPart(text);
			email.setSubject(subject);
			email.setContent(part);
			Transport t = session.getTransport("smtp");
			t.connect(emailFrom, passwordFrom);
			t.sendMessage(email, email.getRecipients(Message.RecipientType.TO));
			t.close();
			return true;
			
		} catch (AddressException e) {
			e.printStackTrace();
			return false;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
