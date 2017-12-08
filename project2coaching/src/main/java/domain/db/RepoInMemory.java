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
		this.addNewModel(new ModelClass("Simple Minds","Someone Somewhere (In Summertime) - Remix", "https://www.youtube.com/watch?v=RUedmyr2G0M"));
		this.addNewModel(new ModelClass("Bronski Beat","Why?", "https://www.youtube.com/watch?v=PxJVbe-D2cA"));
		this.addNewModel(new ModelClass("The Police","Message In A Bottle (Edit)", "https://www.youtube.com/watch?v=ObL3L6MRvN4"));
		this.addNewModel(new ModelClass("The Steve Miller Band","Abracadabra", "https://www.youtube.com/watch?v=hindso2RviY"));
		this.addNewModel(new ModelClass("Eagles","Hotel California", "https://www.youtube.com/watch?v=EqPtz5qN7HM"));
		this.addNewModel(new ModelClass("10CC","Dreadlock Holiday", "https://www.youtube.com/watch?v=fUNTk5xsxk4"));
		this.addNewModel(new ModelClass("David Bowie/Pat Metheny Group","This is Not America", "https://www.youtube.com/watch?v=-KDMDda5DNg"));
		this.addNewModel(new ModelClass("R.E.M.","Losing My Religion", "https://www.youtube.com/watch?v=OKvCV8MFIaw"));
		this.addNewModel(new ModelClass("John Lennon & Yoko Ono and The Plastic Ono Band","Happy X-Mas (War Is Over)", "https://www.youtube.com/watch?v=yN4Uu0OlmTg"));
		this.addNewModel(new ModelClass("Yes","Owner Of A Lonely Heart", "https://www.youtube.com/watch?v=9O6e7cgkeqw"));
	}
}
