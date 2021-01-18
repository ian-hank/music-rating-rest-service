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
	
	@Id
	private String id;							//Rating UID
	private String tuneId;						//Matching song UID
	private String user;						//User UID

	private double songwriting;
	private double audioProduction;
	private double consistency;
	private double memorability;
	private double uniqueness;
	
	private double finalRating;				//Overall Rating of the song
	
	//Gets document Id
	public String getId() {
		return this.id;
	}
	
	//Gets songs's Id
	public String getTuneId() {
		return this.tuneId;
	}
	
	//Gets user's Id
	public String getUser() {
		return this.user;
	}
	
	//Gets the songwriting rating of the song
	public double getSongwriting() {
		return this.songwriting;
	}

	//Gets the audio production rating of the song
	public double getaudioProduction() {
		return this.audioProduction;
	}
		
	//Gets the consistency rating of the song
	public double getConsistency() {
		return this.consistency;
	}
		
	//Gets the memorability rating of the song
	public double getMemorability() {
		return this.memorability;
	}
		
	//Gets the uniqueness rating of the song
	public double getUniqueness() {
		return this.uniqueness;
	}
	
	//Gets final Rating of the song
	public double getFinalRating() {
		return this.finalRating;
	}
	
	//Sets the songwriting rating of the song
	public boolean setSongwriting(double rating) {
		this.songwriting = rating;
		finalRating = calcFinalRating(songwriting, audioProduction, consistency, memorability, uniqueness);
		return this.songwriting == songwriting;
	}
			
	//Sets the audio production rating of the song
	public boolean setAudioProduction(double rating) {
		this.audioProduction = rating;
		finalRating = calcFinalRating(songwriting, audioProduction, consistency, memorability, uniqueness);
		return this.audioProduction == rating;
	}
	
	//Sets the consistency rating of the song
	public boolean setConsistency(double rating) {
		this.consistency = rating;
		finalRating = calcFinalRating(songwriting, audioProduction, consistency, memorability, uniqueness);
		return this.consistency == rating;
	}
			
	//Sets the memorability rating of the song
	public boolean setMemorability(double rating) {
		this.memorability = rating;
		finalRating = calcFinalRating(songwriting, audioProduction, consistency, memorability, uniqueness);
		return this.memorability == rating;
	}
			
	//Sets the uniqueness rating of the song
	public boolean setUniqueness(double rating) {
		this.uniqueness = rating;
		finalRating = calcFinalRating(songwriting, audioProduction, consistency, memorability, uniqueness);
		return this.uniqueness == rating;
	}

	//Sets the rating of the song
	public boolean setRating(double songwriting, double audioProduction, double consistency, double memorability, double uniqueness) {
		this.songwriting = songwriting;
		this.audioProduction = audioProduction;
		this.consistency = consistency;
		this.memorability = memorability;
		this.uniqueness = uniqueness;
		
		finalRating = calcFinalRating(songwriting, audioProduction, consistency, memorability, uniqueness);
		return calcFinalRating(songwriting, audioProduction, consistency, memorability, uniqueness) == finalRating;
	}
	
	//Calculates the final overall rating with the sub scores given or initialized
	public double calcFinalRating(double songwriting, double audioProduction, double consistency, double memorability, double uniqueness) {
		
		//Constant Variables for Rating's components
		final double SONGWRITING_WEIGHT = 1.0;
		final double AUDIO_PRODUCTION_WEIGHT = 0.9;
		final double CONSISTENCY_WEIGHT = 0.8;
		final double MEMORABILITY_WEIGHT = 0.7;
		final double UNIQUENESS_WEIGHT = 0.6;
		
		songwriting = songwriting * SONGWRITING_WEIGHT;
		audioProduction = audioProduction * AUDIO_PRODUCTION_WEIGHT;
		consistency = consistency * CONSISTENCY_WEIGHT;
		memorability = memorability * MEMORABILITY_WEIGHT;
		uniqueness = uniqueness * UNIQUENESS_WEIGHT;
		
		double overall = songwriting + audioProduction + consistency + memorability + uniqueness;
		return overall;
	}
}