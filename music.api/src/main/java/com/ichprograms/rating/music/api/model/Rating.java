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
@Document(collection = "Rating")
public class Rating {
	
	//Constant Variables
	private final double CREATIVITY_WEIGHT = 1.0;
	private final double HARMONICS_WEIGHT = 0.9;
	private final double LYRICS_WEIGHT = 0.8;
	private final double PRODUCTION_WEIGHT = 0.7;
	private final double ORIGINALITY_WEIGHT = 0.6;
	
	@Id
	private int id;							//Rating _id
	private int userId;						//User Id
	private int tuneId;						//Matching Tune Id

	
	//Instance Variables
	private double finalRating;				//Overall Rating of the song
	private double creativity;				//Creativity rating or potential impact of the song on the industry
	private double harmonics;				//Rating for main beat/bass line/melody or whatever it is
	private double lyrics;					//Rating for the lyrics if the song has none a mood rating felt throughout song
	private double production;				//Overall rating for production and finishing design of the song
	private double originality;				//Originality or Uniqueness of the song
	
	//Gets document Id
	public int getId() {
		return id;
	}
	
	//Gets user's Id
	public int getUserId() {
		return userId;
	}
	
	//Gets tune's Id
	public int getTuneId() {
		return tuneId;
	}
	
	//Gets final Rating of the song
	public double getRating() {
		return finalRating;
	}
	
	//Gets the creativity rating of the song
	public double getCreativity() {
		return this.creativity;
	}

	//Gets the harmonics rating of the song
	public double getHarmonics() {
		return this.harmonics;
	}
		
	//Gets the lyrics rating of the song
	public double getLyrics() {
		return this.lyrics;
	}
		
	//Gets the production rating of the song
	public double getProduction() {
		return this.production;
	}
		
	//Gets the originality rating of the song
	public double getOriginality() {
		return this.originality;
	}
	
	//Sets the creativity rating of the song
	public boolean setCreativity(double rating) {
		this.creativity = rating;
		finalRating = calcFinalRating(creativity, harmonics, lyrics, production, originality);
		return this.creativity == creativity;
	}
			
	//Sets the harmonics rating of the song
	public boolean setHarmonics(double rating) {
		this.harmonics = rating;
		finalRating = calcFinalRating(creativity, harmonics, lyrics, production, originality);
		return this.harmonics == rating;
	}
	
	//Sets the lyrics of the song
	public boolean setLyrics(double rating) {
		this.lyrics = rating;
		finalRating = calcFinalRating(creativity, harmonics, lyrics, production, originality);
		return this.lyrics == rating;
	}
			
	//Sets the production of the song
	public boolean setProduction(double rating) {
		this.production = rating;
		finalRating = calcFinalRating(creativity, harmonics, lyrics, production, originality);
		return this.production == rating;
	}
			
	//Sets the originality of the song
	public boolean setOriginality(double rating) {
		this.originality = rating;
		finalRating = calcFinalRating(creativity, harmonics, lyrics, production, originality);
		return this.originality == rating;
	}

	//Sets the rating of the song
	public boolean setRating(double creativity, double harmonics, double lyrics, double production, double originality) {
		this.creativity = creativity;
		this.harmonics = harmonics;
		this.lyrics = lyrics;
		this.production = production;
		this.originality = originality;
		
		finalRating = calcFinalRating(creativity, harmonics, lyrics, production, originality);
		return calcFinalRating(creativity, harmonics, lyrics, production, originality) == finalRating;
	}
	
	//Calculates the final overall rating with the sub scores given or initialized
	public double calcFinalRating(double creativity, double harmonics, double lyrics, double production, double originality) {
		creativity = creativity * CREATIVITY_WEIGHT;
		harmonics = harmonics * HARMONICS_WEIGHT;
		lyrics = lyrics * LYRICS_WEIGHT;
		production = production * PRODUCTION_WEIGHT;
		originality = originality * ORIGINALITY_WEIGHT;
		
		double overall = creativity + harmonics + lyrics + production + originality;
		return overall;
	}
}