package domain.model;

import java.util.Date;

public class ModelClass {

	private Date date;
	private String artist;
	private String title;
	private String url;

	public ModelClass(String artist, String title, String url) {
		this.setDate();
		this.setArtist(artist);
		this.setTitle(title);
		this.setUrl(url);
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return this.getArtist() + ":   " + this.getTitle();
	}
}
