package domain.service;

import java.util.Properties;

import javax.mail.MessagingException;

import domain.model.EmailSender;

public class Service {
	
	private EmailSender sender;
	
	public Service(Properties properties) {
		sender = new EmailSender();
		// initiate databases
	}

	public void close() {
		// close databases
	}
	
	public void sendStandardMail(String emailreceiver) throws MessagingException {
		sender.sendStandardMail(emailreceiver);
	}
}
