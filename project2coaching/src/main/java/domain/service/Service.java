package domain.service;

import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;

import domain.db.RepoInMemory;
import domain.model.ModelClass;

public class Service {
	
	private RepoInMemory repository;
	private EmailSender sender;
	
	public Service(Properties properties) {
		sender = new EmailSender();
		// initiate databases
		repository = new RepoInMemory();
	}

	public void close() {
		// close databases
	}

	public RepoInMemory getRepository() {
		return repository;
	}
	
	public void sendStandardMail(String emailreceiver) throws MessagingException {
		sender.sendStandardMail(emailreceiver);
	}

	public List<ModelClass> getModels() {
		return this.getRepository().getModels();
	}
	
	public void addNewImage(String string) {
		this.getRepository().addNewImage(string);
	}

	
	public List<String> getImageNames() {
		return this.getRepository().getImageNames();
	}
}
