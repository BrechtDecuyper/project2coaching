package domain.db;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.Part;

import domain.model.ModelClass;

public class RepoInMemory {

	int count = 0;
	List<ModelClass> models;
	Map<String, BufferedImage> images;
	
	public RepoInMemory() {
		models = new ArrayList<>();
		images = new HashMap<>();
		this.initiateModels();
	}
	
	public void addNewModel(ModelClass model) {
		this.models.add(model);
	}
	
	public List<ModelClass> getModels() {
		return this.models;
	}
	
	public void addNewImage(Part file) {
		try {
			String fileName = "image" + (count++) + file.getSubmittedFileName().substring(file.getSubmittedFileName().lastIndexOf("."));
			BufferedImage image = ImageIO.read(file.getInputStream());
			this.images.put(fileName, image);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getImage(String fileName) {
		return this.images.get(fileName);
	}
	
	public List<String> getImageNames() {
		return new ArrayList<String>(this.images.keySet());
	}

	private void initiateModels() {
		this.addNewModel(new ModelClass("Simple Minds","Someone Somewhere (In Summertime) - Remix"));
		this.addNewModel(new ModelClass("Bronski Beat","Why?"));
		this.addNewModel(new ModelClass("The Police","Message In A Bottle (Edit)"));
		this.addNewModel(new ModelClass("The Steve Miller Band","Abracadabra"));
		this.addNewModel(new ModelClass("Eagles","Hotel California"));
		this.addNewModel(new ModelClass("10CC","Dreadlock Holiday"));
		this.addNewModel(new ModelClass("David Bowie/Pat Metheny Group","This is Not America"));
		this.addNewModel(new ModelClass("R.E.M.","Losing My Religion"));
		this.addNewModel(new ModelClass("John Lennon & Yoko Ono and The Plastic Ono Band","Happy X-Mas (War Is Over)"));
		this.addNewModel(new ModelClass("Yes","Owner Of A Lonely Heart"));
	}
}
