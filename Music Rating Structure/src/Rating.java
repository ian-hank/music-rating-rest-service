//Needed imports
import java.io.Serializable;
import java.util.Scanner;

public class Rating implements Serializable {
	
	private static final long serialVersionUID = 1403141259525473554L;
	
	//Constant Variables
	private final double CREATIVITY_WEIGHT = 1.0;
	private final double HARMONICS_WEIGHT = 0.9;
	private final double LYRICS_WEIGHT = 0.8;
	private final double PRODUCTION_WEIGHT = 0.7;
	private final double ORIGINALITY_WEIGHT = 0.6;
	
	//Instance Variables
	private double finalRating;				//Overall Rating of the song
	private double creativity;				//Creativity rating or potential impact of the song on the industry
	private double harmonics;				//Rating for main beat/bass line/melody or whatever it is
	private double lyrics;					//Rating for the lyrics if the song has none a mood rating felt throughout song
	private double production;				//Overall rating for production and finishing design of the song
	private double originality;				//Originality or Uniqueness of the song
	
	//Creating new rating through user input
	public Rating() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		//User Input checking for Double
		boolean answered = false;
		while(!answered) {
			try {
				//Creativity
				do {
					System.out.print("On a scale of 1-10 how would you rate the Creativity/Potential impact of the song?: ");
					creativity = Double.parseDouble(input.nextLine());
				} while (creativity < 0 || creativity > 10);
				//Harmonics
				do {
					System.out.print("On a scale of 1-10 how would you rate the Melody/Harmonics/Beat of the song?: ");
					harmonics = Double.parseDouble(input.nextLine());
				} while (harmonics < 0 || harmonics > 10);
				//Lyrics
				do {
					System.out.print("On a scale of 1-10 how would you rate the Lyrics or Mood if it has no lyrics: ");
					lyrics = Double.parseDouble(input.nextLine());
				} while (lyrics < 0 || lyrics > 10);
				//Production
				do {
					System.out.print("On a scale of 1-10 how would you rate the Production/Design of the song: ");
					production = Double.parseDouble(input.nextLine());
				} while (production < 0 || production > 10);
				//Originality
				do {
					System.out.print("On a scale of 1-10 how would you rate the Originality/Uniqueness of the song?: ");
					originality = Double.parseDouble(input.nextLine());
				} while (originality < 0 || originality > 10);
				//Exit Statement
				answered = true;
			}
			catch (NumberFormatException e) {
				System.out.println("Please enter only double values for these ratings(Starting Over)...");
			}
		}
		finalRating = calcFinalRating(creativity, harmonics, lyrics, production, originality);
	}
	
	//Creating new rating through initialization
	public Rating(double creativity, double harmonics, double lyrics, double production, double originality) {
		this.creativity = creativity;
		this.harmonics = harmonics;
		this.lyrics = lyrics;
		this.production = production;
		this.originality = originality;
		
		finalRating = calcFinalRating(creativity, harmonics, lyrics, production, originality);
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
			
	//Sets the creativity of the song
	public boolean setLyrics(double rating) {
		this.lyrics = rating;
		finalRating = calcFinalRating(creativity, harmonics, lyrics, production, originality);
		return this.lyrics == rating;
	}
			
	//Sets the creativity of the song
	public boolean setProduction(double rating) {
		this.production = rating;
		finalRating = calcFinalRating(creativity, harmonics, lyrics, production, originality);
		return this.production == rating;
	}
			
	//Sets the creativity of the song
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