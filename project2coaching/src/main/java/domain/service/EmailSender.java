package domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

// https://www.arclab.com/en/kb/email/how-to-enable-imap-pop3-smtp-gmail-account.html
// https://www.javatpoint.com/example-of-sending-email-using-java-mail-api
// https://www.mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/

public class EmailSender {

	private String username = "project2coaches.UCLL", password = "p2t@ucll";
	private String messageHeader = "<meta charset=\"ISO-8859-1\">";
	private Properties properties;

	private List<String> list;
	private Random rand;

	public EmailSender() {
		loadProperties();
		createContent();
		rand = new Random();
	}
	
	private void loadProperties() {
		properties = new Properties();
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.password", password);
		properties.put("mail.smtp.user", username);
	}

	public void sendStandardMail(String emailreceiver) throws MessagingException {
		String subject = "Project 2 Coaches - info";
		String message = messageHeader;
		message += "Beste,<br><br>"
				+ list.get(rand.nextInt(list.size()));

		message += "<br><br>"
				+ "--<br>"
				+ "Mvg,<br>"
				+ "Project 2 Coaches";

		String EMAIL_PATTERN = 
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern p = Pattern.compile(EMAIL_PATTERN);
		Matcher m = p.matcher(emailreceiver);
		if (!m.matches()) {
			throw new IllegalArgumentException("Email heeft niet het juiste formaat");
		}

		sendFromGMail(subject, message, emailreceiver);
	}

	private void sendFromGMail(String subject, String body, String to) throws MessagingException {
		Session session = Session.getDefaultInstance(properties);
		
		MimeMessage message = new MimeMessage(session);
		InternetAddress toAddress = new InternetAddress(to);
		message.setRecipient(Message.RecipientType.TO, toAddress);
		message.setSubject(subject);
		message.setContent(body, "text/html; charset=utf-8");
		
		String from = properties.getProperty("mail.smtp.user");
		String password = properties.getProperty("mail.smtp.password");
		Transport transport = session.getTransport("smtp");
		transport.connect(from, password);
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}

	@SuppressWarnings("unused")
	private void sendMultipleFromGMail(String subject, String body, List<String> emailreceivers) throws MessagingException {
		Session session = Session.getDefaultInstance(properties);
		
		String from = properties.getProperty("mail.smtp.user");
		String password = properties.getProperty("mail.smtp.password");
		Transport transport = session.getTransport("smtp");
		transport.connect(from, password);

		for(int i = 0; i < emailreceivers.size(); i++) {
			MimeMessage message = new MimeMessage(session);
			message.setSubject(subject);
			message.setContent(body, "text/html; charset=utf-8");

			InternetAddress toAddress = new InternetAddress(emailreceivers.get(i));
			message.setRecipient(Message.RecipientType.TO, toAddress);

			transport.sendMessage(message, message.getAllRecipients());
		}

		transport.close();
	}
	
	private void createContent() {
		list = new ArrayList<>();
		
		list.add("Om Windows af te sluiten, hoef je niet de gordijnen dicht te doen");
		list.add("Zij wilde de wereld zien, hij installeerde Google Earth");
		list.add("Tenzij je naam Google is, hou op met te doen alsof je alles weet");
		list.add("Facebook is zoals gearresteerd worden: alles wat je zegt kan en zal tegen je gebruikt worden...");
		list.add("Glasvezel door het riool: daar zit een luchtje aan");
		list.add("Op de digitale snelweg kun je ook verongelukken");
		list.add("Een ict'er die zijn griepvirus verspreid, is nooit grappig");
		list.add("Met computers gaat alles sneller, maar het duurt langer");
		list.add("Waarom zijn mensen met een @home e-mailadres niet altijd thuis?");
		list.add("Blondine bij de McDonalds: Zo, het is hier veel goedkoper dan bij de apple store!<BR>Medewerker: Hoe dat zo?<BR>Blondine: Een Mac voor maar €2,60!");
		list.add("Wat is het toppunt van klungelig?<BR>Struikelen over draadloos internet");
		list.add("Computers zijn net vrouwen, je snapt er soms niets van, gelukkig kun je ze wel uitzetten");
		list.add("De meeste computerfouten komen voor tussen het toetsenbord en de leuning van de stoel");
		list.add("Een computer moet je nooit slaan, deze heeft een RAM-geheugen");
		list.add("Een ICT'er vragen of hij een virus heeft opgelopen, is nooit grappig");
		list.add("Een computervirus dat de griep heeft, is nooit grappig.");
		list.add("Er zijn 10 soorten mensen, degene die binair begrijpen en degene die het niet begrijpen.");
		list.add("De dag dat Microsoft iets maakt dat niet zuigt, is de dag dat ze stofzuigers gaan maken.");
		list.add("Mensen maken fouten, maar om er een puinhoop van te maken heb je een computer nodig.");
		list.add("Beter een muisarm dan een apestaartje");
		list.add("Wat is het verschil tussen Windows 95 en Windows 98? Windows 98 crasht op andere momenten. ");
		list.add("Als je computer de volgende keer weer hopeloos vastloopt, bel dan de glazenwasser.<BR>Die heeft verstand van Windows...");
		list.add("Microsoft logica: op start drukken om af te sluiten");
		list.add("Bij IT-ers gaat alles automatisch, maar niets vanzelf");
	}
}