package com.ichprograms.rating.music.api.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//TODO Import Lombok to auto-generate setters and getters
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;

//@Getter
//@Setter
//@ToString
@Document(collection = "Song")
public class Song {
	
	@Id
	private String id;					//Songs UID
	
	private String song;			//Name of the Song
	private String album;			//Name of the Album
	private String author;			//Name of the Author
	private String genre;			//Name of the Genre
	
	private int month;				//Month Released
	private int year;				//Year Released
	
	private List<Rating> ratings;
	private long totalRatingCount = 0;
	private double overallRating;
	private double topGenreRating;
	private double topCriticRating;
	
	//Gets the song's ID
	public String getId() {
		return this.id;
	}
	
	//Gets the song's name
	public String getSong() {
		return this.song;
	}
	
	//Gets the song's Album name
	public String getAlbum() {
		return this.album;
	}
	
	//Gets the song's Authors name
	public String getAuthor() {
		return this.author;
	}
	
	//Gets the song's Genre
	public String getGenre() {
		return this.genre;
	}
	
	//Gets the song's Month released
	public int getMonth() {
		return this.month;
	}
	
	//Gets the song's Year released
	public int getYear() {
		return this.year;
	}
	
	//Gets the # of times song was rated
	public long getRatingCount() {
		return this.totalRatingCount;
	}
	
	//Gets the song's overall rating
	public double getOverallRating() {
		return this.overallRating;
	}
	
	//Sets the song's name
	public boolean setSong(String name) {
		this.song = name;
		return this.song == name;
	}
	
	//Sets the song's Album name
	public boolean setAlbum(String name) {
		this.album = name;
		return this.album == name;
	}
	
	//Sets the song's Authors name
	public boolean setAuthor(String name) {
		this.author = name;
		return this.author == name;
	}
	
	//Sets the song's Genre
	public boolean setGenre(String name) {
		this.genre = name;
		return this.genre == name;
	}
	
	//Sets the song's Month released
	public boolean setMonth(int name) {
		this.month = name;
		return this.month == name;
	}
	
	//Sets the song's Year released
	public boolean setYear(int name) {
		this.year = name;
		return this.year == name;
	}
	
	//Sets the rating count
	@SuppressWarnings("unused") //need privileges before this can be added
	private boolean setRatingCount(long ratingCount) {
			this.totalRatingCount = ratingCount;
			return this.totalRatingCount == ratingCount;
		}
	
	//Sets the overall Rating
	@SuppressWarnings("unused") //need privileges before this can be added
	private boolean setOverallRating(double overallRating) {
		this.overallRating = overallRating;
		return this.overallRating == overallRating;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public double getTopGenreRating() {
		return topGenreRating;
	}

	public void setTopGenreRating(double topGenreRating) {
		this.topGenreRating = topGenreRating;
	}

	public double getTopCriticRating() {
		return topCriticRating;
	}

	public void setTopCriticRating(double topCriticRating) {
		this.topCriticRating = topCriticRating;
	}

		
}