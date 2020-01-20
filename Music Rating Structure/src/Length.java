//Needed Imports
import java.util.Scanner;

public class Length {
	
	private static int time;		//Length of the Song in seconds
	private static int minutes;		//Time in minutes
	private static int seconds;		//Time in seconds
	
	//Creating Length through user input
	public Length() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("How many minutes is the song?: ");
		minutes = input.nextInt();
		System.out.print("\nHow many seconds is the song?: ");
		seconds = input.nextInt();
		time = finalTime(seconds, minutes);
	}
	
	//Creating Length through initializing time
	public Length(int time) {
		Length.time = time;
		minutes = time / 60; 
		seconds = time % 60;
	}
	
	//Creating Length through initializing seconds and minutes
	public Length(int seconds, int minutes) {
		Length.seconds = seconds;
		Length.minutes = minutes;
		time = finalTime(seconds, minutes);
	}
	
	//Method to calculate the final time given minutes and seconds
	public int finalTime(int seconds, int minutes) {
		return (seconds + (minutes * 60));
	}
	
	//Getting the time
	public int getTime() {
		return time;
	}
	
		//Getting the Minutes
		public int getMinutes() {
			//TODO Finish Method
			return 0;
		}
		
		//Getting the Seconds
		public int getSeconds() {
			//TODO Finish Method
			return 0;
		}
	
	//Setting the time
	public boolean setTime(int time) {
		Length.time = time;
		return Length.time == time;
	}
	
		//Setting time with minutes and seconds
		public boolean setTime(int seconds, int minutes) {
			Length.seconds = seconds;
			Length.minutes = minutes;
			time = finalTime(seconds, minutes);
			return (Length.seconds == seconds && Length.minutes == minutes);
	}
}
