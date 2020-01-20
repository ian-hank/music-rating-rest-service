//Needed imports
import java.util.Scanner;

public class Rating {
	
	private static double finalRating;				//Overall Rating of the song
	private static double creativity;				//Creativity rating or potential impact of the song on the industry
	private static double harmonics;				//Rating for main beat/bass line/melody or whatever it is
	private static double lyrics;					//Rating for the lyrics if the song has none a mood rating felt throughout song
	private static double production;				//Overall rating for production and finishing design of the song
	private static double originality;				//Originality or Uniqueness of the song
	
	//Creating new rating through user input
	public Rating() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("On a scale of 1-10 how would you rate the Creativity/Potential impact of the song?: ");
		creativity = input.nextDouble();
		System.out.print("\nOn a scale of 1-10 how would you rate the Melody/Harmonics/Beat of the song?: ");
		harmonics = input.nextDouble();
		System.out.print("\nOn a scale of 1-10 how would you rate the Lyrics or Mood if it has no lyrics: ");
		lyrics = input.nextDouble();
		System.out.print("\nOn a scale of 1-10 how would you rate the Production/Design of the song: ");
		production = input.nextDouble();
		System.out.print("\nOn a scale of 1-10 how would you rate the Originality/Uniqueness of the song?: ");
		originality = input.nextDouble();
		
		finalRating = calcFinalRating(creativity, harmonics, lyrics, production, originality);
	}
	
	//Creating new rating through initialization
	public Rating(double creativity, double harmonics, double lyrics, double production, double originality) {
		Rating.creativity = creativity;
		Rating.harmonics = harmonics;
		Rating.lyrics = lyrics;
		Rating.production = production;
		Rating.originality = originality;
		
		finalRating = calcFinalRating(creativity, harmonics, lyrics, production, originality);
	}
	
	//Gets final Rating of the song
	public double getRating() {
		return finalRating;
	}
	
		//Gets the creativity of the song
		public double getCreativity() {
			//TODO Finish Method
			return 0;
		}
		
		//Gets the creativity of the song
		public double getHarmonics() {
			//TODO Finish Method
			return 0;
		}
		
		//Gets the creativity of the song
		public double getLyrics() {
			//TODO Finish Method
			return 0;
		}
		
		//Gets the creativity of the song
		public double getProduction() {
			//TODO Finish Method
			return 0;
		}
		
		//Gets the creativity of the song
		public double getOriginality() {
			//TODO Finish Method
			return 0;
		}
		
	//Sets the rating of the song
	public boolean setRating(double creativity, double harmonics, double lyrics, double production, double originality) {
		Rating.creativity = creativity;
		Rating.harmonics = harmonics;
		Rating.lyrics = lyrics;
		Rating.production = production;
		Rating.originality = originality;
		
		finalRating = calcFinalRating(creativity, harmonics, lyrics, production, originality);
		return calcFinalRating(creativity, harmonics, lyrics, production, originality) == finalRating;
	}
	
	//Calculates the final overall rating with the sub scores given or initialized
	public double calcFinalRating(double creativity, double harmonics, double lyrics, double production, double originality) {
		creativity = creativity * 1;
		harmonics = harmonics * 0.9;
		lyrics = lyrics * 0.8;
		production = production * 0.7;
		originality = originality * 0.6;
		
		double overall = creativity + harmonics + lyrics + production + originality;
		return overall;
	}
}
