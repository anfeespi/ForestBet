package co.edu.unbosque.forestbet.datamodule.util;

import java.util.Properties;

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
		content = "<!DOCTYPE html>\r\n"
				+ "<html xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" lang=\"en\">\r\n"
				+ "\r\n"
				+ "<head>\r\n"
				+ "	<title></title>\r\n"
				+ "	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n"
				+ "	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><!--[if mso]><xml><o:OfficeDocumentSettings><o:PixelsPerInch>96</o:PixelsPerInch><o:AllowPNG/></o:OfficeDocumentSettings></xml><![endif]--><!--[if !mso]><!-->\r\n"
				+ "	<link href=\"https://fonts.googleapis.com/css2?family=Cabin:wght@100;200;300;400;500;600;700;800;900\" rel=\"stylesheet\" type=\"text/css\"><!--<![endif]-->\r\n"
				+ "	<style>\r\n"
				+ "		* {\r\n"
				+ "			box-sizing: border-box;\r\n"
				+ "		}\r\n"
				+ "\r\n"
				+ "		body {\r\n"
				+ "			margin: 0;\r\n"
				+ "			padding: 0;\r\n"
				+ "		}\r\n"
				+ "\r\n"
				+ "		a[x-apple-data-detectors] {\r\n"
				+ "			color: inherit !important;\r\n"
				+ "			text-decoration: inherit !important;\r\n"
				+ "		}\r\n"
				+ "\r\n"
				+ "		#MessageViewBody a {\r\n"
				+ "			color: inherit;\r\n"
				+ "			text-decoration: none;\r\n"
				+ "		}\r\n"
				+ "\r\n"
				+ "		p {\r\n"
				+ "			line-height: inherit\r\n"
				+ "		}\r\n"
				+ "\r\n"
				+ "		.desktop_hide,\r\n"
				+ "		.desktop_hide table {\r\n"
				+ "			mso-hide: all;\r\n"
				+ "			display: none;\r\n"
				+ "			max-height: 0px;\r\n"
				+ "			overflow: hidden;\r\n"
				+ "		}\r\n"
				+ "\r\n"
				+ "		.image_block img+div {\r\n"
				+ "			display: none;\r\n"
				+ "		}\r\n"
				+ "\r\n"
				+ "		@media (max-width:520px) {\r\n"
				+ "			.desktop_hide table.icons-inner {\r\n"
				+ "				display: inline-block !important;\r\n"
				+ "			}\r\n"
				+ "\r\n"
				+ "			.icons-inner {\r\n"
				+ "				text-align: center;\r\n"
				+ "			}\r\n"
				+ "\r\n"
				+ "			.icons-inner td {\r\n"
				+ "				margin: 0 auto;\r\n"
				+ "			}\r\n"
				+ "\r\n"
				+ "			.image_block div.fullWidth {\r\n"
				+ "				max-width: 100% !important;\r\n"
				+ "			}\r\n"
				+ "\r\n"
				+ "			.mobile_hide {\r\n"
				+ "				display: none;\r\n"
				+ "			}\r\n"
				+ "\r\n"
				+ "			.row-content {\r\n"
				+ "				width: 100% !important;\r\n"
				+ "			}\r\n"
				+ "\r\n"
				+ "			.stack .column {\r\n"
				+ "				width: 100%;\r\n"
				+ "				display: block;\r\n"
				+ "			}\r\n"
				+ "\r\n"
				+ "			.mobile_hide {\r\n"
				+ "				min-height: 0;\r\n"
				+ "				max-height: 0;\r\n"
				+ "				max-width: 0;\r\n"
				+ "				overflow: hidden;\r\n"
				+ "				font-size: 0px;\r\n"
				+ "			}\r\n"
				+ "\r\n"
				+ "			.desktop_hide,\r\n"
				+ "			.desktop_hide table {\r\n"
				+ "				display: table !important;\r\n"
				+ "				max-height: none !important;\r\n"
				+ "			}\r\n"
				+ "		}\r\n"
				+ "	</style>\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body style=\"margin: 0; background-color: #f5f5f5; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;\">\r\n"
				+ "	<table class=\"nl-container\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #f5f5f5;\">\r\n"
				+ "		<tbody>\r\n"
				+ "			<tr>\r\n"
				+ "				<td>\r\n"
				+ "					<table class=\"row row-1\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\r\n"
				+ "						<tbody>\r\n"
				+ "							<tr>\r\n"
				+ "								<td>\r\n"
				+ "									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #f5f5f5; color: #000000; width: 500px; margin: 0 auto;\" width=\"500\">\r\n"
				+ "										<tbody>\r\n"
				+ "											<tr>\r\n"
				+ "												<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 40px; padding-left: 20px; padding-right: 20px; padding-top: 40px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\r\n"
				+ "													<table class=\"image_block block-1\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\r\n"
				+ "														<tr>\r\n"
				+ "															<td class=\"pad\" style=\"width:100%;padding-right:0px;padding-left:0px;\">\r\n"
				+ "																<div class=\"alignment\" align=\"center\" style=\"line-height:10px\">\r\n"
				+ "																	<div style=\"max-width: 207px;\"><img src=\"https://194eec9c4d.imgdist.com/pub/bfra/jddyefm1/9vm/oin/c4k/logoforest.png\" style=\"display: block; height: auto; border: 0; width: 100%;\" width=\"207\" height=\"auto\"></div>\r\n"
				+ "																</div>\r\n"
				+ "															</td>\r\n"
				+ "														</tr>\r\n"
				+ "													</table>\r\n"
				+ "													<table class=\"heading_block block-2\" width=\"100%\" border=\"0\" cellpadding=\"10\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\r\n"
				+ "														<tr>\r\n"
				+ "															<td class=\"pad\">\r\n"
				+ "																<h1 style=\"margin: 0; color: #000000; direction: ltr; font-family: 'Cabin', Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size: 24px; font-weight: 700; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0; mso-line-height-alt: 28.799999999999997px;\"><strong>¡"+username+", Bienvenido a ForestBet!<br></strong></h1>\r\n"
				+ "															</td>\r\n"
				+ "														</tr>\r\n"
				+ "													</table>\r\n"
				+ "													<table class=\"heading_block block-3\" width=\"100%\" border=\"0\" cellpadding=\"10\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\r\n"
				+ "														<tr>\r\n"
				+ "															<td class=\"pad\">\r\n"
				+ "																<h1 style=\"margin: 0; color: #000000; direction: ltr; font-family: 'Cabin', Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size: 16px; font-weight: 700; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0; mso-line-height-alt: 19.2px;\"><strong>Explora el mundo de la Fórmula 1, conoce a tus pilotos favoritos y apuesta por el próximo campeón.</strong></h1>\r\n"
				+ "															</td>\r\n"
				+ "														</tr>\r\n"
				+ "													</table>\r\n"
				+ "												</td>\r\n"
				+ "											</tr>\r\n"
				+ "										</tbody>\r\n"
				+ "									</table>\r\n"
				+ "								</td>\r\n"
				+ "							</tr>\r\n"
				+ "						</tbody>\r\n"
				+ "					</table>\r\n"
				+ "					<table class=\"row row-2\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\r\n"
				+ "						<tbody>\r\n"
				+ "							<tr>\r\n"
				+ "								<td>\r\n"
				+ "									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; background-color: #000000; width: 500px; margin: 0 auto;\" width=\"500\">\r\n"
				+ "										<tbody>\r\n"
				+ "											<tr>\r\n"
				+ "												<td class=\"column column-1\" width=\"58.333333333333336%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; background-color: #000000; padding-bottom: 20px; padding-left: 20px; padding-right: 20px; padding-top: 20px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\r\n"
				+ "													<table class=\"image_block block-1\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\r\n"
				+ "														<tr>\r\n"
				+ "															<td class=\"pad\" style=\"width:100%;padding-right:0px;padding-left:0px;\">\r\n"
				+ "																<div class=\"alignment\" align=\"center\" style=\"line-height:10px\">\r\n"
				+ "																	<div class=\"fullWidth\" style=\"max-width: 251.667px;\"><img src=\"https://194eec9c4d.imgdist.com/pub/bfra/jddyefm1/awp/1uw/olz/Brazil%20in%20the%20Wet%20_%20F1%20wallpaper%20hd%2C%20Fondos%20de%20pantalla%20de%20coches%2C%20Coches%20geniales.jpeg\" style=\"display: block; height: auto; border: 0; width: 100%;\" width=\"251.667\" alt=\"Black woman\" title=\"Black woman\" height=\"auto\"></div>\r\n"
				+ "																</div>\r\n"
				+ "															</td>\r\n"
				+ "														</tr>\r\n"
				+ "													</table>\r\n"
				+ "												</td>\r\n"
				+ "												<td class=\"column column-2\" width=\"41.666666666666664%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 20px; padding-left: 20px; padding-right: 20px; padding-top: 20px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\r\n"
				+ "													<table class=\"paragraph_block block-1\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\r\n"
				+ "														<tr>\r\n"
				+ "															<td class=\"pad\">\r\n"
				+ "																<div style=\"color:#ffffff;font-family:'Cabin', Arial, 'Helvetica Neue', Helvetica, sans-serif;font-size:18px;line-height:120%;text-align:justify;mso-line-height-alt:21.599999999999998px;\">\r\n"
				+ "																	<p style=\"margin: 0; word-break: break-word;\">&nbsp;</p>\r\n"
				+ "																	<p style=\"margin: 0; word-break: break-word;\">&nbsp;</p>\r\n"
				+ "																	<p style=\"margin: 0; word-break: break-word;\">&nbsp;</p>\r\n"
				+ "																	<p style=\"margin: 0; word-break: break-word;\">&nbsp;</p>\r\n"
				+ "																	<p style=\"margin: 0; word-break: break-word;\"><span style=\"font-family:Arial, Helvetica Neue, Helvetica, sans-serif background-color: transparent;\">Aquí, la adrenalina de las carreras se une con la emoción de las apuestas. Descubre datos actualizados de pilotos y escuderías, haz tus predicciones y siente la velocidad de ganar. </span></p>\r\n"
				+ "																	<p style=\"margin: 0; word-break: break-word;\">&nbsp;</p>\r\n"
				+ "																	<p style=\"margin: 0;\">&nbsp;</p>\r\n"
				+ "																</div>\r\n"
				+ "															</td>\r\n"
				+ "														</tr>\r\n"
				+ "													</table>\r\n"
				+ "													<table class=\"paragraph_block block-2\" width=\"100%\" border=\"0\" cellpadding=\"10\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\r\n"
				+ "														<tr>\r\n"
				+ "															<td class=\"pad\">\r\n"
				+ "																<div style=\"color:#ffffff;direction:ltr;font-family:'Cabin', Arial, 'Helvetica Neue', Helvetica, sans-serif;font-size:16px;font-weight:700;letter-spacing:0px;line-height:120%;text-align:center;mso-line-height-alt:19.2px;\">\r\n"
				+ "																	<p style=\"margin: 0;\">¡ForestBet: Tu Apuesta, Tu Carrera!</p>\r\n"
				+ "																</div>\r\n"
				+ "															</td>\r\n"
				+ "														</tr>\r\n"
				+ "													</table>\r\n"
				+ "												</td>\r\n"
				+ "											</tr>\r\n"
				+ "										</tbody>\r\n"
				+ "									</table>\r\n"
				+ "								</td>\r\n"
				+ "							</tr>\r\n"
				+ "						</tbody>\r\n"
				+ "					</table>\r\n"
				+ "					<table class=\"row row-3\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\r\n"
				+ "						<tbody>\r\n"
				+ "							<tr>\r\n"
				+ "								<td>\r\n"
				+ "									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 500px; margin: 0 auto;\" width=\"500\">\r\n"
				+ "										<tbody>\r\n"
				+ "											<tr>\r\n"
				+ "												<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\r\n"
				+ "													<div class=\"spacer_block block-1\" style=\"height:10px;line-height:10px;font-size:1px;\">&#8202;</div>\r\n"
				+ "												</td>\r\n"
				+ "											</tr>\r\n"
				+ "										</tbody>\r\n"
				+ "									</table>\r\n"
				+ "								</td>\r\n"
				+ "							</tr>\r\n"
				+ "						</tbody>\r\n"
				+ "					</table>\r\n"
				+ "					<table class=\"row row-4\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff;\">\r\n"
				+ "						<tbody>\r\n"
				+ "							<tr>\r\n"
				+ "								<td>\r\n"
				+ "									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 500px; margin: 0 auto;\" width=\"500\">\r\n"
				+ "										<tbody>\r\n"
				+ "											<tr>\r\n"
				+ "												<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\r\n"
				+ "													<table class=\"icons_block block-1\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; text-align: center;\">\r\n"
				+ "														<tr>\r\n"
				+ "															<td class=\"pad\" style=\"vertical-align: middle; color: #1e0e4b; font-family: 'Inter', sans-serif; font-size: 15px; padding-bottom: 5px; padding-top: 5px; text-align: center;\">\r\n"
				+ "																<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\r\n"
				+ "																	<tr>\r\n"
				+ "																		<td class=\"alignment\" style=\"vertical-align: middle; text-align: center;\"><!--[if vml]><table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"display:inline-block;padding-left:0px;padding-right:0px;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\"><![endif]-->\r\n"
				+ "																			<!--[if !vml]><!-->\r\n"
				+ "																			<table class=\"icons-inner\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block; margin-right: -4px; padding-left: 0px; padding-right: 0px;\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><!--<![endif]-->\r\n"
				+ "																				<tr>\r\n"
				+ "																					<td style=\"vertical-align: middle; text-align: center; padding-top: 5px; padding-bottom: 5px; padding-left: 5px; padding-right: 6px;\"><a href=\"http://designedwithbeefree.com/\" target=\"_blank\" style=\"text-decoration: none;\"><img class=\"icon\" alt=\"Beefree Logo\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/assets/Beefree-logo.png\" height=\"auto\" width=\"34\" align=\"center\" style=\"display: block; height: auto; margin: 0 auto; border: 0;\"></a></td>\r\n"
				+ "																					<td style=\"font-family: 'Inter', sans-serif; font-size: 15px; font-weight: undefined; color: #1e0e4b; vertical-align: middle; letter-spacing: undefined; text-align: center;\"><a href=\"http://designedwithbeefree.com/\" target=\"_blank\" style=\"color: #1e0e4b; text-decoration: none;\">Designed with Beefree</a></td>\r\n"
				+ "																				</tr>\r\n"
				+ "																			</table>\r\n"
				+ "																		</td>\r\n"
				+ "																	</tr>\r\n"
				+ "																</table>\r\n"
				+ "															</td>\r\n"
				+ "														</tr>\r\n"
				+ "													</table>\r\n"
				+ "												</td>\r\n"
				+ "											</tr>\r\n"
				+ "										</tbody>\r\n"
				+ "									</table>\r\n"
				+ "								</td>\r\n"
				+ "							</tr>\r\n"
				+ "						</tbody>\r\n"
				+ "					</table>\r\n"
				+ "				</td>\r\n"
				+ "			</tr>\r\n"
				+ "		</tbody>\r\n"
				+ "	</table><!-- End -->\r\n"
				+ "</body>\r\n"
				+ "\r\n"
				+ "</html>";
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
