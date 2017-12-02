package domain.service;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.servlet.http.Part;

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
	
	public void addNewImage(Part file) {
		this.getRepository().addNewImage(file);
	}

	public BufferedImage getImage(String fileName) {
		return this.getRepository().getImage(fileName);
	}
	
	public List<String> getImageNames() {
		return this.getRepository().getImageNames();
	}
}
