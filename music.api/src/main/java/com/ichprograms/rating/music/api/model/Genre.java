package com.ichprograms.rating.music.api.model;

public class Genre {
	
	private String mainGenre;
	private String subGenre;
	
	public Genre() {
		super();
	}
	
	//Constructor
	public Genre(String mainGenre, String subGenre) {
		super();
		this.mainGenre = mainGenre;
		this.subGenre = subGenre;
	}
	
	//Getters
	public String getMainGenre() {
		return this.mainGenre;
	}
	
	public String getSubGenre() {
		return this.subGenre;
	}
	
	//Setters
	public boolean setMainGenre(String mainGenre) {
		this.mainGenre = mainGenre;
		return this.mainGenre == mainGenre;
	}
	
	public boolean setSubGenre(String subGenre) {
		this.subGenre = subGenre;
		return this.subGenre == subGenre;
	}
}
