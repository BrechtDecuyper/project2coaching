package domain.model;

import java.util.Date;

public class ModelClass {

	private Date date;
	private String artist;
	private String title;

	public ModelClass(String artist, String title) {
		this.setDate();
		this.setArtist(artist);
		this.setTitle(title);
	}
		
	public Date getDate() {
		return date;
	}

	public void setDate() {
		this.date = new Date();
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void setArtist(String artist) {
		if(artist == null || artist.isEmpty()){
			throw new IllegalArgumentException("Wrong artist given.");
		}
		this.artist = artist;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		if(title == null || title.isEmpty()){
			throw new IllegalArgumentException("Wrong title given.");
		}
		this.title = title;
	}
	
	@Override
	public String toString() {
		return this.getArtist() + ":   " + this.getTitle();
	}
}
