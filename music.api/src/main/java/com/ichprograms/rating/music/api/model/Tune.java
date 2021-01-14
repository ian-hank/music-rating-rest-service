package com.ichprograms.rating.music.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//TODO Import Lombok to auto-generate setters and getters
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;

//@Getter
//@Setter
//@ToString
@Document(collection = "Tune")
public class Tune {
	
	@Id
	private int id;					//Tunes UID
	private String song;			//Name of the Song
	private String album;			//Name of the Album
	private String author;			//Name of the Author
	private String genre;			//Name of the Genre
	
	private int month;				//Month Released
	private int year;				//Year Released
	
	private long ratingCount = 0;
	private double overallRating;
	
	//Gets the Tunes ID
	public int getId() {
		return this.id;
	}
	
	//Gets the Tunes Song name
	public String getSong() {
		return this.song;
	}
	
	//Gets the Tunes Album name
	public String getAlbum() {
		return this.album;
	}
	
	//Gets the Tunes Authors name
	public String getAuthor() {
		return this.author;
	}
	
	//Gets the Tunes Genre
	public String getGenre() {
		return this.genre;
	}
	
	//Gets the Tunes Month released
	public int getMonth() {
		return this.month;
	}
	
	//Gets the Tunes Year released
	public int getYear() {
		return this.year;
	}
	
	//Sets the Tunes Song name
	public boolean setSong(String name) {
		this.song = name;
		return this.song == name;
	}
	
	//Sets the Tunes Album name
	public boolean setAlbum(String name) {
		this.album = name;
		return this.album == name;
	}
	
	//Sets the Tunes Authors name
	public boolean setAuthor(String name) {
		this.author = name;
		return this.author == name;
	}
	
	//Sets the Tunes Genre
	public boolean setGenre(String name) {
		this.genre = name;
		return this.genre == name;
	}
	
	//Sets the Tunes Month released
	public boolean setMonth(int name) {
		this.month = name;
		return this.month == name;
	}
	
	//Sets the Tunes Year released
	public boolean setYear(int name) {
		this.year = name;
		return this.year == name;
	}
	
	//TODO Fix eclipse generated methods
	public double getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(double overallRating) {
		this.overallRating = overallRating;
	}

	public long getRatingCount() {
		return ratingCount;
	}

	public void setRatingCount(long ratingCount) {
		this.ratingCount = ratingCount;
	}	
}