package domain.db;

import java.util.ArrayList;
import java.util.List;

import domain.model.ModelClass;

public class RepoInMemory {

	List<ModelClass> models;
	
	public RepoInMemory() {
		models = new ArrayList<>();
		this.initiateModels();
	}
	
	public void addNewModel(ModelClass model) {
		this.models.add(model);
	}
	
	public List<ModelClass> getModels() {
		return this.models;
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
